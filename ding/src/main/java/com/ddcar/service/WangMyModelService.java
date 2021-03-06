package com.ddcar.service;

import com.ddcar.entity.*;

import java.util.List;
import java.util.Map;

public interface WangMyModelService {

    /**
     * \
     * 查询网点的车电信息
     *
     * @param map
     * @return
     */
    List<Vehicles> findUserVehicle(Map map, Integer page, Integer size) throws Exception;

    /**
     * 查询网点的二维码
     *
     * @param userId
     * @return
     */
    String fiindUserQrCode(long userId) throws Exception;

    /**
     * 根据车电id查询车电详情
     * @param vehicleId
     * @return
     * @throws Exception
     */
    Vehicles findUserVehicleParticular(long vehicleId) throws Exception;

    /**
     * 查询网点骑手
     * @param wangUserId
     * @return
     */
    List<TbUser> listUser(long wangUserId, Integer page, Integer size)throws Exception;

    /**
     * 更新骑手审核状态
     * @param map
     * @return
     */
    int updUserState(Map map)throws Exception;

    /**
     * 用户信息和租凭历史
     * @param userId
     * @return
     */
    UserOrderVehicleItme findUserVehicle(long userId, Integer page, Integer size)throws Exception;

    /**
     * 手机号用户名模糊查询用户
     * @param userId
     * @return
     */
    List<TbUser> findUserByLike(Map map, Integer page, Integer size)throws Exception;

    /**
     * 待审核用户信息
     * @param userId
     * @return
     * @throws Exception
     */
    UserVehicle findUser(long userId)throws Exception;

    /**
     * 解绑用户
     * @param map
     * @return
     */
    int updUserEmptyState(Map map)throws Exception;

    /**
     * id查用户信息
     * @param userId
     * @return
     */
    TbUser getUserByUserId(long userId) throws Exception;

    /**
     * 退租车电金额
     * @param ids
     * @return
     */
    Double getDeposit(String[] ids) throws Exception;

    /**
     * 网点查看流水信息
     * @param wangUserId
     * @return
     */
    AmountAndFlow findWangFlow(Long wangUserId, Integer page, Integer size)throws Exception;

    /**
     * 网点收益明细
     * @param wangUserId
     * @return
     */
    Map IncomeBreakdown(Long wangUserId)throws Exception;

    /**
     * 查询网点车电型号数量
     * @param map
     * @return
     */
    List<NumModel> findWangUserModelAmount(Map map)throws Exception;

    /**
     * 本月网点的的收支金额明细
     * @param wangUserId
     * @return
     */
    Double expenditureTotal(Long wangUserId)throws Exception;

    /**
     * 查询网点所有认证的用户
     * @param map
     * @param page
     * @param size
     * @return
     * @throws Exception
     */
    List<Map> findWangUser(Map map, Integer page, Integer size)throws Exception;
}