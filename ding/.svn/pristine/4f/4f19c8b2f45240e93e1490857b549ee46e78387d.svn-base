package com.ddcar.service;

import com.ddcar.entity.TbInout;
import com.ddcar.entity.TbManager;

import java.util.List;

/**
 * Created by Administrator on 2018-09-03.
 */
public interface TbManagerService {

    List<TbManager> findInoutMapperList(Integer page, Integer size,Integer managerId,String userAccount,String userName,Integer branchId,String branchName);

    List<TbManager> companyAdmin();
    //查询是否有该用户名
    Integer ifUsername(String userAccount);
    //查询是否绑定分公司
    Integer ifCom(Long managerId);
    //禁用
    void disable(Long[] managerId);
    //开启
    void open(Long[] managerId);
    //删除
    void del(Long[] managerId);
    //新建管理员
    void add(TbManager tbManager);
    //修改
    void update(TbManager tbManager);

    void del(Integer id);

}
