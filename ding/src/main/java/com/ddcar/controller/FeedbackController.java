package com.ddcar.controller;

import com.common.BaseBean;
import com.common.Commonparam;
import com.ddcar.entity.Feedback;
import com.ddcar.entity.TbModelNumber;
import com.ddcar.service.FeedbackService;
import com.ddcar.service.TbModelNumberService;
import com.ddcar.util.UtilLog;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;

/**
 * Created by Administrator on 2018-09-28.
 */
@Controller
@RequestMapping("/feed")
public class FeedbackController {

    @Autowired
    FeedbackService feedbackService;



    //查询所有型号
    @RequestMapping(value = "/findFeedback")
    public @ResponseBody
    BaseBean findTbManagerList(Integer page,Integer size,String content,Integer state,String userName){
        BaseBean bean = new BaseBean();
        try {
            List<HashMap> list=feedbackService.findFeedback(page,size,content,state,userName);
            bean.setStatus(200);
            bean.setRows(list);
            bean.setTotal(new PageInfo<>(list).getTotal());

        } catch (Exception e) {
            bean.setMsg(Commonparam.handle(e));
            UtilLog.logger.error("错误信息",e);
        }
        return bean;
    }

    //删除
    @RequestMapping("/del")
    @ResponseBody
    public BaseBean del(Long[] delArr) {
        BaseBean baseBean = new BaseBean();
        try {
            feedbackService.del(delArr);
            baseBean.setStatus(200);
        } catch (Exception e) {
            baseBean.setStatus(400);
            baseBean.setMsg(Commonparam.handle(e));
        }
        return baseBean;
    }
    //已处理
    @RequestMapping("/seate")
    @ResponseBody
    public BaseBean seate(Long[] delArr) {
        BaseBean baseBean = new BaseBean();
        try {
            feedbackService.seate(delArr);
            baseBean.setStatus(200);
        } catch (Exception e) {
            baseBean.setStatus(400);
            baseBean.setMsg(Commonparam.handle(e));
            UtilLog.logger.error("====",e);
        }
        return baseBean;
    }

    //根据feedbzckId查询
    @ResponseBody
    @RequestMapping("/feedbzckId")
    public BaseBean searchId(@RequestParam("feedbzckId")Long feedbzckId){
        BaseBean baseBean=new BaseBean();
        try {
            baseBean.setRows(feedbackService.selectFeedbzckId(feedbzckId));
            baseBean.setStatus(200);
        }catch (Exception e){
            baseBean.setMsg(Commonparam.handle(e));
            UtilLog.logger.error("错误信息",e);
        }
        return baseBean;
    }

}
