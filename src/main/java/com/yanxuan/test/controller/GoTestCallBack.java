package com.yanxuan.test.controller;

import com.alibaba.fastjson.JSON;
import com.yanxuan.test.getproperties.GetProperties;
import com.yanxuan.test.publicmethod.SendEmail;
import com.yanxuan.test.request.HttpsRquest;
import com.yanxuan.test.responseReport.HandleResponse;
import io.swagger.annotations.ApiOperation;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.yanxuan.test.response.CallBackResponse;

/**
 * @Author yyhu3
 * @Date 2018-05-03 21:12
 */
@RestController
public class GoTestCallBack {
    @Autowired
    SendEmail sendEmailTest;
    @Autowired
    GetProperties getProperties;

    Logger logger = Logger.getLogger(GoTestCallBack.class);
    @ApiOperation(value="提供回调", notes="提供给gotest使用的回调接口")
    @RequestMapping(value="/yanxuan/callback",method= RequestMethod.GET)
    public String callback(@RequestHeader(value="taskId",defaultValue = "") String taskId)
    {

        CallBackResponse callBackResponse = new CallBackResponse();
        if (taskId==null || taskId.equals(""))
        {
            callBackResponse.setCode(400);
            callBackResponse.setMsg("未获取到有效的taskid");
        }
//        String taskId = "d147d0eb-4ac4-11e8-a4d4-6d0a0c2e1ab9";
        else{
            HttpsRquest httpsRquest = new HttpsRquest();
            String responseResult = httpsRquest.httpsCallBackPost(taskId);
            HandleResponse handleResponse = new HandleResponse();
            handleResponse.encapsuReportDetail(responseResult);
            callBackResponse.setCode(200);
            callBackResponse.setMsg("success");
        }
        callBackResponse.setEmailSender(getProperties.emailSender);
        logger.info("返回包给gotest的返回包为:"+JSON.toJSONString(callBackResponse));
        sendEmailTest.sendMail();

        return JSON.toJSONString(callBackResponse);
    }
}
