package com.ddcar.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.HashMap;
import java.util.List;

/**
 * Created by Administrator on 2018-10-09.
 */
@Mapper
public interface BilMapper {

    //平台查看流水
    List<HashMap> flowList(@Param("wangUserId")String wangUserId,@Param("start")String start,@Param("end")String end,@Param("branchId")Long branchId);
    //分公司查看流水
    List<HashMap> accountFlow(@Param("branchId")Long branchId,@Param("wangUserId")String wangUserId,@Param("start")String start,@Param("end")String end);

}
