package com.yanxuan.test.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.yanxuan.test.request.HttpsRquest;
import com.yanxuan.test.response.CallBackResponse;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author yyhu3
 * @Date 2018-05-05 15:38
 */

@RestController
public class TaskRun {
    Logger logger = Logger.getLogger(TaskRun.class);
    @ApiOperation(value="执行测试用例", notes="根据测试集id执行用例")
//    @ApiImplicitParam(name = "testId", value = "测试集id", required = true, dataType = "String")
    @GetMapping("/yanxuan/taskrun")
    public String executeTtestCase(String testId,String environmentId,String callBackUrl)
    {

        CallBackResponse implementRespons = new CallBackResponse();
        HttpsRquest httpsRquest = new HttpsRquest();
        String runResponse = httpsRquest.httpsTaskRunPost(testId,environmentId,callBackUrl);
        JSONObject runResponseJson = JSON.parseObject(runResponse);
        logger.info("执行测试用例返回包为:"+JSON.toJSONString(runResponse));
        int responseData = runResponseJson.getInteger("code");
        String errorMsg = runResponseJson.getString("msg");
        implementRespons.setCode(responseData);
        implementRespons.setMsg(errorMsg);
        return JSON.toJSONString(implementRespons);
    }
}
