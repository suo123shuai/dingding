package com.ddcar.controller;

import com.common.BaseBean;
import com.ddcar.service.VehicleStateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/vehicle")
public class VehicleStateController {

    @Autowired
    VehicleStateService vehicleState;

    @RequestMapping("/updstate")
    public @ResponseBody
    BaseBean vehicleState(String state, String modifyBy, String ids) {
        BaseBean bean  = new BaseBean();
        Map map = new HashMap();
        String[] split = ids.split(",");
        map.put("modifyBy",modifyBy);
        map.put("ids",split);
        map.put("state",state);
        map.put("modifyTime", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        vehicleState.updVehicle(map);
        bean.setStatus(200);
        return bean;
    }
}
