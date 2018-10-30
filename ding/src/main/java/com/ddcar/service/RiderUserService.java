package com.ddcar.service;

import com.ddcar.entity.TbUser;
import com.ddcar.entity.UserVehicle;

import java.util.Map;

public interface RiderUserService {

    /**
     * 个人用户信息
     * @param userId
     * @return
     */
    UserVehicle findUser(long userId)throws Exception;

    /**
     * 查用户信息
     * @param userId 用户id
     * @return
     * @throws Exception
     */
    TbUser getUserByUserId(long userId)throws Exception;

    /**
     * 更新救援信息
     * @param map
     * @return
     * @throws Exception
     */
    int updRescuestatus(Map map, Long userId)throws Exception;

    /**
     * 二维码查网点id
     * @param qrCode
     * @return
     * @throws Exception
     */
    Map qrCodeGetBranchId(String qrCode)throws Exception;

}