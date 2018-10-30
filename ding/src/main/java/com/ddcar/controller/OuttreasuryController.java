package com.ddcar.controller;

import com.common.BaseBean;
import com.common.Commonparam;
import com.ddcar.entity.TbInout;
import com.ddcar.service.OuttreasuryService;
import com.ddcar.service.WarehousingService;
import com.ddcar.util.UtilLog;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Administrator on 2018-09-05.
 */
@Controller
@RequestMapping("/out")
public class OuttreasuryController {

    @Resource
    OuttreasuryService outtreasuryService;

    @RequestMapping(value = "/findTbInoutListout")
    public @ResponseBody
    BaseBean findTbInoutList(Integer page, Integer size) throws Exception {
        BaseBean bean = new BaseBean();
        try {
            List<TbInout> list=outtreasuryService.findTbInoutListout(page,size);
            bean.setStatus(200);
            bean.setRows(list);
            bean.setTotal(new PageInfo<>(list).getTotal());

        } catch (Exception e) {
            bean.setMsg(Commonparam.handle(e));
            UtilLog.logger.error("错误：",e);
        }
        return bean;
    }
}
