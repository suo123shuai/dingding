package com.ddcar.service.impl;

import com.ddcar.entity.TbVehicle;
import com.ddcar.entity.Vehicles;
import com.ddcar.mapper.TbInoutMapper;
import com.ddcar.mapper.TbVehicleMapper;
import com.ddcar.service.InOutWarehouseService;
import com.github.pagehelper.PageHelper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class InOutWarehouseServiceImpl implements InOutWarehouseService {

    @Resource
    TbInoutMapper inoutMapper;
    @Resource
    TbVehicleMapper vehicleMapper;

    @Override
    public List<Vehicles> inWarehouse(long wangUserId) {
        return inoutMapper.inWarehouse(wangUserId);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int confirmInOut(Map map) {
        inoutMapper.confirmInOut(map);
        vehicleMapper.updVehicle(map);
        return 0;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int exitConfirm(long userId, String qrCode) {
        Map map = new HashMap();
        map.put("userId", userId);
        map.put("qrCode", qrCode);
        TbVehicle vehicle = vehicleMapper.findVehicle(qrCode);
        if (6 == vehicle.getManager() && vehicle.getWangUserId().equals(userId)) {
            if(!"1".equals(vehicle.getState())) {
                String format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
                map.put("vehicleId", vehicle.getVehicleId());
                map.put("modifyBy", format);
                vehicleMapper.updInOut(map);
                map.put("fromId", userId);
                map.put("toId", vehicle.getBranchId());
                map.put("vehicleId", vehicle.getVehicleId());
                map.put("createTime", format);
                inoutMapper.exitConfirm(map);
                return 200;
            } else {
                return 100;
            }
        }
        return 300;
    }

    @Override
    public List<Vehicles> outWarehouse(long wangUserId, Integer page, Integer size) {
        PageHelper.startPage(page, size);
        return inoutMapper.outWarehouse(wangUserId);
    }
}
