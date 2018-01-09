package com.example.demo.dao;

import com.example.demo.entity.UserEntity;

/**
 * Created by panbingcan on 2018/1/9.
 */
public interface UserDao extends BaseDao<UserEntity> {

    UserEntity queryByMobile(String mobile);
}
