package com.example.demo.controller;

import com.example.demo.entity.ScheduleJobEntity;
import com.example.demo.service.ScheduleJobService;
import com.example.demo.utils.PageUtils;
import com.example.demo.utils.Query;
import com.example.demo.utils.R;
import com.example.demo.utils.validator.ValidatorUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * Created by panbingcan on 2018/1/11.
 */
@RestController
@RequestMapping("/sys/schedule")
public class ScheduleJobController {


    @Autowired
    private ScheduleJobService scheduleJobService;

    @RequiresPermissions("sys:schedule:list")
    @GetMapping("/list")
    public R jobList(@RequestParam Map<String,Object> params)
    {
        Query query =new Query(params);
        List<ScheduleJobEntity> jobList =scheduleJobService.queryList(query);
        int total = scheduleJobService.queryTotal(query);

        PageUtils pageUtil = new PageUtils(jobList, total, query.getLimit(), query.getPage());

        return R.ok().put("page", pageUtil);
    }

    /**
     * 定时任务信息
     */
    @RequestMapping("/info/{jobId}")
    @RequiresPermissions("sys:schedule:info")
    public R info(@PathVariable("jobId") Long jobId){
        ScheduleJobEntity schedule = scheduleJobService.queryObject(jobId);
        return R.ok().put("schedule", schedule);
    }

//    /**
//     * 保存定时任务
//     */
//    @SysLog("保存定时任务")
//    @RequestMapping("/save")
//    @RequiresPermissions("sys:schedule:save")
//    public R save(@RequestBody ScheduleJobEntity scheduleJob){
//        ValidatorUtils.validateEntity(scheduleJob);
//
//        scheduleJobService.save(scheduleJob);
//
//        return R.ok();
//    }

}
