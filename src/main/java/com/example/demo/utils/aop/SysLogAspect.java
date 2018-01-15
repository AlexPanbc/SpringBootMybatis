package com.example.demo.utils.aop;

import com.alibaba.fastjson.JSON;
import com.example.demo.entity.SysLogEntity;
import com.example.demo.service.SysLogService;
import com.example.demo.utils.HttpContextUtils;
import com.example.demo.utils.IPUtils;
import com.example.demo.utils.ShiroUtils;
import com.example.demo.utils.annotation.SysLog;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.Date;

/**
 * Created by Alex on 2018/1/15.
 */
@Aspect
@Component
public class SysLogAspect {
    @Autowired
    private SysLogService sysLogService;

    @Pointcut("@annotation(com.example.demo.utils.annotation.SysLog)")
    public void logPointCut() {
    }

    @Before("logPointCut()")
    public void saveSysLog(JoinPoint joinPoint) {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();

        SysLogEntity sysLogEntity = new SysLogEntity();
        SysLog syslog = method.getAnnotation(SysLog.class);
        if (syslog != null)
            sysLogEntity.setOperation(syslog.value());
        // TODO: 2018/1/15 请求方法名
        String className = joinPoint.getTarget().getClass().getName();
        String methodName = signature.getName();
        sysLogEntity.setMethod(className + "." + methodName + "()");

        // TODO: 2018/1/15  请求的参数
        Object[] args = joinPoint.getArgs();
        String params = JSON.toJSONString(args[0]);
        sysLogEntity.setParams(params);

        // TODO: 2018/1/15 获取request
        HttpServletRequest request = HttpContextUtils.getHttpServletRequest();

        // TODO: 2018/1/15 设置ip地址
        sysLogEntity.setIp(IPUtils.getIpAddr(request));
        // TODO: 2018/1/15 用户名
        String username = ShiroUtils.getUserEntity().getUsername();
        sysLogEntity.setUsername(username);

        sysLogEntity.setCreateDate(new Date());

        // TODO: 2018/1/15 保存系统之日
        sysLogService.save(sysLogEntity);

    }

}
