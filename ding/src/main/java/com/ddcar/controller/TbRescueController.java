package com.ddcar.controller;

import com.common.BaseBean;
import com.common.Commonparam;
import com.ddcar.entity.TbManager;
import com.ddcar.entity.TbRescue;
import com.ddcar.mapper.TbRescueMapper;
import com.ddcar.service.TbRescueService;
import com.ddcar.service.TbVehicleService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Administrator on 2018-09-14.
 */
@Controller
@RequestMapping("/rescue")
public class TbRescueController {

    @Autowired
    TbRescueService tbRescueService;

    //查询分公司的救援信息
    @ResponseBody
    @RequestMapping("/rescueList")
    public BaseBean okTbVehicleList(HttpSession session, Integer page, Integer size,String userName,String phone){
        TbManager companyId =  (TbManager) session.getAttribute("dcoinManagerInfo");
        Long com=companyId.getCompanyId();
        BaseBean baseBean=new BaseBean();
        try {
            List<HashMap> list = tbRescueService.rescueList(page, size, com, userName, phone);
            baseBean.setRows(list);
            baseBean.setTotal(new PageInfo<>(list).getTotal());
            baseBean.setStatus(200);
        }catch (Exception e){
            baseBean.setMsg(Commonparam.handle(e));
        }
        return baseBean;
    }
}
