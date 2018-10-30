package com.ddcar.controller;

import com.common.BaseBean;
import com.common.Commonparam;
import com.ddcar.entity.TbDot;
import com.ddcar.service.TbDtoService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by Administrator on 2018-09-11.
 */
@Controller
@RequestMapping("/dot")
public class TbDotController {

    @Autowired
    TbDtoService tbDtoService;

    private String mag;

    @RequestMapping(value = "/findTbDot")
    public @ResponseBody
    BaseBean findTbManagerList(Integer page, Integer size) throws Exception {
        BaseBean bean = new BaseBean();
        try {
            List<TbDot> list=tbDtoService.findTbDot(page,size);
            bean.setStatus(200);
            bean.setRows(list);
            bean.setTotal(new PageInfo<>(list).getTotal());

        } catch (Exception e) {
            bean.setMsg(Commonparam.handle(e));
        }
        return bean;
    }

}
