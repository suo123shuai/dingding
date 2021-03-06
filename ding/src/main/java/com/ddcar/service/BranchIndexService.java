package com.ddcar.service;

import com.ddcar.entity.*;

import java.util.List;
import java.util.Map;

public interface BranchIndexService {

    /**
     * 首页车电总数信息查询
     * @return
     */
    BranchIndexCount indexCount(long userId) throws Exception;

    /**
     * 首页网点用户信息
     * @param userId
     * @return
     */
    List<TbUser> indexBranchUser(long userId,Integer page, Integer size);

    /**
     * 更新用户救援信息状态
     * @return
     */
    int updRescue(TbRescue record);

    /**
     * 查用户救援信息
     * @param map
     * @return
     * @throws Exception
     */
    TbRescue findRescue(Map map)throws Exception;

    /**
     * 用户租凭车电详细信息
     * @param userId
     * @return
     */
    List<User> withdrawRental(Map map, Integer page, Integer size)throws Exception;

    /**
     * 退租用户查询
     * @return
     */
    UserVehicle throwALeaseUser(long userId,Long wangUserId)throws Exception;

}
