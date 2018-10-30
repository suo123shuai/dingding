package com.ddcar.service;

import com.ddcar.entity.RescueXin;
import com.ddcar.entity.TbBranch;
import com.ddcar.entity.TbRescue;
import com.ddcar.entity.TbUser;

import java.util.List;
import java.util.Map;

public interface RiderIndexService {

    /**
     *按营业项目查询网点
     * @param items
     * @return
     * @throws Exception
     */
    List<TbBranch> listBranch(Map map) throws Exception;

    /**
     * 救援信息插入
     * @param rescue
     * @return
     * @throws Exception
     */
    int insertRescue(TbRescue rescue) throws Exception;

    /**
     * 根据id差网点
     * @param wangUserId
     * @return
     * @throws Exception
     */
    TbBranch getBranch(long wangUserId)throws Exception;

    /**
     * 查用户救援信息
     * @param userId 用户id
     * @return
     * @throws Exception
     */
    RescueXin rescueInformation(long userId)throws Exception;

    /**
     * 更新用户信息
     * @param user
     * @return
     */
    int updateUser(TbUser user)throws Exception;

    /**
     * 查用户信息
     * @param userId
     * @return
     * @throws Exception
     */
    TbUser getUserByUserId(Long userId)throws Exception;

    /**
     * 用户认证状态
     * @param userId
     * @return
     * @throws Exception
     */
    Map findUserState(Long userId)throws Exception;
}
