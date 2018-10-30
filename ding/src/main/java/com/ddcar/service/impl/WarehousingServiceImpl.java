package com.ddcar.service.impl;

import com.ddcar.entity.TbInout;
import com.ddcar.mapper.TbInoutMapper;
import com.ddcar.service.WarehousingService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2018-08-31.
 */
@Service
public class WarehousingServiceImpl implements WarehousingService{
    @Autowired(required = false)
    TbInoutMapper tbInoutMapper;

    @Override
    public List<TbInout> findTbInoutList(Integer page, Integer size) {
        PageHelper.startPage(page,size);
        return tbInoutMapper.findTbInoutList(page, size);
    }

    @Override
    public void add(TbInout tbInout) {

    }

    @Override
    public void update(TbInout tbInout) {

    }

    @Override
    public void del(Integer id) {

    }
}