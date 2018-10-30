package com.ddcar.service.impl;

import com.ddcar.entity.Feedback;
import com.ddcar.entity.Image;
import com.ddcar.mapper.FeedbackMapper;
import com.ddcar.mapper.ImageMapper;
import com.ddcar.service.FeedbackService;
import com.github.pagehelper.PageHelper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

@Service
public class FeedbackServiceImpl implements FeedbackService {


    @Resource
    private FeedbackMapper feedbackMapper;

    @Resource
    private ImageMapper imageMapper;



    @Override
    @Transactional
    public Long saveFeedback(String content, Long userId, String addresss) {
        Feedback feedback = new Feedback();
        feedback.setCreateTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        feedback.setUserId(userId);
        feedback.setContent(content);
        Image im = new Image();
        feedbackMapper.saveFeedback(feedback);
        String[] split = addresss.split(",");
        for (int i=0; split.length > i; i++){
            im.setFeedbzckId(feedback.getFeedbackId());
            im.setAddress(split[i]);
            imageMapper.saveImage(im);
        }
        return feedback.getFeedbackId();
    }

    @Override
    public List<HashMap> findFeedback(Integer page, Integer size, String content, Integer state, String userName) {
        PageHelper.startPage(page,size);
        return feedbackMapper.findFeedback(content,state,userName);
    }

    @Override
    public void del(Long[] feedbackId) {
        for (Long id:feedbackId){
            feedbackMapper.del(id);
        }
    }

    @Override
    public void seate(Long[] feedbackId) {
        for (Long id:feedbackId){
            feedbackMapper.seate(id);
        }
    }

    @Override
    public List<Image> selectFeedbzckId(Long feedbzckId) {
        return imageMapper.selectFeedbzckId(feedbzckId);
    }
}
