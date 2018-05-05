package com.yanxuan.test.controller;

import com.alibaba.fastjson.JSON;
import com.yanxuan.test.request.HttpsRquest;
import com.yanxuan.test.responseReport.HandleResponse;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;
import com.yanxuan.test.response.CallBackResponse;

/**
 * @Author yyhu3
 * @Date 2018-05-03 21:12
 */
@RestController
public class GoTestCallBack {
    Logger logger = Logger.getLogger(GoTestCallBack.class);
    @GetMapping("/yanxuan/callback")
    public String callback(@RequestHeader(value="taskId",defaultValue = "") String taskId)
    {
        PropertyConfigurator.configure("config/log4j.properties");
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
        logger.info("返回包给gotest的返回包为:"+JSON.toJSONString(callBackResponse));
        return JSON.toJSONString(callBackResponse);
    }
}
