package com.example.demo.service.impl;

import com.example.demo.dao.UserDao;
import com.example.demo.entity.UserEntity;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by panbingcan on 2018/1/9.
 */
@Service("userService")
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Override
    public UserEntity queryObject(Long userId) {
        return userDao.queryObject(userId);
    }
    @Override
    public List<UserEntity> queryList(Map<String, Object> map){
        return userDao.queryList(map);
    }

}
