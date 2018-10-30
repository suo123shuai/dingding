package com.ddcar.service;

import com.ddcar.entity.TbBranch;
import com.ddcar.entity.Vehicles;

import java.util.List;
import java.util.Map;

public interface RiderLeaseService {

    /**
     * 查询网点信息和距离
     * @param map
     * @return
     */
    List<TbBranch> lingVehicleJvli(Map map, Integer page, Integer size) throws Exception;

    /**
     * 根据二维码查车电详情
     * @param qrCode
     * @return
     */
    Vehicles getVehicleByqrCode(Map map)throws Exception;

    /**
     * 查分公司id
     * @param branchId
     * @return
     * @throws Exception
     */
    TbBranch findDiscount(long branchId)throws Exception;

    /**
     * 二维码查网点id
     * @param qrCode
     * @return
     * @throws Exception
     */
    Map qrCodeGetBranchId(String qrCode)throws Exception;

    /**
     * 查租凭的车电信息
     * @param ids
     * @return
     */
    List<Vehicles> findprice(String[] ids)throws Exception;

    /**
     * 查看团签的余额是否足够用户支付
     * @param ids
     * @param userId
     * @return
     */
    int findUserBalance(String[] ids, long userId);

    /**
     * 用户租凭的车电
     * @param wangUserId
     * @return
     */
    List<Vehicles> findUserVehicleInformation(Long wangUserId);
}
