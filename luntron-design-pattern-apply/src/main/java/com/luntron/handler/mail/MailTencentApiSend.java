package com.luntron.handler.mail;

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
public class MailTencentApiSend implements ApiSend {
    private final static Logger logger = LoggerFactory.getLogger(MailTencentApiSend.class);

    @Override
    public ResponseResult send(RequestData requestData) {
        logger.info(">>>>> 调用腾讯邮件进行发送邮件");
        return null;
    }
}
