package com.ddcar.service.impl;

import com.ddcar.mapper.TbVehicleMapper;
import com.ddcar.service.VehicleStateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class VehicleStateServiceImpl implements VehicleStateService {

    @Autowired(required = false)
    TbVehicleMapper vehicleMapper;

    @Override
    public int updVehicle(Map map) {
        return vehicleMapper.updVehicle(map);
    }
}
