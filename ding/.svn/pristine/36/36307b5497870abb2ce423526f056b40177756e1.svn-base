package com.ddcar.service.impl;

import com.ddcar.entity.TbUser;
import com.ddcar.entity.UserVehicle;
import com.ddcar.mapper.TbBranchMapper;
import com.ddcar.mapper.TbRescueMapper;
import com.ddcar.mapper.TbUserMapper;
import com.ddcar.service.RiderUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@Service
public class RiderUserServiceImpl implements RiderUserService {

    @Autowired
    private TbUserMapper userMapper;
    @Resource
    private TbRescueMapper tbRescueMapper;
    @Autowired
    private TbBranchMapper tbBranchMapper;

    @Override
    public UserVehicle findUser(long userId) throws Exception {
        return userMapper.findUser(userId);
    }

    @Override
    public TbUser getUserByUserId(long userId) throws Exception {
        return userMapper.getUserByUserId(userId);
    }

    @Override
    @Transactional
    public int updRescuestatus(Map map, Long userId) throws Exception {
        userMapper.updateUserRescueState(userId);
        return tbRescueMapper.updRescuestatus(map);
    }

    @Override
    public Map qrCodeGetBranchId(String qrCode) throws Exception {
        return tbBranchMapper.qrCodeGetBranchId(qrCode);
    }
}
