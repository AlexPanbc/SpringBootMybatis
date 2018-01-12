package com.example.demo.service;

import com.example.demo.entity.ScheduleJobLogEntity;

/**
 * Created by panbingcan on 2018/1/12.
 */
public interface ScheduleJobLogService {

    /**
     * 保存定时任务日志
     */
    void save(ScheduleJobLogEntity log);
}
