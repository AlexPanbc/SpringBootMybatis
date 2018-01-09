package com.example.demo.service.impl;

import com.example.demo.dao.TokenDao;
import com.example.demo.entity.TokenEntity;
import com.example.demo.service.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by panbingcan on 2018/1/9.
 */
@Service
public class TokenServiceImpl implements TokenService {

    @Autowired
    private TokenDao tokenDao;

    @Override
    public TokenEntity queryByToken(String token) {
        return tokenDao.queryByToken(token);
    }
}
