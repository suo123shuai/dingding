package com.ddcar.service;


import com.ddcar.entity.TbUser;

public interface WxLonginService {

    /**
     * 微信id获取用户信息
     * @param weixinId
     * @return
     */
    TbUser WxLongin(String weixinId);
}
