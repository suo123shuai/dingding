package com.ddcar.service.impl;

import com.ddcar.entity.TbDot;
import com.ddcar.mapper.TbDtoMapper;
import com.ddcar.service.TbDtoService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Administrator on 2018-09-11.
 */
@Service
public class TbDtoServiceImpl implements TbDtoService {
    @Autowired(required = false)
    TbDtoMapper tbDtoMapper;


    @Override
    public List<TbDot> findTbDot(Integer page, Integer size) {
        PageHelper.startPage(page,size);
        return tbDtoMapper.findTbDot();
    }

    @Override
    public TbDot findTbDotId(Long dotId) {
        return tbDtoMapper.findTbDotId(dotId);
    }

    @Override
    public void delTbDot(Long[] dotId) {
        for (Long id:dotId){
            tbDtoMapper.delTbDot(id);
        }
    }

    @Transactional
    @Override
    public void insertTbDot(TbDot tbDot) {
        tbDtoMapper.insertTbDot(tbDot);
    }

    @Transactional
    @Override
    public void updateTbDot(TbDot tbDot) {
        tbDtoMapper.updateTbDot(tbDot);
    }
}
