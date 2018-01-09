package com.example.demo.service;

import com.example.demo.entity.TokenEntity;

/**
 * Created by panbingcan on 2018/1/9.
 */
public interface TokenService {

    TokenEntity queryByToken(String token);
}
