package com.ddcar.service.impl;

import com.common.Commonparam;
import com.common.DoubleOperation;
import com.common.OrderSequence;
import com.ddcar.entity.*;
import com.ddcar.mapper.*;
import com.ddcar.service.OrderPayService;
import com.weixin.FukuanPay;
import com.weixin.PayRefund;
import com.weixin.WeiXinUtilWap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class OrderPayServiceImpl implements OrderPayService {

    @Autowired
    private TbOrderMapper orderMapper;
    @Autowired
    private TbVehicleMapper vehicleMapper;
    @Autowired
    private TbOrderItemMapper orderItemMapper;
    @Autowired
    private TbBranchMapper branchMapper;
    @Resource
    private TbUserMapper tbUserMapper;
    @Autowired
    private AccountFlowMapper accountFlowMapper;
    @Autowired
    private PatchOrderMapper patchOrderMapper;

    @Override
    @Transactional(rollbackFor = {Exception.class})
    public Map generateOrders(String[] ids, long userId, Integer yue,
                              String payType, long branchId, double zong) throws Exception {
        TbOrder order = new TbOrder();
        //拿到最新的订单的id号
        String orderNo = orderMapper.getOrderNo();
        String state = "z";
//        获取订单号
        String orderId = OrderSequence.getOrderId(orderNo, state);
//      插入订单明细
        OrderItem orderItem = new OrderItem();
        List<Vehicles> findprice;
        findprice = vehicleMapper.findprice(ids);
        //      租凭结束时间
        Date date = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DATE, yue);
        Date time = calendar.getTime();
        String stopFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(time);
        double deposit = 0;
        double rent = 0;
        Long wangUserId = 0L;
        String format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
        for (Vehicles vc : findprice) {
            if ("1".equals(payType)) {
                orderItem.setCashDeposit(vc.getCashDeposit());
            }
            orderItem.setRentMoney(vc.getMonthlyRent());
            orderItem.setUserId(userId);
            orderItem.setOrderId(orderId);
            orderItem.setStartRentalTime(format);
            orderItem.setStopRentalTime(stopFormat);
            orderItem.setVehicleId(vc.getVehicleId());
            orderItem.setType(vc.getType());
            orderItem.setModel(vc.getModel());
            orderItem.setSerialNumber(vc.getSerialNumber());
            orderItem.setCreateTime(format);
            orderItem.setWangUserId(vc.getWangUserId());
            wangUserId = vc.getWangUserId();
            if ("3".equals(payType)) {
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                Date dt = sdf.parse(vc.getStopRentalTime());
                calendar.setTime(dt);
                calendar.add(Calendar.DATE, yue);
                Date time1 = calendar.getTime();
                String stopFormat1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(time1);
                orderItem.setStopRentalTime(stopFormat1);
            } else {
                orderItem.setStopRentalTime(stopFormat);
            }
            orderItem.setStartRentalTime(format);
            deposit = DoubleOperation.sum(deposit, vc.getCashDeposit());
            rent = DoubleOperation.sum(rent, vc.getMonthlyRent());
            orderItemMapper.insertOrder(orderItem);
        }
//      分公司折扣
        double discount = 0;
        TbBranch branch = branchMapper.findDiscount(branchId);
        double div = DoubleOperation.div(yue, 30, 0);
        if (div < 12) {
            discount = DoubleOperation.div(branch.getMonthdiscount(), 10, 2);
        } else if (div >= 12 && div < 24) {
            discount = DoubleOperation.div(branch.getDiscount(), 10, 2);
        } else {
            discount = DoubleOperation.div(branch.getTwodiscount(), 10, 2);
        }
//      插入订单表
        order.setOrderNo(orderId);
        order.setCreateTime(format);
        order.setUserId(userId);
        if ("1".equals(payType)) {
            order.setCashDeposit(deposit);
        }
        order.setRentMoney(DoubleOperation.mul(rent, div));
        order.setDiscount(DoubleOperation.mul(discount, 10));
        order.setStartRentalTime(format);
        order.setStopRentalTime(stopFormat);
        order.setRentalTime(yue);
        order.setPayState("0");
        order.setOrderType(payType);
        order.setWangUserId(wangUserId);
        //      用户信息 用户是否属于团签，个人用户支付押金，团签用户免押金
        UserVehicle user = tbUserMapper.findUser(userId);

        if (0 != user.getParentId() || ("3".equals(payType))) {
            order.setTotalMoney(
                    DoubleOperation.mul(div, DoubleOperation.mul(rent, discount)));
        } else {
            order.setTotalMoney(DoubleOperation.sum(deposit,
                    DoubleOperation.mul(div, DoubleOperation.mul(rent, discount))));
        }
        order.setUserSuperiorId(user.getParentId());
        double totalMoney = order.getTotalMoney();
        Map map = new HashMap();
        if (totalMoney != zong) {
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return map;
        }
        orderMapper.insertOrder(order);
        map.put("orderNo", orderId);
        map.put("weixinId", user.getWeixinId());
        return map;
    }

    @Override
    public Double userRefund(Long userId, double makeUpAmount) {
        List<TbOrder> order = orderMapper.getOrder(userId);
        double cashDeposit = 0;
        //用户订单的所有押金金额
        for (TbOrder tbOrder : order) {
            cashDeposit += tbOrder.getCashDeposit();
        }
        Double sub = DoubleOperation.sub(cashDeposit, makeUpAmount);
        return sub;
    }

    /**
     * 退租订单和退租成功后车电与金额流水的更新
     *
     * @param ids
     * @param userId
     * @param parentId
     * @return
     * @throws Exception
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public int refundOrder(String[] ids, long userId, long parentId) throws Exception {
        Map map = this.orderGenerate(ids, userId, parentId);
//        double deposit = (double) map.get("deposit");
        String orderNo = (String) map.get("orderNo");
//        long wangUserId = (long) map.get("wangUserId");

//        else {
//            map1.put("userId", userId);
//            tbUserMapper.updateUserDeposit(map1);
//        }
//        order.setTotalMoney(orderAmount);
//        //新增订单
//        orderMapper.insertOrder(order);
        //更新车电的状态
        vehicleMapper.updateWithdrawalStatus(userId);
        TbOrder order = orderMapper.getOrderByOrderId(orderNo);
        Long wangUserId = order.getWangUserId();
        Double deposit = order.getTotalMoney();
        Long userId1 = order.getUserId();
        Long userSuperiorId = order.getUserSuperiorId();
        Map map1 = new HashMap();
        map1.put("money", deposit);
        map1.put("userId", parentId);
        if (parentId != 0) {
            //退租后更新团签押金使用金额
            tbUserMapper.updateUserDeposit(map1);
        }
//        添加流水信息
        AccountFlow accountFlow = new AccountFlow();
        accountFlow.setUserId(userId);
        accountFlow.setWangUserId(wangUserId);
        accountFlow.setOrderNo(orderNo);
        accountFlow.setUserSuperiorId(parentId);
        accountFlow.setBranchId(branchMapper.findBranchId(wangUserId));
        accountFlow.setMoney(new BigDecimal(deposit+""));
        accountFlow.setPayType(2);
        accountFlowMapper.saveFlow(accountFlow);
        return 0;
    }

    /**
     * 退租后更新
     *
     * @param orderNo
     * @return
     */
    private int tui(String orderNo) {
        TbOrder order = orderMapper.getOrderByOrderId(orderNo);
        orderMapper.updatePayState(orderNo);
        Long wangUserId = order.getWangUserId();
        Double deposit = order.getTotalMoney();
        Long userId = order.getUserId();
        Long userSuperiorId = order.getUserSuperiorId();
        vehicleMapper.updateWithdrawalStatus(userId);
        Map map1 = new HashMap();
        map1.put("money", deposit);
        map1.put("userId", userId);
        tbUserMapper.updateUserDeposit(map1);
//        添加流水信息
        AccountFlow accountFlow = new AccountFlow();
        accountFlow.setUserId(userId);
        accountFlow.setWangUserId(wangUserId);
        accountFlow.setOrderNo(orderNo);
        accountFlow.setUserSuperiorId(userSuperiorId);
        accountFlow.setBranchId(branchMapper.findBranchId(wangUserId));
        accountFlow.setMoney(new BigDecimal(deposit+""));
        accountFlow.setPayType(2);
        accountFlowMapper.saveFlow(accountFlow);
        return 0;

    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public String refundOrderPay(String[] ids, long userId, long parentId, String zhengShu) throws Exception {
        TbOrder order = orderMapper.findOrderPay(userId);

        Map map = this.orderGenerate(ids, userId, parentId);
        String deposit = map.get("deposit").toString();
        String orderNo = map.get("orderNo").toString();
        TbOrder order1 = orderMapper.getOrderByOrderId(orderNo);
//        Long payMoney = (long)DoubleOperation.mul(order1.getTotalMoney(), 100);
        String orderNo1 = order1.getOrderNo();
        double totalMoney1 = order.getTotalMoney();
        double totalMoney = order1.getTotalMoney();
        String createTime = order.getCreateTime();
        Date date1 = Commonparam.fmt.parse(createTime);
        Date date2 = new Date();
        long days = (date2.getTime() - date1.getTime()) / (1000 * 60 * 60 * 24);
        if (days < 365) {
            System.out.println(String.valueOf(totalMoney));
            String s = PayRefund.wxRefund(zhengShu,
                    WeiXinUtilWap.mch_id, order.getOrderNo(),String.valueOf(totalMoney),
                    orderNo1, String.valueOf(totalMoney1));

            System.out.println(s);
            if ("success".equals(s)) {
                this.tui(orderNo);
                return "1";
            } else {
                return "0";
            }
        } else {

            UserVehicle uset = tbUserMapper.getUsetId(userId);
            String s = FukuanPay.wxRefund(zhengShu,
                    WeiXinUtilWap.mch_id, uset.getWeixinId(), "0.01", "115.159.51.111",
                    map.get("orderNo").toString());
            if ("success".equals(s)) {
                this.tui(map.get("orderNo").toString());
                return "1";
            } else {
                return "0";
            }
        }
    }

    private Map orderGenerate(String[] ids, long userId, long parentId) throws Exception {
        //拿到最新的订单的id号
        String orderNo = orderMapper.getOrderNo();
        String stste = "z";
//        获取订单号
        String orderId = OrderSequence.getOrderId(orderNo, stste);
        String format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
        Map map = new HashMap();
        OrderItem orderi = new OrderItem();
        TbOrder order = new TbOrder();
        map.put("userId", userId);
        map.put("ids", ids);
        List<Vehicles> vehicles = tbUserMapper.listUsetVehicleGet(map);
        double deposit = 0;
        Long wangUserId = null;
        for (Vehicles v : vehicles) {
            orderi.setCreateTime(format);
            orderi.setOrderId(orderId);
            orderi.setVehicleId(v.getVehicleId());
            orderi.setCashDeposit(v.getCashDeposit());
            wangUserId = v.getWangUserId();
            orderi.setUserId(userId);
            orderi.setWangUserId(wangUserId);
            deposit = DoubleOperation.sum(deposit, v.getCashDeposit());
            orderItemMapper.insertOrder(orderi);
        }
        order.setCashDeposit(deposit);
        order.setOrderNo(orderId);
        order.setCreateTime(format);
        order.setWangUserId(wangUserId);
        order.setUserId(userId);
        order.setOrderType("2");
        order.setPayState("0");
        order.setTotalMoney(deposit);
        //新增订单
        orderMapper.insertOrder(order);
        Map map1 = new HashMap();
        map1.put("wangUserId", wangUserId);
        map1.put("orderNo", orderId);
        map1.put("deposit", deposit);
        return map1;
    }

//    public int unsubscribeSuccessfullyUpdated() {
//
//    }

    @Override
    public TbOrder getOrderByOrderId(String orderId) {
        return orderMapper.getOrderByOrderId(orderId);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int paySuccess(Map map) {
        String orderNo = map.get("out_trade_no").toString();
        String substring = orderNo.substring(0, 1);
        if ("z".equals(substring)) {
            orderMapper.updatePayState(orderNo);
//        个人订单信息
            TbOrder order = orderMapper.getOrderByOrderId(orderNo);
            Long userId = order.getUserId();
            Double cashDeposit = order.getCashDeposit();
            Double discount = order.getDiscount();
            Double rentMoney = order.getRentMoney();
            Long userSuperiorId = order.getUserSuperiorId();
            List<OrderItem> orderItems = orderItemMapper.listVehicleId(orderNo);
            //更新车电状态
            TbVehicle vehicle = new TbVehicle();
            for (OrderItem orderItem : orderItems) {
                if ("1".equals(order.getOrderType())) {
                    vehicle.setDeposit(orderItem.getCashDeposit());
                }
                vehicle.setUserId(orderItem.getUserId());
                vehicle.setStartRentalTime(orderItem.getStartRentalTime());
                vehicle.setStopRentalTime(orderItem.getStopRentalTime());
                vehicle.setState("1");
                vehicle.setMonthlyRent(orderItem.getRentMoney());
                vehicle.setVehicleId(orderItem.getVehicleId());
                vehicle.setModifyTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
                Date date = new Date();
                Calendar calendar = Calendar.getInstance();
                calendar.setTime(date);
                calendar.add(Calendar.DATE, -order.getRentalTime());
                Date time = calendar.getTime();
                vehicle.setCarryonRentalTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(time));
                vehicleMapper.updateVehicleAll(vehicle);
            }
//       添加流水信息
            AccountFlow accountFlow = new AccountFlow();
            accountFlow.setUserId(userId);
            accountFlow.setWangUserId(order.getWangUserId());
            accountFlow.setOrderNo(orderNo);
            accountFlow.setUserSuperiorId(userSuperiorId);
            accountFlow.setBranchId(branchMapper.findBranchId(order.getWangUserId()));
            double mul = DoubleOperation.mul(rentMoney, DoubleOperation.div(discount, 10, 2));
            accountFlow.setMoney(new BigDecimal(mul+""));
            accountFlow.setPayType(1);
            Map map1 = new HashMap();
            accountFlowMapper.saveFlow(accountFlow);
            if ("1".equals(order.getOrderType())) {
                accountFlow.setMoney(new BigDecimal(cashDeposit+""));
                accountFlow.setPayType(0);
                accountFlowMapper.saveFlow(accountFlow);
                map1.put("money", order.getCashDeposit());
                Long parentId = tbUserMapper.findParentId(userId);
                map1.put("userId", parentId);
                if (parentId != 0) {
                    tbUserMapper.updateDeposit(map1);
                } else {
                    map1.put("userId", userId);
                    tbUserMapper.updateDeposit(map1);
                }
            }
            map1.put("userId", userId);
            map1.put("balance", rentMoney);
            tbUserMapper.updateUserBalance(map1);
        } else {
            patchOrderMapper.updatePatchOrderState(orderNo);
            PatchOrder patchOrder = patchOrderMapper.findPatchOrder(orderNo);
            AccountFlow accountFlow = new AccountFlow();
            accountFlow.setMoney(new BigDecimal(patchOrder.getMoney()+""));
            accountFlow.setPayType(3);
            accountFlow.setUserId(patchOrder.getUserId());
            accountFlow.setUserSuperiorId(patchOrder.getParentId());
            accountFlow.setWangUserId(patchOrder.getWangUserId());
            accountFlow.setOrderNo(orderNo);
            accountFlowMapper.saveFlow(accountFlow);
        }
        return 0;
    }

    @Override
    public PatchOrder findPatchOrder(String orderNo) {
        return patchOrderMapper.findPatchOrder(orderNo);
    }


}
