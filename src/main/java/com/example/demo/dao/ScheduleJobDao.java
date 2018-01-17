package com.example.demo.dao;

import com.example.demo.entity.ScheduleJobEntity;

import java.util.Map;

/**
 * Created by panbingcan on 2018/1/11.
 */

public interface ScheduleJobDao extends BaseDao<ScheduleJobEntity> {

    /**
     * 批量更新状态
     */
    int updateBatch(Map<String, Object> map);
}
