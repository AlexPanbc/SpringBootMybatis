package com.example.demo.service;

import com.example.demo.entity.SysUserEntity;

/**
 * Created by panbingcan on 2018/1/8.
 */
public interface SysUserService {

    /**
     * 根据用户名，查询系统用户
     */
    SysUserEntity queryByUserName(String username);
}
