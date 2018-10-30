package com.ddcar.controller;

import com.alibaba.fastjson.JSON;
import com.common.BaseBean;
import com.common.Commonparam;
import com.ddcar.entity.*;
import com.ddcar.service.TbInoutService;
import com.ddcar.service.TbPriceService;
import com.ddcar.service.TbVehicleService;
import com.ddcar.util.UtilLog;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Administrator on 2018-09-03.
 */
@Controller
@RequestMapping("/price")
public class TbPriceController {

    @Autowired
    TbPriceService tbPriceService;

    private String msg;
    
    //查询该公司型号的价格
    @ResponseBody
    @RequestMapping("/modelprice")
    public BaseBean modelprice(HttpSession session,Integer page, Integer size,Integer modelId,Integer modelType,Integer brandId){
        TbManager companyId =  (TbManager) session.getAttribute("dcoinManagerInfo");
        Long com=companyId.getCompanyId();
        BaseBean baseBean=new BaseBean();
        try {
            List<HashMap> modelprice = tbPriceService.modelprice(page, size, com, modelId, modelType, brandId);
            baseBean.setRows(modelprice);
            baseBean.setStatus(200);
            baseBean.setTotal(new PageInfo<>(modelprice).getTotal());
        }catch (Exception e){
            baseBean.setMsg(Commonparam.handle(e));
            UtilLog.logger.error("错误信息",e);
        }
        return baseBean;
    }

    //设置价格
    @ResponseBody
    @RequestMapping("/setting")
    public BaseBean add(TbPrice tbPrice, HttpSession session){
        BaseBean baseBean=new BaseBean();
        TbManager companyId =  (TbManager) session.getAttribute("dcoinManagerInfo");
        String com=companyId.getUserName();//当前用户
        Long comid=companyId.getCompanyId();//当前用户所属分公司
        tbPrice.setBranchId(comid);
        tbPrice.setDeleteFlag(0);
        Date date=new Date();
        DateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String time=format.format(date);
        tbPrice.setCreateBy(com);
        tbPrice.setCreateTime(time);
        try{
            tbPriceService.add(tbPrice);
            baseBean.setStatus(200);
            baseBean.setMsg("设置成功");
        }catch(RuntimeException ex){
            baseBean.setMsg(Commonparam.handle(ex));
            Log.logger.error(msg,ex);
        }
        return baseBean;
    }

    //编辑价格
    @ResponseBody
    @RequestMapping("/editprice")
    public BaseBean editAddress(HttpSession session,TbPrice tbPrice){
        BaseBean baseBean=new BaseBean();
        try {
            TbManager companyId =  (TbManager) session.getAttribute("dcoinManagerInfo");
            String com=companyId.getUserName();
            Date date=new Date();
            DateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String time=format.format(date);
            tbPrice.setModifyBy(com);
            tbPrice.setModifyTime(time);
            tbPriceService.updatePrice(tbPrice);
            baseBean.setStatus(200);
            baseBean.setMsg("编辑成功");
        }catch (Exception ex){
            baseBean.setMsg(Commonparam.handle(ex));
            Log.logger.error("操作失败",ex);
        }
        return baseBean;
    }
}
