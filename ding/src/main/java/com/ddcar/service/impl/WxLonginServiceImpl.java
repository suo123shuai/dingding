package com.ddcar.service.impl;

import com.ddcar.entity.TbUser;
import com.ddcar.mapper.TbUserMapper;
import com.ddcar.service.WxLonginService;
import com.ddcar.util.CommUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class WxLonginServiceImpl implements WxLonginService {

    @Resource
    private TbUserMapper tbUserMapper;

    @Override
    public TbUser WxLongin(String weixinId) {
        TbUser user = tbUserMapper.getUserByWeiXin(weixinId);
        if (null == user) {
            user = new TbUser();
            user.setWeixinId(weixinId);
            user.setCreateTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
            user.setType("3");
            Long id = tbUserMapper.getUpToDateQrCode();
            String carCode = CommUtil.getCarCode(3, id);
            user.setQrCode(carCode);
            tbUserMapper.insertSelective(user);
            user.setUserName(" ");
        }
        return user;
    }
}
