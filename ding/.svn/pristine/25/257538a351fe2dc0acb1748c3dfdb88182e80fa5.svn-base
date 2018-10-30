package com.ddcar.mapper;


import com.ddcar.entity.TbBrand;
import com.ddcar.entity.TbInout;
import com.ddcar.entity.Vehicles;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper
public interface TbInoutMapper {
    //入库
    List<TbInout> findTbInoutList(Integer page, Integer size);
    //出库
    List<TbInout> findTbInoutListout(Integer page, Integer size);
    //IDSearch
    TbBrand findTbBrandId(@Param("brandId") Long brandId);

    int deleteByPrimaryKey(Long inoutId);

    int insert(TbInout record);
    //添加一条入库记录
    int insertTbInout(TbInout tbInout);

    TbInout selectByPrimaryKey(Long inoutId);

    int updateByPrimaryKeySelective(TbInout record);

    int updateByPrimaryKey(TbInout record);

    /**
     * 查询本网点待入库车电信息
     * @param userId
     * @return
     */
    List<Vehicles> inWarehouse(long userId);

    /**
     * 网点入库后更新
     * @param map
     * @return
     */
    int confirmInOut(Map map);

    /**
     * 网点出库
     * @param map
     * @return
     */
    int exitConfirm(Map map);

    /**
     * 查询本网点出库车电信息
     * @param userId
     * @return
     */
    List<Vehicles> outWarehouse(long userId);
}