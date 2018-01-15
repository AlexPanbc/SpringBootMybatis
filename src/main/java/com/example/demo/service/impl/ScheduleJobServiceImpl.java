package com.example.demo.service.impl;

import com.example.demo.dao.ScheduleJobDao;
import com.example.demo.entity.ScheduleJobEntity;
import com.example.demo.service.ScheduleJobService;
import com.example.demo.utils.Constant.ScheduleStatus;
import com.example.demo.utils.ScheduleUtils;
import org.quartz.Scheduler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by Alex on 2018/1/11.
 */
@Service("scheduleJobService")
public class ScheduleJobServiceImpl implements ScheduleJobService {
    @Autowired
    private Scheduler scheduler;
    @Autowired
    private ScheduleJobDao schedulerJobDao;

    @Override
    public ScheduleJobEntity queryObject(Long jobId) {
        return schedulerJobDao.queryObject(jobId);
    }

    @Override
    public List<ScheduleJobEntity> queryList(Map<String, Object> map) {

        return schedulerJobDao.queryList(map);
    }

    @Override
    public int queryTotal(Map<String, Object> map) {
        return schedulerJobDao.queryTotal(map);
    }

    @Override
    @Transactional
    public void save(ScheduleJobEntity scheduleJob) {
        scheduleJob.setCreateTime(new Date());
        scheduleJob.setStatus(ScheduleStatus.NORMAL.getValue());
        schedulerJobDao.save(scheduleJob);// TODO: 2018/1/15  存入数据表 

        ScheduleUtils.createScheduleJob(scheduler, scheduleJob);// TODO: 2018/1/15 调用quartz 创建job
    }


}
