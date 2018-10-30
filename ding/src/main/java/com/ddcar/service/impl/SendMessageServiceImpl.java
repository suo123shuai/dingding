package com.ddcar.service.impl;

import com.ddcar.entity.SendMessage;
import com.ddcar.mapper.SendMessageMapper;
import com.ddcar.service.SendMessageService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Map;

@Service
public class SendMessageServiceImpl implements SendMessageService {

    @Resource
    private SendMessageMapper sendMessageMapper;

    @Override
    public Integer getSmsSum(String phone) {
        Integer smsSum = sendMessageMapper.getSmsSum(phone);
                if(null == smsSum){
                    smsSum = 0;
                };
        return smsSum;
    }

    @Override
    public int saveSendMessage(SendMessage sendMessage) {
        return sendMessageMapper.saveSendMessage(sendMessage);
    }

    @Override
    public Long getCodeTime(String phone) {
        return sendMessageMapper.getCodeTime(phone);
    }

    @Override
    public Long getCodeExpiredTime(Map map) {
        return sendMessageMapper.getCodeExpiredTime(map);
    }
}
