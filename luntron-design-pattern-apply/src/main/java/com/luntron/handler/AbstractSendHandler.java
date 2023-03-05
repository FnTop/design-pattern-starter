package com.luntron.handler;


import com.luntron.entity.RequestData;
import com.luntron.entity.ResponseResult;
import com.luntron.handler.sms.SmsWeiWangApiSend;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * @author luntron
 * @description
 * @date 2022/1/2 3:11
 */
public abstract class AbstractSendHandler {

    private final static Logger logger = LoggerFactory.getLogger(SmsWeiWangApiSend.class);

    public abstract ApiSend getProvider(Integer providerCode);

    public abstract Integer getDefaultCode();

    public ResponseResult send(RequestData requestData) {
        ApiSend provider = getProvider(requestData.getProviderCode());
        if (check(requestData.getCode()) && provider != null) {
            return provider.send(requestData);
        }
        return null;
    }

    public boolean check(Integer handlerCode) {
        Integer defaultCode = getDefaultCode();
        if (handlerCode != null && (handlerCode & defaultCode) == defaultCode) {
            return true;
        }
        return false;
    }
}
