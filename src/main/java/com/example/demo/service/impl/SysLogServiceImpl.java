package com.example.demo.service.impl;

import com.example.demo.dao.SysLogDao;
import com.example.demo.entity.SysLogEntity;
import com.example.demo.service.SysLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by panbingcan on 2018/1/15.
 */
@Service("sysLogService")
public class SysLogServiceImpl implements SysLogService {
    @Autowired
    private SysLogDao sysLogDao;
    @Override
    public void save(SysLogEntity sysLog) {
        sysLogDao.save(sysLog);
    }
}
