package com.ddcar.controller;

import com.common.BaseBean;
import com.common.DoubleOperation;
import com.ddcar.entity.*;
import com.ddcar.service.WangMyModelService;
import com.ddcar.util.UtilLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/my")
public class WangMyModelController {

    @Autowired
    WangMyModelService wangMyModel;

    @RequestMapping("/vehicles")
    public @ResponseBody
    BaseBean findUserVehicle(@RequestParam("wangUserId") long wangUserId,
                             @RequestParam("type") String type,
                             @RequestParam(value = "page", defaultValue = "1") Integer page,
                             @RequestParam(value = "size", defaultValue = "10") Integer size) {
        Map map = new HashMap();
        BaseBean bean = new BaseBean();
        map.put("wangUserId", wangUserId);
        map.put("type", type);
        try {
            List<Vehicles> userVehicle = wangMyModel.findUserVehicle(map, page, size);
            bean.setStatus(200);
            bean.setRows(userVehicle);
        } catch (Exception e) {
            e.printStackTrace();
            UtilLog.logger.error("错误：", e);
        }
        return bean;
    }

    @RequestMapping("/qrCode")
    public @ResponseBody
    BaseBean myQrCode(long userId) {
        BaseBean bean = new BaseBean();
        try {
            String qrCode = wangMyModel.fiindUserQrCode(userId);
            bean.setStatus(200);
            bean.setRows(qrCode);
        } catch (Exception e) {
            e.printStackTrace();
            UtilLog.logger.error("错误：", e);
        }
        return bean;
    }

    @RequestMapping("/vehicleParticular")
    public @ResponseBody
    BaseBean findUserVehicleParticular(long vehicleId) {
        BaseBean bean = new BaseBean();
        try {
            Vehicles userVehicle = wangMyModel.findUserVehicleParticular(vehicleId);
            bean.setStatus(200);
            bean.setRows(userVehicle);
        } catch (Exception e) {
            e.printStackTrace();
            UtilLog.logger.error("错误：", e);
        }
        return bean;
    }

    @RequestMapping("/listUser")
    public @ResponseBody
    BaseBean listUser(@RequestParam("wangUserId") long wangUserId,
                      @RequestParam(value = "page", defaultValue = "1") Integer page,
                      @RequestParam(value = "size", defaultValue = "10") Integer size) {
        BaseBean bean = new BaseBean();
        try {
            List<TbUser> tbUsers = wangMyModel.listUser(wangUserId, page, size);
            bean.setStatus(200);
            bean.setRows(tbUsers);
        } catch (Exception e) {
            e.printStackTrace();
            UtilLog.logger.error("错误：", e);
        }
        return bean;
    }

