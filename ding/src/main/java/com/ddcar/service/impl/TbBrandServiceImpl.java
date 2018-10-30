package com.ddcar.service.impl;

import com.ddcar.entity.TbBrand;
import com.ddcar.mapper.TbBrandMapper;
import com.ddcar.service.TbBrandService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Administrator on 2018-09-03.
 */
@Service
public class TbBrandServiceImpl implements TbBrandService{

    @Autowired(required = false)
    TbBrandMapper tbBrandMapper;

    @Override
    public List<TbBrand> findTbBrandMapperList(Integer page, Integer size,String brandName) {
        PageHelper.startPage(page,size);
        return tbBrandMapper.findTbBrandList(brandName);
    }

    @Override
    public Integer ifbrandName(String brandName) {
        return tbBrandMapper.ifbrandName(brandName);
    }

    @Override
    public Integer delmod(long brandId) {
        return tbBrandMapper.delmod(brandId);
    }

    @Override
    public List<TbBrand> findList() {
        return tbBrandMapper.findList();
    }

    @Override
    public TbBrand brandName(String brandName) {
        return tbBrandMapper.brandName(brandName);
    }

    @Override
    public TbBrand tbBrandid(Long brandId) {
        return tbBrandMapper.selectByPrimaryKey(brandId);
    }

    @Override
    public void delTbBrand(Long[] brandId) {
        for (Long id:brandId){
            tbBrandMapper.delTbBrand(id);
        }
    }

    @Transactional
    @Override
    public void add(TbBrand tbBrand) {
        tbBrandMapper.insert(tbBrand);
    }

    @Transactional
    @Override
    public void update(TbBrand tbBrand) {
        tbBrandMapper.updatebrand(tbBrand);
    }

    @Override
    public void del(Integer id){}
}