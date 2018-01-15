package com.example.demo.service;

import com.example.demo.entity.SysUserEntity;

import java.util.List;
import java.util.Map;

/**
 * Created by panbingcan on 2018/1/8.
 */
public interface SysUserService {

    /**
     * 根据用户名，查询系统用户
     */
    SysUserEntity queryByUserName(String username);

    /**
     * 查询用户的所有权限
     * @param userId  用户ID
     */
    List<String> queryAllPerms(Long userId);


    /**
     * 查询用户列表
     */
    List<SysUserEntity> queryList(Map<String, Object> map);


    /**
     * 查询总数
     */
    int queryTotal(Map<String, Object> map);


    /**
     * 根据用户ID，查询用户
     * @param userId
     * @return
     */
    SysUserEntity queryObject(Long userId);

}
