package com.ddcar.mapper;


import com.ddcar.entity.TbPrice;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface TbPriceMapper {
	
	//查询该公司型号的价格
    List<HashMap> modelprice(@Param("branchId")Long branchId, @Param("modelId")Integer modelId, @Param("modelType")Integer modelType,@Param("brandId")Integer brandId);
    
    int deleteByPrimaryKey(Long priceId);

    int insert(TbPrice record);
    //设置价格
    int insertprice(TbPrice tbPrice);

    TbPrice selectByPrimaryKey(Long priceId);

    int updatePrice(TbPrice tbPrice);

    int updateByPrimaryKey(TbPrice record);
}