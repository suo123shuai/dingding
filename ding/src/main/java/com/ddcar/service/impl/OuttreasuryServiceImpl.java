package com.ddcar.service.impl;

import com.ddcar.entity.TbInout;
import com.ddcar.mapper.TbInoutMapper;
import com.ddcar.service.OuttreasuryService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Administrator on 2018-09-05.
 */
@Service
public class OuttreasuryServiceImpl implements OuttreasuryService{

    @Autowired(required = false)
    TbInoutMapper tbInoutMapper;

    @Override
    public List<TbInout> findTbInoutListout(Integer page, Integer size) {
        PageHelper.startPage(page,size);
        return tbInoutMapper.findTbInoutListout(page, size);
    }
}
