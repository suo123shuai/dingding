package com.ddcar.service;

import com.ddcar.entity.TbManager;
import com.ddcar.entity.TbModelNumber;
import org.apache.ibatis.annotations.Param;

import java.util.HashMap;
import java.util.List;

/**
 * Created by Administrator on 2018-09-03.
 */
public interface TbModelNumberService {
    //查询
    List<TbModelNumber> findTbModelNumberList(Integer page, Integer size,String model, Long brandId,Integer modelType);

    TbModelNumber  selectByPrimaryKey(Long modelId);
    //model查询
    TbModelNumber  selectmodel(String model);
    //查询库里是否有该型号
    Integer ifmodel(String model);

    List<TbModelNumber> selectbrandsearch(Long brandId);
    //查询没有设置价格的型号
    List<HashMap> onPriceModel(Integer page, Integer size,String brandName, String model, Integer modelType,Long branchId);
    //逻辑删除
    void delTbModelNumber(Long[] brandId);
    //查询该型号下是否有车
    Integer deltv(@Param("modelId")long modelId);
    void add(TbModelNumber tbModelNumber);

    void update(TbModelNumber tbModelNumber);

    void del(Integer id);

}
