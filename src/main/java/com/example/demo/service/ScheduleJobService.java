package com.example.demo.service;

import com.example.demo.entity.ScheduleJobEntity;

import java.util.List;
import java.util.Map;

/**
 * Created by Alex on 2018/1/11.
 */
public interface ScheduleJobService {


    /**
     * 根据ID，查询定时任务
     */
    ScheduleJobEntity queryObject(Long jobId);
    /**
     * 查询定时任务列表
     */
    List<ScheduleJobEntity> queryList(Map<String, Object> map);

    /**
     * 查询总数
     */
    int queryTotal(Map<String, Object> map);

    /**
     * 保存定时任务
     */
    void save(ScheduleJobEntity scheduleJob);


    /**
     * 立即执行
     */
    void run(Long[] jobIds);
}
