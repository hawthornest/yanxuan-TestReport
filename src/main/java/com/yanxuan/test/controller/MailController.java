package com.yanxuan.test.controller;

import com.yanxuan.test.getproperties.GetProperties;
import com.yanxuan.test.publicmethod.SendEmail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author yyhu3
 * @Date 2018-05-08 20:31
 */

@RestController
public class MailController {

    @Autowired
    SendEmail sendEmailTest;

    @Autowired
    GetProperties getProperties;

    @GetMapping("/sendemail")
    public String sendEmail()
    {
        sendEmailTest.sendMail();
        return getProperties.emailSender;
    }
}
