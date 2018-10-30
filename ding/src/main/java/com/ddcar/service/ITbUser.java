package com.ddcar.service;

import com.ddcar.entity.TbBranch;
import com.ddcar.entity.TbUser;

import java.util.Map;

public interface ITbUser {

    /**
     * 用户登录
     * @param map
     * @return
     */
    TbBranch loginUser(Map map);


}
