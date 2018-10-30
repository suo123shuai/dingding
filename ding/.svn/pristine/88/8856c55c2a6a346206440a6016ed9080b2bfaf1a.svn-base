package com.ddcar.mapper;


import com.ddcar.entity.TbUser;
import com.ddcar.entity.TbVehicle;
import com.ddcar.pojo.SignUser;
import com.ddcar.pojo.SignUserDetail;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 团签接口 Mapper
 *
 * @author wcy
 */
@Mapper
public interface SignUserMapper {


    /**
     * 登陆
     * @param account 账号
     * @param pwd 密码
     * @return
     */
    TbUser login(@Param("account") String account,@Param("pwd") String pwd);

    /**
     * 根据团签id查询
     * @param parentId 团签id
     * @return cash_deposit:已交押金  use_deposit:已使用押金
     */
    Map<String,Object> querySumDeposit(Long parentId);

    /**
     * 查询数量
     * @param parentId 团签id
     * @return carNum:已租车辆 batteryNum:已租电瓶 userNum:骑手数量
     */
    Map<String,Object> queryNum(Long parentId);

    /**
     * 查询
     * @param parentId 团签id
     * @return 骑手列表
     */
    List<SignUser> queryList(Long parentId);

    /**
     * 查询骑手详情
     * @param code 二维码内容
     * @return 用户信息
     */
    TbUser queryUser(String code);

    /**
     * 查询团签详情
     * @param userId 团签id
     * @return 团签信息
     */
    TbUser regimentSignUserDetail(Long userId);

    /**
     * 查询用户详情
     * @param userId 用户Id
     * @param parentId 团签id
     * @return 用户信息
     */
    SignUserDetail queryUserDetail(@Param("parentId") Long parentId,@Param("userId") Long userId);

    /**
     * 团签是否存在
     * @param userId 用户id
     * @return 大于0 存在  小于等于0 不存在
     */
    Integer isUserFlag(Long userId);

    /**
     * 用户是否租凭车电
     * @param userId
     * @return
     */
    List<TbVehicle> findUserVehicle(long userId);

    /**
     * 是否租车
     * @param userId 用户id
     * @return 大于0 租车  小于等于0 未租车
     */
    Integer isCarRenting(Long userId);

    /**
     * 绑定骑手
     * @param parentId 团签id
     * @param userId 用户id
     * @return
     */
    Integer bindUser(@Param("parentId") Long parentId,@Param("userId") Long userId);

    /**
     * 租赁历史
     * @param userId 用户id
     * @return
     */
    List<Map<String,Object>> leaseHistoryList(Map map);

}
