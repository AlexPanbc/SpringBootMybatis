package com.example.demo.service;

import com.example.demo.entity.SysMenuEntity;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by panbingcan on 2018/1/9.
 */
public interface SysMenuService {

    /**
     * 获取用户权限列表
     */
    Set<String> getUserPermissions(long userId);

    /**
     * 查询菜单列表
     */
    List<SysMenuEntity> queryList(Map<String, Object> map);
}
