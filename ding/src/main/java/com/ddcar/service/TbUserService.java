package com.ddcar.service;

import com.ddcar.entity.TbUser;

import java.util.HashMap;
import java.util.List;

/**
 * Created by Administrator on 2018-09-15.
 */
public interface TbUserService {
    //查询该公司的骑手
    List<HashMap> findComTbUser(Integer page, Integer size,Long branchId,Integer type,Long parentId);
    //查询该公司的团签
    List<HashMap> findComsign(Integer page, Integer size, Long branchId,Long userId,String userName);
    //团签下拉框
    List<HashMap> findTUser(Long branchId);
    //查询库里是否有该团签
    Integer iftq(String account);
    //新建团签
    void insertGroup(TbUser tbUser);
    //id查询团签
    TbUser idSearchComsign(Long userId);
    //编辑团签
    void updateGroup(TbUser tbUser);
    //编辑用户
    void updateuser(TbUser tbUser);
    //删除
    void delTbuser(Long[] userId);
    //启用
    void enable(Long[] userId);
    //关停
    void close(Long[] userId);

    /**
     * 查用户信息
     * @param weiXinId
     * @return
     * @throws Exception
     */
    TbUser getUserByWeiXinId(String weiXinId, String avatar)throws Exception;
}