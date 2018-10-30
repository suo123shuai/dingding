package com.ddcar.service.impl;

import com.ddcar.mapper.TbRescueMapper;
import com.ddcar.service.TbRescueService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

/**
 * Created by Administrator on 2018-09-14.
 */
@Service
public class TbRescueServiceImpl implements TbRescueService{
    @Autowired(required = false)
    TbRescueMapper tbRescueMapper;

    @Override
    public List<HashMap> rescueList(Integer page, Integer size, Long branchId,String userName,String phone) {
        PageHelper.startPage(page,size);
        return tbRescueMapper.rescueList(branchId,userName,phone);
    }
}
