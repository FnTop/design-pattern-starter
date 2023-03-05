package com.luntron.handler.sms;

import com.luntron.entity.RequestData;
import com.luntron.entity.ResponseResult;
import com.luntron.handler.ApiSend;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @author luntron
 * @description
 * @date 2022/1/2 19:14
 */
@Component
public class SmsWeiWangApiSend implements ApiSend {
    private final static Logger logger = LoggerFactory.getLogger(SmsWeiWangApiSend.class);

    @Override
    public ResponseResult send(RequestData requestData) {
        logger.info(">>>>> 调用微网接口发送短信");
        return null;
    }
}
