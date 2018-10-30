package com.ddcar.service.impl;

import com.ddcar.entity.TbInout;
import com.ddcar.mapper.TbInoutMapper;
import com.ddcar.service.TbInoutService;
import org.hibernate.validator.constraints.SafeHtml;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Administrator on 2018-09-12.
 */
@Service
public class TbInoutServiceImpl implements TbInoutService{

    @Autowired(required = false)
    TbInoutMapper tbInoutMapper;

    @Transactional
    @Override
    public void add(TbInout tbInout) {
        tbInoutMapper.insertTbInout(tbInout);
    }
}
