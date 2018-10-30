package com.ddcar.service.impl;

import com.ddcar.entity.TbBranch;
import com.ddcar.entity.TbUser;
import com.ddcar.mapper.TbBranchMapper;
import com.ddcar.service.ITbUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class TbUserImpl implements ITbUser {

    @Autowired(required = false)
    TbBranchMapper userMapper;

    @Override
    public TbBranch loginUser(Map map) {
        return userMapper.loginUser(map);
    }
}
