package com.ddcar.service;

import com.ddcar.entity.PatchOrder;
import com.ddcar.entity.TbOrder;
import org.springframework.core.annotation.Order;

import java.util.List;
import java.util.Map;

public interface OrderPayService {

    Map generateOrders(String[] ids, long userId, Integer yue, String payType, long branchId, double zong)throws Exception;

    /**
     * 用户退租
     * @return
     * @throws Exception
     */
    Double userRefund(Long userId, double makeUpAmount)throws Exception;

    /**
     * 退租订单
     * @param ids
     * @param userId
     * @return
     */
    int refundOrder(String[] ids, long userId,long parentId)throws Exception;

    /**
     * 退租订单
     * @param ids
     * @param userId
     * @return
     */
    String refundOrderPay(String[] ids, long userId,long parentId, String zhengShu)throws Exception;

    /**
     * 订单号查订单
     * @param orderId
     * @return
     */
    TbOrder getOrderByOrderId(String orderId);

    /**
     * 支付成功后更新
     * @param map
     * @return
     */
    int paySuccess(Map map);

    /**
     * 查询补交订单
     * @param orderNo
     * @return
     */
    PatchOrder findPatchOrder(String orderNo);
}