    @RequestMapping("/userCheck")
    public @ResponseBody
    BaseBean userCheck(String state, long userId, String modifyBy) {
        BaseBean bean = new BaseBean();
        Map map = new HashMap();
        map.put("state", state);
        map.put("userId", userId);
        map.put("modifyBy", modifyBy);
        map.put("modifyTime", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        try {
            wangMyModel.updUserState(map);
            bean.setStatus(200);
        } catch (Exception e) {
            e.printStackTrace();
            UtilLog.logger.error("错误：", e);
        }
        return bean;
    }

    @RequestMapping("/findUserVehicle")
    public @ResponseBody
    BaseBean findUserVehicle(long userId,
                             @RequestParam(defaultValue = "1") Integer page,
                             @RequestParam(defaultValue = "10") Integer size) {
        BaseBean bean = new BaseBean();
        try {
            UserOrderVehicleItme userVehicle = wangMyModel.findUserVehicle(userId, page, size);
            bean.setStatus(200);
            bean.setRows(userVehicle);
        } catch (Exception e) {
            e.printStackTrace();
            UtilLog.logger.error("错误：", e);
        }
        return bean;
    }

    @RequestMapping("/findUserByLike")
    public @ResponseBody
    BaseBean findUserByLike(@RequestParam(value = "fuzzyField", defaultValue = "null") String fuzzyField,
                            @RequestParam(value = "wangUserId") Long wangUserId,
                            @RequestParam(value = "page", defaultValue = "1") Integer page,
                            @RequestParam(value = "size", defaultValue = "10") Integer size) {
        BaseBean bean = new BaseBean();
        Map map = new HashMap();

        try {
            List<TbUser> user;
            if (fuzzyField.equals("null")) {
                user = wangMyModel.listUser(wangUserId, page, size);
            } else {
                map.put("fuzzyField", fuzzyField);
                map.put("wangUserId", wangUserId);
                user = wangMyModel.findUserByLike(map, page, size);
            }
            bean.setStatus(200);
            bean.setRows(user);
        } catch (Exception e) {
            e.printStackTrace();
            UtilLog.logger.error("错误：", e);
        }
        return bean;
    }

    @RequestMapping("/userReview")
    public @ResponseBody
    BaseBean userReview(long userId) {
        BaseBean bean = new BaseBean();
        try {
            TbUser user = wangMyModel.getUserByUserId(userId);
            bean.setStatus(200);
            bean.setRows(user);
        } catch (Exception e) {
            e.printStackTrace();
            UtilLog.logger.error("错误", e);
        }
        return bean;
    }

    @RequestMapping("/untiedUser")
    public @ResponseBody
    BaseBean untiedUser(long userId, long wangUserId) {
        BaseBean bean = new BaseBean();
        Map map = new HashMap();
        map.put("userId", userId);
        map.put("wangUserId", wangUserId);
        try {
            int i = wangMyModel.updUserEmptyState(map);
            if (i == 0) {
                bean.setStatus(400);
                bean.setMsg("无法解绑，请先退还车电！");
            } else {
                bean.setStatus(200);
                bean.setMsg("解绑成功");
            }
        } catch (Exception e) {
            e.printStackTrace();
            UtilLog.logger.error("错误", e);
        }
        return bean;
    }

    @RequestMapping("/sumDeposit")
    public @ResponseBody
    BaseBean getDeposit(@RequestParam(value = "makeUpAmount", defaultValue = "0") double makeUpAmount,
                        String id) {
        BaseBean bean = new BaseBean();
        String[] ids = id.split(",");
        try {
            Double deposit = wangMyModel.getDeposit(ids);
            bean.setStatus(200);
            double total = DoubleOperation.sub(deposit, makeUpAmount);
            Map map = new HashMap();
            map.put("deposit", deposit);
            map.put("total", total);
            bean.setRows(map);
        } catch (Exception e) {
            e.printStackTrace();
            UtilLog.logger.error("错误", e);
        }
        return bean;
    }

    @RequestMapping("/wang/flow")
    public @ResponseBody
    BaseBean wangFlow(@RequestParam(value = "page", defaultValue = "1") Integer page,
                      @RequestParam(value = "size", defaultValue = "10") Integer size,
                      Long wangUserId) {
        BaseBean bean = new BaseBean();
        try {
            AmountAndFlow wangFlow = wangMyModel.findWangFlow(wangUserId, page, size);
            bean.setStatus(200);
            bean.setRows(wangFlow);
        } catch (Exception e) {
            e.printStackTrace();
            UtilLog.logger.error("错误", e);
        }
        return bean;
    }

    @RequestMapping("/wang/IncomeBreakdown")
    public @ResponseBody
    BaseBean IncomeBreakdown(Long wangUserId) {
        BaseBean bean = new BaseBean();
        try {
            Map map = wangMyModel.IncomeBreakdown(wangUserId);
            bean.setStatus(200);
            bean.setRows(map);
        } catch (Exception e) {
            e.printStackTrace();
            UtilLog.logger.error("错误", e);
        }
        return bean;
    }

    @RequestMapping("/wangModelNum")
    public @ResponseBody
    BaseBean findWangUserModelAmount(Long wangUserId, String type) {
        BaseBean bean = new BaseBean();
        Map<String, Object> map = new HashMap<>(16);
        map.put("wangUserId", wangUserId);
        map.put("type", type);
        try {
            List<NumModel> ModelAmount = wangMyModel.findWangUserModelAmount(map);
            bean.setStatus(200);
            bean.setRows(ModelAmount);
        } catch (Exception e) {
            e.printStackTrace();
            UtilLog.logger.error("错误", e);
        }
        return bean;
    }

    @RequestMapping("/income")
    public @ResponseBody
    BaseBean wangIncome(Long wangUserId) {
        BaseBean bean = new BaseBean();
        try {
            Double income = wangMyModel.expenditureTotal(wangUserId);
            bean.setStatus(200);
            bean.setRows(income);
        } catch (Exception e) {
            e.printStackTrace();
            UtilLog.logger.error("错误", e);
        }
        return bean;
    }

    @RequestMapping("/findWangUser")
    public @ResponseBody
    BaseBean findWangUser(long wangUserId, String fuzzyField,
                          @RequestParam(defaultValue = "1") Integer page,
                          @RequestParam(defaultValue = "10") Integer size) {
        BaseBean bean = new BaseBean();
        Map map = new HashMap();
        map.put("wangUserId", wangUserId);
        map.put("fuzzyField", fuzzyField);
        try {
            List<Map> wangUser = wangMyModel.findWangUser(map,page,size);
            bean.setStatus(200);
            bean.setRows(wangUser);
        } catch (Exception e) {
            e.printStackTrace();
            UtilLog.logger.error("错误", e);
        }
        return bean;
    }
}

