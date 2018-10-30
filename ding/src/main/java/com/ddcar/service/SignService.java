package com.ddcar.service;

import com.common.BaseBean;

/**
 *团签  Service接口
 * @author wcy
 */
public interface SignService {

    /**
     * 登陆
     * @param account 账号
     * @param pwd 密码
     * @return
     */
    BaseBean login(String account,String pwd);

    /**
     * 根据团签id查询该团签得骑手
     *
     * @param parentId 团签id
     * @param page 页码
     * @param type  类型
     * @return
     */
    BaseBean queryUserByParentId(Integer page,Long parentId,Long type);

    /**
     * 绑定骑手
     * @param parentId 团签id
     * @param code 二维码字符串
     * @return
     */
    BaseBean bindUser(Long parentId,String code);

    /**
     * 解绑绑定骑手
     * @param parentId 团签id
     * @param userId 用户id
     * @return
     */
    BaseBean unbindUser(Long parentId,Long userId);

    /**
     * 用户详细信息
     * @param userId 用户id
     * @param parentId 团签id
     * @return 信息
     */
    BaseBean detail(Long parentId,Long userId);
}
