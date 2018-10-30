package com.ddcar.controller;

import com.common.BaseBean;
import com.common.Commonparam;
import com.ddcar.entity.Vehicles;
import com.ddcar.service.InOutWarehouseService;
import com.ddcar.util.UtilLog;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/inout")
public class WInOutWarehouseController {

    @Resource
    InOutWarehouseService inOutWarehouseService;

    @RequestMapping("/putIn")
    public @ResponseBody
    BaseBean putIn(long userId) {
        BaseBean bean = new BaseBean();
        try {
            List<Vehicles> vehicles = inOutWarehouseService.inWarehouse(userId);
            bean.setStatus(200);
            bean.setRows(vehicles);
        } catch (Exception e) {
            e.printStackTrace();
            UtilLog.logger.error("错误：",e);
        }
        return bean;
    }

    @RequestMapping("/inConfirm")
    public @ResponseBody
    BaseBean inConfirmIn(long userId, String ids) {
        Map map = new HashMap();
        BaseBean bean = new BaseBean();
        String[] split = ids.split(",");
        String date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
        map.put("modifyTime", date);
        map.put("userId", userId);
        map.put("ids", split);
        try {
            inOutWarehouseService.confirmInOut(map);
            bean.setStatus(200);
        } catch (Exception e) {
            e.printStackTrace();
            UtilLog.logger.error("错误：",e);
        }
        return bean;
    }

    @RequestMapping("/exitConfirm")
    public @ResponseBody
    BaseBean exitConfirm(long userId, String qrCode) {
        BaseBean bean = new BaseBean();
        try {
            int i = inOutWarehouseService.exitConfirm(userId, qrCode);
            if(i == 300){
                bean.setStatus(400);
                bean.setMsg("车电信息有误！");
            } else if (i == 100){
                bean.setStatus(400);
                bean.setMsg("车电未退租!");
            } else {
                bean.setStatus(i);
            }
        } catch (Exception e) {
            e.printStackTrace();
            UtilLog.logger.error("错误：",e);
        }
        return bean;
    }

    @RequestMapping("/exitVehicle")
    public @ResponseBody
    BaseBean exitVehicle(@RequestParam(value = "userId") long userId,
                         @RequestParam(value = "page", defaultValue = "1") Integer page,
                         @RequestParam(value = "size", defaultValue = "10") Integer size) {
        BaseBean bean = new BaseBean();
        try {
            List<Vehicles> vehicles = inOutWarehouseService.outWarehouse(userId, page, size);
            bean.setStatus(200);
            bean.setRows(vehicles);
        } catch (Exception e) {
            e.printStackTrace();
            UtilLog.logger.error("错误：",e);
        }
        return bean;
    }


}
