package com.ddcar.service.impl;

import com.ddcar.entity.AccountFlow;
import com.ddcar.mapper.BilMapper;
import com.ddcar.service.BilService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

/**
 * Created by Administrator on 2018-10-09.
 */
@Service
public class BilServiceImpl implements BilService{

    @Autowired(required = false)
    BilMapper bilMapper;

    @Override
    public List<HashMap> flowList(Integer page, Integer size, String wangUserId, String start, String end,Long branchId) {
        PageHelper.startPage(page,size);
        return bilMapper.flowList(wangUserId,start,end,branchId);
    }

    @Override
    public List<HashMap> accountFlow(Long branchId,Integer page,Integer size,String wangUserId,String start,String end) {
        PageHelper.startPage(page,size);
        return bilMapper.accountFlow(branchId,wangUserId,start,end);
    }
}
