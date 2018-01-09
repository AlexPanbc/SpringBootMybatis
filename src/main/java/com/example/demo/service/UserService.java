package com.example.demo.service;

import com.example.demo.entity.UserEntity;

import java.util.List;
import java.util.Map;

/**
 * Created by panbingcan on 2018/1/9.
 */
public interface UserService {

    UserEntity queryObject(Long userId);

    List<UserEntity> queryList(Map<String, Object> map);

}
