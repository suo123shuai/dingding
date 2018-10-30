package com.ddcar.mapper;


import com.ddcar.entity.NumModel;
import com.ddcar.entity.TbManager;
import com.ddcar.entity.TbModelNumber;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Mapper
public interface TbModelNumberMapper {
    /*findall*/
    List<TbModelNumber> findTbModelNumberList(@Param("model")String model,@Param("brandId")Long brandId,@Param("modelType")Integer modelType);
    /*modelIdSearch*/
    TbModelNumber selectByPrimaryKey(Integer modelId);
    //model查询
    TbModelNumber selectmodel(@Param("model") String model);
    /*brandIdSearch*/
    List<TbModelNumber> selectbrandsearch(Long brandId);
    //查询没有设置价格的型号
    List<HashMap> onPriceModel(@Param("brandName")String brandName, @Param("model")String model, @Param("modelType")Integer modelType,@Param("branchId")Long branchId);
    //逻辑删除型号
    void delTbModelNumber(@Param("modelId") Long modelId);
    //查询该型号下是否有车
    Integer deltv(@Param("modelId")long modelId);
    //查询库里是否有该型号
    Integer ifmodel(@Param("model")String model);

    int deleteByPrimaryKey(Long modelId);

    int insert(TbModelNumber tbModelNumber);

    int insertSelective(TbModelNumber tbModelNumber);

    TbModelNumber selectByPrimaryKey(Long modelId);
    //编辑型号
    int updateTbModelNumber(TbModelNumber tbModelNumber);

    int updateByPrimaryKey(TbModelNumber record);

    /**
     * 查询网点车电型号数量
     * @param map
     * @return
     */
    List<NumModel> findWangUserModelAmount(Map map);
}