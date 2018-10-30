package com.ddcar.controller;

import com.common.BaseBean;
import com.ddcar.entity.TbInvoice;
import com.ddcar.entity.TbVehicle;
import com.ddcar.entity.Vehicles;
import com.ddcar.mapper.TbUserMapper;
import com.ddcar.service.RiderMyVehicleService;
import com.ddcar.util.UtilLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/rider/my/")
public class RiderMyVehicleController {

    @Autowired
    private RiderMyVehicleService riderMyVehicleService;
    @Autowired
    private TbUserMapper tbUserMapper;

    @RequestMapping("/vehicle")
    public @ResponseBody
    BaseBean findUserVehicle(long userId) {
        BaseBean bean = new BaseBean();
        try {
            List<Vehicles> userVehicle = riderMyVehicleService.findUserVehicle(userId);
            bean.setStatus(200);
            bean.setRows(userVehicle);
        } catch (Exception e) {
            e.printStackTrace();
            UtilLog.logger.error("错误：", e);
        }
        return bean;
    }

    @RequestMapping("/saveInvoice")
    public @ResponseBody
    BaseBean saveInvoice(TbInvoice invoice) {
        BaseBean bean = new BaseBean();
        try {
            int i = riderMyVehicleService.saveInvoice(invoice);
            if (i > 0) {
                bean.setStatus(200);
                bean.setMsg("成功");
            } else {
                bean.setStatus(400);
                bean.setMsg("失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
            UtilLog.logger.error("错误", e);
        }
        return bean;
    }

    @RequestMapping("/findVehicle")
    public @ResponseBody
    BaseBean findVehicle(String qrCode, Long userId) {
        BaseBean bean = new BaseBean();
        Map map = new HashMap();
        map.put("qrCode", qrCode);
        map.put("userId", userId);
        try {
            TbVehicle vehicle = riderMyVehicleService.getVehicleByUserIdAndVehicleId(map);
            if (null == vehicle) {
                bean.setStatus(400);
                bean.setMsg("未购买该车电");
            } else {
                bean.setStatus(200);
                bean.setRows(vehicle);
            }
        } catch (Exception e) {
            e.printStackTrace();
            UtilLog.logger.error("错误", e);
        }
        return bean;
    }

    @RequestMapping("/updateTuiState")
    public @ResponseBody
    BaseBean updateTuiState(Long userId, int tuiState) {
        BaseBean bean = new BaseBean();
        Map map = new HashMap();
        map.put("userId", userId);
        map.put("tuiState", tuiState);
        try {
            int i = riderMyVehicleService.updateUserTuiState(map);
            if (i > 0) {
                bean.setStatus(200);
            } else {
                bean.setStatus(400);
                bean.setMsg("更新失败！");
            }
        } catch (Exception e) {
            e.printStackTrace();
            UtilLog.logger.error("错误", e);
        }
        return bean;
    }
}
