package com.ddcar.mapper;

import com.ddcar.entity.TbUser;
import com.ddcar.entity.User;
import com.ddcar.entity.UserVehicle;

import com.ddcar.entity.Vehicles;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Mapper
public interface TbUserMapper {

    /**
     * 小程序用户登录
     * @param map
     * @return
     */
    TbUser loginUser(Map map);

    /**
     * 查询网点骑手总数
     * @param UserId 网点id
     * @return
     */
    int userCount(Long UserId);

    /**
     * 首页用户信息
     * @param userId
     * @return
     */
    List<TbUser> indexUser(long userId);

    /**
     * 更新用户状态
     * @param userId
     * @return
     */
    int updUser(Map map);

    /**
     * 个人用户信息
     * @param userId
     * @return
     */
    UserVehicle findUser(long userId);

    /**
     * 团签信息
     * @param userId
     * @return
     */
    UserVehicle findUserTuan(long userId);

    /**
     * 退租用户信息
     * @return
     */
    List<TbUser> throwALeaseUser(long userId);

    /**
     * 查询网点未审核的用户
     * @param map
     * @return
     */
    List<TbUser> listUser(long map);

    /**
     * 审核状态更新
     * @param map
     * @return
     */
    int updUserState(Map map);

    /**
     * 手机号用户名模糊查询用户
     * @param userId
     * @return
     */
    List<TbUser> findUserByLike(Map map);
    /**
     * 查询该公司的骑手
     * @param branchId
     * @return
     */
    List<HashMap> findComTbUser(@Param("branchId")Long branchId,@Param("type")Integer type,@Param("parentId")Long parentId);
    /**
     * 查询该公司的团签
     * @param branchId
     * @return
     */
    List<HashMap> findComsign(@Param("branchId")Long branchId, @Param("userId")Long userId, @Param("userName")String userName);
    //团签下拉框
    List<HashMap> findTUser(@Param("branchId")Long branchId);
    //新建团签
    int insertGroup(TbUser tbUser);
    //查询库里是否有该团签
    Integer iftq(@Param("account")String account);
    //id查询团签
    TbUser idSearchComsign(Long userId);

    //编辑团签
    int updateGroup(TbUser tbUser);

    int updateuser(TbUser tbUser);

    //删除团签
    void delTbuser(@Param("userId") Long userId);

    //启用
    void enable(@Param("userId") Long userId);
    //关停
    void close(@Param("userId") Long userId);

    /**
     * id查用户信息
     * @param userId
     * @return
     */
    TbUser getUserByUserId(long userId);

    /**
     * 查用户信息
     * @param WeiXinId 微信id
     * @return
     */
    TbUser getUserByWeiXin(String WeiXinId);

    /**
     * 新增用户
     * @param user
     * @return
     */
    int insertSelective(TbUser user);

    /**
     * 解绑用户
     * @param map
     * @return
     */
    int updUserEmptyState(Map map);

    /**
     * 查用户要退租的车电
     * @param map
     * @return
     */
    List<Vehicles> listUsetVehicleGet(Map map);

    /**
     * 更新团签押金金额
     * @param map
     * @return
     */
    int updateDeposit(Map map);

    /**
     * 更新个人已使用的押金金额
     * @param map
     * @return
     */
    Integer updateUserDeposit(Map map);

    /**
     * 查用户的上级id
     * @param userId
     * @return
     */
    Long findParentId(Long userId);

    /**
     * 更新用户信息
     * @param user
     * @return
     */
    int updateByPrimaryKeySelective(TbUser user);

    /**
     * 查用户信息
     * @param weixinId
     * @return
     */
    TbUser WeiIdGetUser(String weixinId);

    /**
     * 更新用户救援网点信息
     * @param map
     * @return
     */
    int updateUserRescue(Map map);

    /**
     * 更新用户救援网点信息
     * @param map
     * @return
     */
    int updateUserRescueState(Long userId);

    /**
     * 查最新插入id
     * @return
     */
    Long getUpToDateQrCode();

    /**
     * 模糊查询所有租网点车电的用户
     * @param map
     * @return
     */
    List<TbUser> findUserState(Map map);

    /**
     * 用户信息
     * @param userId
     * @return
     */
    UserVehicle getUsetId(Long userId);

    /**
     * 用户认证状态
     * @param userId
     * @return
     */
    Map findUserStateRescue(Long userId);

    /**
     * 更新用户的余额信息
     * @param map
     * @return
     */
    int updateUserBalance(Map map);

    /**
     * 更新用户退租状态
     * @param map
     * @return
     */
    int updateUserTuiState(Map map);

    /**
     * 网点车用户信息
     * @param map
     * @return
     */
    List<User> findWnagQiUserId(Map map);

    /**
     * 用户租凭剩余天数
     * @param map
     * @return
     */
    long findWangUserSurplus(Map map);

    /**
     * 查询网点所有认证的用户
     * @param map
     * @return
     */
    List<Map> findWangUser(Map map);

}
