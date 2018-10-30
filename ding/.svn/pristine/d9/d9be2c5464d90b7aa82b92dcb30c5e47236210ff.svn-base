package com.ddcar.controller;

import com.common.BaseBean;
import com.common.Commonparam;
import com.ddcar.entity.TbManager;
import com.ddcar.service.BilService;
import com.ddcar.service.TbVehicleService;
import com.ddcar.util.UtilLog;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Administrator on 2018-10-09.
 */
@Controller
@RequestMapping("/bil")
public class BilController {

    @Autowired
    BilService bilService;

    //平台查询流水
    @ResponseBody
    @RequestMapping("/flowList")
    public BaseBean flowList( Integer page, Integer size,String wangUserId,String start,String end,Long branchId){
        BaseBean baseBean=new BaseBean();
        try {
            List<HashMap> list = bilService.flowList(page,size,wangUserId,start,end,branchId);
            baseBean.setRows(list);
            baseBean.setTotal(new PageInfo<>(list).getTotal());
            baseBean.setStatus(200);
        }catch (Exception e){
            baseBean.setMsg(Commonparam.handle(e));
            UtilLog.logger.error("错误",e);
        }
        return baseBean;
    }


    //分公司查询流水
    @ResponseBody
    @RequestMapping("/accountFlow")
    public BaseBean accountFlow(HttpSession session, Integer page, Integer size,String wangUserId,String start,String end){
        BaseBean baseBean=new BaseBean();
        try {
            TbManager companyId =  (TbManager) session.getAttribute("dcoinManagerInfo");
            Long com=companyId.getCompanyId();
            List<HashMap> list = bilService.accountFlow(com,page,size,wangUserId,start,end);
            baseBean.setRows(list);
            baseBean.setTotal(new PageInfo<>(list).getTotal());
            baseBean.setStatus(200);
        }catch (Exception e){
            baseBean.setMsg(Commonparam.handle(e));
            UtilLog.logger.error("错误",e);
        }
        return baseBean;
    }
}
