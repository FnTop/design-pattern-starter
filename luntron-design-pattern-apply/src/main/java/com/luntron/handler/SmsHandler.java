package com.luntron.handler;

import com.luntron.config.SendHandler;
import com.luntron.entity.RequestData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author luntron
 * @description 短信处理器
 * @date 2022/1/2 2:34
 */
@Component
public class SmsHandler extends AbstractSendHandler {

    private final static Logger logger = LoggerFactory.getLogger(SmsHandler.class);
    @Autowired
    private ApiSendFactory apiSendFactory;

    @Override
    public ApiSend getProvider(Integer providerCode) {
        return apiSendFactory.getSender(providerCode);
    }

    @Override
    public Integer getDefaultCode() {
        return SendHandler.sms.getCode();
    }
}
