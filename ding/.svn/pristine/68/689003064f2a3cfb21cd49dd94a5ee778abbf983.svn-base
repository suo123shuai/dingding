package com.ddcar.service.impl;

import com.ddcar.entity.TbModelNumber;
import com.ddcar.mapper.TbModelNumberMapper;
import com.ddcar.service.TbModelNumberService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;

/**
 * Created by Administrator on 2018-09-03.
 */
@Service
public class TbModelNumberServiceImpl implements TbModelNumberService{

    @Autowired(required = false)
    TbModelNumberMapper tbModelNumberMapper;

    @Override
    public List<TbModelNumber> findTbModelNumberList(Integer page, Integer size,String model, Long brandId,Integer modelType) {
        PageHelper.startPage(page,size);
        return tbModelNumberMapper.findTbModelNumberList(model, brandId,modelType);
    }

    @Override
    public TbModelNumber selectByPrimaryKey(Long modelId) {
        return tbModelNumberMapper.selectByPrimaryKey(modelId);
    }

    @Override
    public TbModelNumber selectmodel(String model) {
        return tbModelNumberMapper.selectmodel(model);
    }

    @Override
    public Integer ifmodel(String model) {
        return tbModelNumberMapper.ifmodel(model);
    }

    @Override
    public List<TbModelNumber> selectbrandsearch(Long brandId) {
        return tbModelNumberMapper.selectbrandsearch(brandId);
    }

    @Override
    public List<HashMap> onPriceModel(Integer page, Integer size, String brandName, String model, Integer modelType,Long branchId) {
        PageHelper.startPage(page,size);
        return tbModelNumberMapper.onPriceModel(brandName,model,modelType,branchId);
    }

    @Transactional
    @Override
    public void delTbModelNumber(Long[] brandId) {
        for (Long id:brandId){
            tbModelNumberMapper.delTbModelNumber(id);
        }
    }

    @Override
    public Integer deltv(long modelId) {
        return tbModelNumberMapper.deltv(modelId);
    }

    @Transactional
    @Override
    public void add(TbModelNumber tbModelNumber) {
        tbModelNumberMapper.insertSelective(tbModelNumber);
    }

    @Transactional
    @Override
    public void update(TbModelNumber tbModelNumber) {
        tbModelNumberMapper.updateTbModelNumber(tbModelNumber);
    }

    @Override
    public void del(Integer id) {

    }
}
