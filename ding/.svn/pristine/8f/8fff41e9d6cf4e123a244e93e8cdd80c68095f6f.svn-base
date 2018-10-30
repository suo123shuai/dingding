package com.ddcar.mapper;


import com.ddcar.entity.OrderItem;
import com.ddcar.entity.TbOrderItem;
import com.ddcar.entity.UserOrderVehicleItme;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface TbOrderItemMapper {
    int deleteByPrimaryKey(Long orderItemId);

    int insert(TbOrderItem record);

    int insertSelective(TbOrderItem record);

    TbOrderItem selectByPrimaryKey(Long orderItemId);

    int updateByPrimaryKeySelective(TbOrderItem record);

    int updateByPrimaryKey(TbOrderItem record);

    /**
     * 用户信息和租凭历史
     * @param userId
     * @return
     */
    UserOrderVehicleItme findUserVehicle(long userId);

    /**
     * 插入订单明细表
     * @param OrderItem
     * @return
     */
    int insertOrder(OrderItem OrderItem);

    /**
     * 查用户退租的车电信息
     * @param userId
     * @return
     */
    List<TbOrderItem> listOrderVehicle(long userId);

    /**
     * 查订单明细
     * @param ids
     * @return
     */
    List<TbOrderItem> listOrderByOrderId(String[] ids);

    /**
     * 查订单里所有的车电id
     * @param orderNo
     * @return
     */
    List<OrderItem> listVehicleId(String orderNo);
}