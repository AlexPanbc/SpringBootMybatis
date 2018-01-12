package com.example.demo.service.impl;

import com.example.demo.dao.ScheduleJobLogDao;
import com.example.demo.entity.ScheduleJobLogEntity;
import com.example.demo.service.ScheduleJobLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by panbingcan on 2018/1/12.
 */

@Service("scheduleJobLogService")
public class ScheduleJobLogServiceImpl implements ScheduleJobLogService {

    @Autowired
    private ScheduleJobLogDao scheduleJobLogDao;

    @Override
    public void save(ScheduleJobLogEntity log) {
        scheduleJobLogDao.save(log);
    }
}
