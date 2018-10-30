package com.ddcar.service;

import com.ddcar.entity.TbPrice;

import java.util.HashMap;
import java.util.List;

/**
 * Created by Administrator on 2018-09-13.
 */
public interface TbPriceService {

	//查询该公司型号的价格
	List<HashMap> modelprice(Integer page, Integer size,Long branchId,Integer modelId,Integer modelType,Integer brandId);
	//设置价格
	void add(TbPrice tbPrice);
	//编辑价格
	void updatePrice(TbPrice tbPrice);
}
