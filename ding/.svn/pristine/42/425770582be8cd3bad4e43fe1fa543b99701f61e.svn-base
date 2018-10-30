package com.ddcar.mapper;

import com.ddcar.entity.Feedback;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.HashMap;
import java.util.List;

@Mapper
public interface FeedbackMapper {

    /**
     * 插入新的反馈信息
     * @param feedback
     * @return
     */
    int saveFeedback(Feedback feedback);


    //查询反馈信息
    List<HashMap> findFeedback(@Param("content")String content,@Param("state")Integer state,@Param("userName")String userName);
    //删除
    void del(@Param("feedbackId") Long feedbackId);
    //已处理
    void seate(@Param("feedbackId") Long feedbackId);


}
