package com.ddcar.service.impl;


import com.ddcar.entity.TbPrice;
import com.ddcar.entity.TbVehicle;
import com.ddcar.mapper.TbPriceMapper;
import com.ddcar.mapper.TbVehicleMapper;
import com.ddcar.service.TbPriceService;
import com.github.pagehelper.PageHelper;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


/**
 * Created by Administrator on 2018-09-03.
 */
@Service
public class TbPriceServiceImpl implements TbPriceService{

	 @Autowired(required = false)
	 TbPriceMapper tbPriceMapper;
	 @Autowired
	 TbVehicleMapper tbVehicleMapper;
	
	@Override
	public List<HashMap> modelprice(Integer page, Integer size,Long branchId,Integer modelId,Integer modelType,Integer brandId) {
		PageHelper.startPage(page,size);
        return tbPriceMapper.modelprice(branchId,modelId,modelType,brandId);
	}
	@Transactional
	@Override
	public void add(TbPrice tbPrice) {
		tbPriceMapper.insertprice(tbPrice);
		tbVehicleMapper.upveh(tbPrice);
	}
	@Transactional
	@Override
	public void updatePrice(TbPrice tbPrice) {
		tbPriceMapper.updatePrice(tbPrice);
	}

}
