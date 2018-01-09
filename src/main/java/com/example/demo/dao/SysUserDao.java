package com.example.demo.dao;

import com.example.demo.entity.SysUserEntity;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * Created by panbingcan on 2018/1/8.
 */
public interface SysUserDao extends BaseDao<SysUserEntity> {

    /**
     * 查询用户的所有权限
     *
     * @param userId 用户ID
     */
    List<String> queryAllPerms(Long userId);
//
//        /**
//         * 查询用户的所有菜单ID
//         */
//        List<Long> queryAllMenuId(Long userId);

    /**
     * 根据用户名，查询系统用户
     */
    SysUserEntity queryByUserName(String username);

//        /**
//         * 修改密码
//         */
//        int updatePassword(Map<String, Object> map);
}
