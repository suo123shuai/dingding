package com.ddcar.mapper;

import com.ddcar.entity.SendMessage;
import org.apache.ibatis.annotations.Mapper;

import java.util.Map;

@Mapper
public interface SendMessageMapper {

    /**
     * 查询当天同一手机号发送的短信数量
     * @param phone
     * @return
     */
    Integer getSmsSum(String phone);

    /**
     * 插入新信息
     * @param sendMessage
     * @return
     */
    int saveSendMessage(SendMessage sendMessage);

    /**
     * 查最新的发送短信和上次发送的时间查
     * @param map
     * @return
     */
    Long getCodeTime(String phone);

    /**
     * 查询短信验证是否过期和验证吗是否正确
     * @param map
     * @return
     */
    Long getCodeExpiredTime(Map map);
}
