package com.yanxuan.test.controller;

import com.yanxuan.test.getproperties.GetProperties;
import com.yanxuan.test.publicmethod.SendEmail;
import io.swagger.annotations.ApiOperation;
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

    @ApiOperation(value="发送邮件", notes="将测试报告发送邮件给收件人")
    @GetMapping("/sendemail")
    public String sendEmail()
    {
        sendEmailTest.sendMail();
        return getProperties.emailSender;
    }
}
