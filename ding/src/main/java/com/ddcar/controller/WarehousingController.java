package com.ddcar.controller;

import com.common.BaseBean;
import com.common.Commonparam;
import com.ddcar.entity.*;
import com.ddcar.mapper.TbInoutMapper;
import com.ddcar.service.TbVehicleService;
import com.ddcar.service.WarehousingService;
import com.ddcar.util.CommUtil;
import com.ddcar.util.UtilLog;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2018-08-31.
 */
@Controller
@RequestMapping("/warehousing")
public class WarehousingController {


   @Resource
    WarehousingService warehousingService;

   @Resource
    TbVehicleService tbVehicleService;

    private String msg;


    @RequestMapping(value = "/findTbInoutList")
    public @ResponseBody
    BaseBean findTbInoutList(Integer page, Integer size) throws Exception {
        BaseBean bean = new BaseBean();
        try {
            List<TbInout> list=warehousingService.findTbInoutList(page,size);
            bean.setStatus(200);
            bean.setRows(list);
            bean.setTotal(new PageInfo<>(list).getTotal());

        } catch (Exception e) {
            bean.setMsg(Commonparam.handle(e));
            UtilLog.logger.error("错误：",e);
        }
        return bean;
    }

    //新车入库
    @ResponseBody
    @RequestMapping("/add")
    public BaseBean add(TbVehicle tbVehicle, HttpSession session){
        BaseBean baseBean=new BaseBean();
        try{
            Integer ifvin = tbVehicleService.ifvin(tbVehicle.getVin());
            if (ifvin>0){
                baseBean.setMsg("车架号已存在！");
                return baseBean;
            }
            Integer ifgps = tbVehicleService.ifgps(tbVehicle.getGpsNumber());
            if (ifgps>0){
                baseBean.setMsg("GPS号已存在！");
                return baseBean;
            }
            Integer ifserial = tbVehicleService.ifserial(tbVehicle.getSerialNumber());
            if (ifserial>0){
                baseBean.setMsg("预留编号已存在！");
                return baseBean;
            }

            TbManager companyId =  (TbManager) session.getAttribute("dcoinManagerInfo");
            String com=companyId.getUserName();
            tbVehicle.setDeleteFlag(0);
            tbVehicle.setState("0");
            //生成二维码号
            Long vehicle=tbVehicleService.maxqrcode();
            tbVehicle.setQrCode(CommUtil.getCarCode(1,vehicle));
            tbVehicle.setCreateBy(com);
            Date date=new Date();
            /*DateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");*/
            DateFormat format=new SimpleDateFormat("yyyy-MM-dd");
            String time=format.format(date);
            tbVehicle.setCreateTime(time);
            tbVehicleService.add(tbVehicle);
            baseBean.setStatus(200);
            baseBean.setMsg("添加成功");
        }catch(RuntimeException ex){
            baseBean.setMsg(Commonparam.handle(ex));
            Log.logger.error(msg,ex);
        }
        return baseBean;
    }
}