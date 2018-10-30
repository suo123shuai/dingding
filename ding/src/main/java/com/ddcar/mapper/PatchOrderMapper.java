package com.ddcar.mapper;

import com.ddcar.entity.PatchOrder;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PatchOrderMapper {

    /**
     * 新增补交信息
     * @param patchOrder
     * @return
     */
    int savePatchOrder(PatchOrder patchOrder);

    /**
     * 查最新的订单号
     * @return
     */
    String getOrderNo();

    /**
     * 更新支付状态
     * @param orderNo
     * @return
     */
    int updatePatchOrderState(String orderNo);

    /**
     * 查询补交订单
     * @param orderNo
     * @return
     */
    PatchOrder findPatchOrder(String orderNo);
}