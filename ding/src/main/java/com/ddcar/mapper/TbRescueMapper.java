package com.ddcar.mapper;


import com.ddcar.entity.RescueXin;
import com.ddcar.entity.TbRescue;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Mapper
public interface TbRescueMapper {
    List<HashMap> rescueList(@Param("branchId")Long branchId,@Param("userName")String userName,@Param("phone")String phone);

    int deleteByPrimaryKey(Long rescueId);

    int insert(TbRescue record);

    int insertSelective(TbRescue record);

    TbRescue selectByPrimaryKey(Long rescueId);

    /**
     * 更新救援信息
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(TbRescue record);

    int updateByPrimaryKey(TbRescue record);

    /**
     * 查询用户救援信息
     * @param map
     * @return
     */
    TbRescue findRescue(Map map);


    /**
     * 查用户是否发出过救援信息
     * @param userId
     * @return
     */
    RescueXin findRescuexin(long userId);

    /**
     * 更新救援状态
     * @param map
     * @return
     */
    int updRescuestatus(Map map);
}