package com.ddcar.controller;

import com.common.BaseBean;
import com.ddcar.entity.TbBranch;
import com.ddcar.entity.Vehicles;
import com.ddcar.service.OrderPayService;
import com.ddcar.service.RiderLeaseService;
import com.ddcar.service.RiderMyVehicleService;
import com.ddcar.util.UtilLog;
import org.omg.CORBA.NameValuePair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import sun.net.www.http.HttpClient;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/rider/lease")
public class RiderLeaseController {

    @Autowired
    RiderLeaseService riderLeaseService;
    @Autowired
    OrderPayService orderPayService;
    @Autowired
    private RiderMyVehicleService riderMyVehicleService;

    @RequestMapping("/lingVehicleJvli")
    public @ResponseBody
    BaseBean lingVehicleJvli(String x, String y,
                             @RequestParam(value = "page", defaultValue = "1") Integer page,
                             @RequestParam(value = "size", defaultValue = "10") Integer size) {
        BaseBean bean = new BaseBean();
        Map map = new HashMap();
        map.put("x", x);
        map.put("y", y);
        try {
            List<TbBranch> tbBranches = riderLeaseService.lingVehicleJvli(map, page, size);
            bean.setStatus(200);
            bean.setRows(tbBranches);
        } catch (Exception e) {
            e.printStackTrace();
            UtilLog.logger.error("错误：", e);
        }
        return bean;
    }

    @RequestMapping("/findVehicleQrcode")
    public @ResponseBody
    BaseBean findVehicleQrcode(String qrCode, long wangUserId) {
        BaseBean bean = new BaseBean();
        Map map = new HashMap();
        map.put("qrCode", qrCode);
        map.put("wangUserId", wangUserId);
        try {
            Vehicles vehicleByqrCode = riderLeaseService.getVehicleByqrCode(map);
            if (null == vehicleByqrCode) {
                bean.setStatus(400);
                bean.setMsg("没有此车电信息");
            } else if (6 == vehicleByqrCode.getManager()) {
                bean.setStatus(200);
                bean.setRows(vehicleByqrCode);
            } else {
                bean.setStatus(400);
                bean.setMsg("没有此车电信息");
            }
        } catch (Exception e) {
            e.printStackTrace();
            UtilLog.logger.error("错误：", e);
            bean.setMsg("系统繁忙");
        }
        return bean;
    }

    @RequestMapping("/findDiscount")
    public @ResponseBody
    BaseBean findDiscount(long branchId) {
        BaseBean bean = new BaseBean();
        try {
            TbBranch discount = riderLeaseService.findDiscount(branchId);
            bean.setStatus(200);
            bean.setRows(discount);
        } catch (Exception e) {
            e.printStackTrace();
            UtilLog.logger.error("错误：", e);
        }
        return bean;
    }

    @RequestMapping("/order")
    public @ResponseBody
    BaseBean
    order(String ids, long userId,
          Integer yue, String payType, long branchId, double zong) {
        BaseBean bean = new BaseBean();
        try {
            String[] split = ids.split(",");
            int userBalance = 0;
            if ("1".equals(payType)) {
                userBalance = riderLeaseService.findUserBalance(split, userId);
                List<Vehicles> userVehicle = riderLeaseService.findUserVehicleInformation(userId);
                if (null == userVehicle && userVehicle.size() != 0) {
                    bean.setStatus(400);
                    bean.setMsg("有订单未结束，请先结束上个订单！");
                    return bean;
                }
            } else {
                userBalance = 1;
            }
            if (userBalance == 1) {
                Map map = orderPayService.generateOrders(split, userId, yue, payType, branchId, zong);
                if (null == map || map.isEmpty()) {
                    bean.setStatus(400);
                    bean.setMsg("支付错误！");
                } else {
                    bean.setStatus(200);
                    bean.setRows(map);
                }
            } else {
                bean.setStatus(400);
                bean.setMsg("团签余额不足,请先充值！");
            }
        } catch (Exception e) {
            e.printStackTrace();
            UtilLog.logger.error("错误：", e);
        }
        return bean;
    }

    @RequestMapping("/withdrawalOrder")
    public @ResponseBody
    BaseBean withdrawalOrder(String ids, long userId, long parentId) {
        BaseBean bean = new BaseBean();
        String[] split = ids.split(",");
        try {
            orderPayService.refundOrder(split, userId, parentId);
            bean.setStatus(200);
        } catch (Exception e) {
            e.printStackTrace();
            UtilLog.logger.error("错误", e);
        }
        return bean;
    }

    @RequestMapping("/wangQrcodeGetWang")
    public @ResponseBody
    BaseBean wangQrcodeGetWang(String qrCode) {
        BaseBean bean = new BaseBean();
        try {
            Map aLong = riderLeaseService.qrCodeGetBranchId(qrCode);
            String items = (String) aLong.get("items");
            String[] split = items.split(",");
            boolean a = false;
            for (String s : split) {
                if ("0".equals(s)) {
                    a = true;
                }
            }
            if (a) {
                bean.setStatus(200);
                bean.setRows(aLong);
            } else {
                bean.setStatus(400);
                bean.setMsg("网点不可租车，请选择其他网点！");
            }
        } catch (Exception e) {
            e.printStackTrace();
            UtilLog.logger.error("错误", e);
        }
        return bean;
    }

    @RequestMapping("/findprice")
    public @ResponseBody
    BaseBean findprice(String ids) {
        BaseBean bean = new BaseBean();
        String[] split = ids.split(",");
        try {
            List<Vehicles> findprice = riderLeaseService.findprice(split);
            bean.setStatus(200);
            bean.setRows(findprice);
        } catch (Exception e) {
            e.printStackTrace();
            UtilLog.logger.error("错误", e);
        }
        return bean;
    }

    @RequestMapping("/patchOrder")
    public @ResponseBody
    BaseBean patchOrder(Long userId, Double money) {
        BaseBean bean = new BaseBean();
        try {
            Map map = riderMyVehicleService.savePatchOrder(userId, money);
            bean.setStatus(200);
            bean.setRows(map);
        } catch (Exception e) {
            e.printStackTrace();
            UtilLog.logger.error("错误", e);
        }
        return bean;
    }
}
