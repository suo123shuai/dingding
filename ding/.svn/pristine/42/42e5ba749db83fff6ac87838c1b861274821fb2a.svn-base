package com.ddcar.mapper;

import com.ddcar.entity.TbDot;
import io.lettuce.core.dynamic.annotation.Param;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Created by Administrator on 2018-09-11.
 */
@Mapper
public interface TbDtoMapper {

    //查询
    List<TbDot> findTbDot();
    //根据ID查询
    TbDot findTbDotId(Long dotId);
    //逻辑删除
    void delTbDot(@Param("dotId") Long dotId);
    //添加
    int insertTbDot(TbDot tbDot);
    //编辑
    int updateTbDot(TbDot tbDot);

}
