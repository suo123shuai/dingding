package com.ddcar.mapper;


import com.ddcar.entity.TbInout;
import com.ddcar.entity.TbManager;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface TbManagerMapper {
    //List
    List<TbManager> findTbManagerList(@Param("managerId")Integer managerId,@Param("userAccount")String userAccount,@Param("userName")String userName,@Param("branchId")Integer branchId,@Param("branchName")String branchName);
    //分公司的管理员
    List<TbManager> companyAdmin();
    //用户名是否存在
    Integer ifUsername(@Param("userAccount")String userAccount);
    //该用户是否还在管理分公司
    Integer ifCom(@Param("managerId")Long managerId);
    //禁用
    void disable(@Param("managerId") Long managerId);
    //开启
    void open(@Param("managerId") Long managerId);
    //删除
    void del(@Param("managerId") Long managerId);

    int deleteByPrimaryKey(Long managerId);

    int insert(TbManager record);

    //新建管理员
    int insertManager(TbManager tbManager);

    TbManager selectByPrimaryKey(Long managerId);

    int updateByPrimaryKeySelective(TbManager record);
    //修改
    int updateManager(TbManager tbManager);
}