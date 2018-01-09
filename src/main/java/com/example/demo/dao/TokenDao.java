package com.example.demo.dao;

import com.example.demo.entity.TokenEntity;

/**
 * Created by panbingcan on 2018/1/9.
 */
public interface TokenDao  extends BaseDao<TokenEntity>{

    TokenEntity queryByToken(String token);
}
