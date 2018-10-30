package com.ddcar.service.impl;

import com.common.Commonparam;
import com.common.DoubleOperation;
import com.ddcar.entity.*;
import com.ddcar.mapper.*;
import com.ddcar.service.RiderIndexService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class RiderIndexServiceImpl implements RiderIndexService {

    @Autowired
    private TbBranchMapper branchMapper;

    @Autowired
    private TbRescueMapper rescueMapper;

    @Resource
    private TbUserMapper tbUserMapper;

    @Autowired
    private TbVehicleMapper vehicleMapper;

    @Autowired
    private TbOrderMapper tbOrderMapper;

    @Override
    public List<TbBranch> listBranch(Map map) throws Exception {
        return branchMapper.listBranch(map);
    }

    @Override
    @Transactional
    public int insertRescue(TbRescue rescue) throws Exception {
        TbUser user = tbUserMapper.getUserByUserId(rescue.getUserId());
        if (null == user || !"0".equals(user.getState())) {
            return 300;
        } else {
            RescueXin rescue1 = rescueMapper.findRescuexin(rescue.getUserId());
            if (null == rescue1) {
                rescue.setCreateTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
                rescueMapper.insertSelective(rescue);
                Map map = new HashMap();
                map.put("wangUserId", rescue.getWangUserId());
                map.put("userId", rescue.getUserId());
                tbUserMapper.updateUserRescue(map);
                return 200;
            }
        }
        return 400;
    }

    @Override
    public TbBranch getBranch(long wangUserId) throws Exception {
        return branchMapper.selectByPrimaryKey(wangUserId);
    }

    @Override
    public RescueXin rescueInformation(long userId) throws Exception {
        return rescueMapper.findRescuexin(userId);
    }

    @Override
    public int updateUser(TbUser user) {
        return tbUserMapper.updateByPrimaryKeySelective(user);
    }

    @Override
    public TbUser getUserByUserId(Long userId) throws Exception {
        return tbUserMapper.getUserByUserId(userId);
    }

    @Override
    public Map findUserState(Long userId) throws Exception {
        double yue = 30;
        List<Vehicles> riderVehicle = vehicleMapper.findRiderVehicle(userId);
        Map map = tbUserMapper.findUserStateRescue(userId);
        Double discount = tbOrderMapper.fingDiscount(userId);
        if (null == discount) {
            discount = 0.0;
        }
        double balance = 0.0;
        if (null == riderVehicle || riderVehicle.size() == 0) {
            map.put("balance", 0);
            return map;
        }
        for (Vehicles vs : riderVehicle) {
//            double div = DoubleOperation.div(discount, 10.0, 2);
            balance = DoubleOperation.sum(balance, vs.getMonthlyRent());
        }
        double div = DoubleOperation.div(discount, 10.0, 2);
        double mul1 = DoubleOperation.mul(balance, div);
        double mul = 0.0;
        if (null != riderVehicle && riderVehicle.size() != 0) {
            Vehicles vehicles = riderVehicle.get(0);
            String stopRentalTime = vehicles.getStopRentalTime();
            long distanceDays = Commonparam.getDistanceDays(stopRentalTime);
            long floor = (long) Math.floor(distanceDays / yue);
            mul = DoubleOperation.mul(floor, mul1);
        }
        map.put("balance", mul);
        return map;
    }
}
