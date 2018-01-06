package com.example.demo.controller;

import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;

/**
 * Created by Alex on 2018/1/6.
 */
@RestController
@RequestMapping
public class LoginController {

    @PostMapping("/sys/login")
    public String login(@RequestParam("username")String name,@RequestParam("password")String password) {

        return "哈哈哈";
    }
}
