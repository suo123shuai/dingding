package com.ddcar.service;

import com.ddcar.entity.TbBrand;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by Administrator on 2018-09-03.
 */
public interface TbBrandService {
    //全部
    List<TbBrand> findTbBrandMapperList(Integer page, Integer size,String brandName);
    //查询库里是否有该品牌
    Integer ifbrandName(String brandName);
    //查询该品牌下是否有型号
    Integer delmod(@Param("brandId")long brandId);
    //全部（下拉框使用）
    List<TbBrand> findList();
    //根据品牌名称查询
    TbBrand brandName(String brandName);
    //id查询
    TbBrand tbBrandid(Long brandId);
    //逻辑删除
    void delTbBrand(Long[] brandId);

    void add(TbBrand tbBrand);
    //编辑品牌
    void update(TbBrand tbBrand);

    void del(Integer brandId);

}
