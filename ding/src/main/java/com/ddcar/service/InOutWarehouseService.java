package com.ddcar.service;

import com.ddcar.entity.Vehicles;

import java.util.List;
import java.util.Map;

public interface InOutWarehouseService {

    /**
     * 查找所有要入库到本网点的车电
     * @param wangUserId
     * @return
     */
    List<Vehicles> inWarehouse(long wangUserId) throws Exception;

    /**
     * 网点入库后更新
     * @param map
     * @return
     */
    int confirmInOut(Map map) throws Exception;

    /**
     * 网点扫二维码车点出库
     * @param map
     * @return
     * @throws Exception
     */
    int exitConfirm(long userId,String qrCode) throws Exception;

    /**
     * c查询本网点出库的车电信息
     * @param wangUserId
     * @return
     * @throws Exception
     */
    List<Vehicles> outWarehouse(long wangUserId, Integer page, Integer size) throws Exception;
}
