package com.yanxuan.test.controller;

import com.yanxuan.test.publicmethod.LogIn;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author yyhu3
 * @Date 2018-05-08 19:48
 */


@RestController
public class GetCookie {
    @Autowired
    LogIn logIn;
    @GetMapping("/yanxuan/login")
    public String openidLogin(String userName,String passWord)
    {
//        LogIn logIn = new LogIn();
        String logCookie = logIn.logInRequset();
        return logCookie;
    }
}
