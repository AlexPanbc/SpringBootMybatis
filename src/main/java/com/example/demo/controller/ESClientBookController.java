package com.example.demo.controller;

import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.client.transport.TransportClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 书籍控制器
 * 主要目的 实现elasticsearch的查询功能演练
 * Created by Alex on 2018/1/25.
 */
@RestController
@RequestMapping("/esbook")
public class ESClientBookController {

    /**
     * 注入es操作对象
     */
    @Autowired
    private TransportClient client;

    @GetMapping(value = "/get")
    public ResponseEntity get() {

        GetResponse result = client.prepareGet("client", "book", "1").get();
        if (!result.isExists()) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity(result.getSource(), HttpStatus.OK);
    }
}
