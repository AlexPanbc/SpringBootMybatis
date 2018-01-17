package com.example.demo.task;

import com.example.demo.entity.SysUserEntity;
import com.example.demo.service.SysUserService;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by Alex on 2018/1/15.
 */
@Component("PPtestTask")
public class PPtestTask {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private SysUserService sysUserService;

    public void PPtest(String params) {

        logger.info("我是带参数的PPtest方法，正在被执行，参数为：" + params);
        try {
            Thread.sleep(1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        SysUserEntity user = sysUserService.queryObject(1L);
        System.out.println(ToStringBuilder.reflectionToString(user));
    }

    public void PPtest2() {
        logger.info("我是不带参数的test2方法，正在被执行");
    }
}
