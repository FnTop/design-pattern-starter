package com.luntron.controller;

import com.luntron.config.NotificationFactory;
import com.luntron.config.SendHandler;
import com.luntron.entity.RequestData;
import com.luntron.entity.ResponseResult;
import com.luntron.handler.DispatchSendHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

/**
 * @author luntron
 * @description 聚合平台设计模式的运用
 * @date 2022-12-24 20:54
 */

@RestController
public class CompositePlatController {

    @Autowired
    private DispatchSendHandler dispatchSendHandler;

    /**
     * 单类型发发送  站内信、短信、邮件
     */
    @RequestMapping("/send")
    public ResponseResult sendMessage() {
        RequestData request = new RequestData().setCode(SendHandler.sms.getCode()).setProviderCode(NotificationFactory.SmsWeiWang.getProviderCode());
        dispatchSendHandler.getHandler(request.getCode()).send(request);
        return new ResponseResult();
    }

    /**
     * 多类型发送
     */
    @RequestMapping("/type/send-way/1")
    public ResponseResult sendAllTypeMessage() {
        RequestData request = new RequestData().setCode(0b010).setProviderCode(NotificationFactory.SmsWeiWang.getProviderCode());
        RequestData request2 = new RequestData().setCode(0b001).setProviderCode(NotificationFactory.MailTencent.getProviderCode());
        List<RequestData> requestData = Arrays.asList(request, request2);
        requestData.forEach(r -> dispatchSendHandler.getHandler(r.getCode()).send(r));
        return new ResponseResult();
    }
}
