package com.ddcar.service.impl;

import com.common.DoubleOperation;
import com.ddcar.entity.TbBranch;
import com.ddcar.entity.UserVehicle;
import com.ddcar.entity.Vehicles;
import com.ddcar.mapper.TbBranchMapper;
import com.ddcar.mapper.TbUserMapper;
import com.ddcar.mapper.TbVehicleMapper;
import com.ddcar.service.RiderLeaseService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class RiderLeaseServiceImpl implements RiderLeaseService {

    @Autowired
    TbBranchMapper branchMapper;

    @Autowired
    TbVehicleMapper vehicleMapper;

    @Autowired
    TbUserMapper tbUserMapper;

    @Override
    public List<TbBranch> lingVehicleJvli(Map map, Integer page, Integer size) {
        PageHelper.startPage(page,size);
        return branchMapper.lingVehicleJvli(map);
    }

    @Override
    public Vehicles getVehicleByqrCode(Map map) {
        return vehicleMapper.getVehicleByqrCode(map);
    }

    @Override
    public TbBranch findDiscount(long branchId) throws Exception {
        return branchMapper.findDiscount(branchId);
    }

    @Override
    public Map qrCodeGetBranchId(String qrCode) throws Exception {
        return branchMapper.qrCodeGetBranchId(qrCode);
    }

    @Override
    public List<Vehicles> findprice(String[] ids) {
        return vehicleMapper.findprice(ids);
    }

    @Override
    public int findUserBalance(String[] ids, long userId) {
        UserVehicle user = tbUserMapper.findUser(userId);
        if(0 == user.getParentId()){
            return 1;
        }
        UserVehicle user1 = tbUserMapper.findUserTuan(user.getParentId());
        double sum = 0.0;
        double balance = DoubleOperation.sub(user1.getCashDeposit(), user1.getUseMoney1());
        List<Vehicles> Vehicle = vehicleMapper.findprice(ids);
        for (Vehicles v : Vehicle) {
            sum = DoubleOperation.sum(v.getCashDeposit(), sum);
        }
        Double balance1 = DoubleOperation.sub(balance, sum);
        if(balance1 >= 0){
            return 1;
        } else {
            return 0;
        }
    }

    @Override
    public List<Vehicles> findUserVehicleInformation(Long userId) {
        return vehicleMapper.findUserVehicleInformation(userId);
    }
}
