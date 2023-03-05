package com.luntron.handler;

import com.luntron.config.NotificationFactory;
import com.luntron.entity.RequestData;
import com.luntron.handler.ApiSend;
import com.luntron.handler.SendHandlerInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

/**
 * @author luntron
 * @description 短信通知商初始化
 * @date 2022/1/2 18:37
 */

@Component
@AutoConfigureAfter(SendHandlerInitializer.class)
public class ApiSendFactory implements ApplicationContextAware {
    private ApplicationContext applicationContext;
    /**
     * logback
     */
    private final static Logger logger = LoggerFactory.getLogger(SendHandlerInitializer.class);
    public static final Map<Integer, ApiSend> loadSucceedSenders = new HashMap<>(8);

    @PostConstruct
    public void init() {
        logger.info("######>>>>>> initializing send providers >>>>>>######");
        NotificationFactory[] senders = NotificationFactory.values();
        for (int length = senders.length, i = 0; i < length; i++) {
            boolean loadSucceed = false;
            ApiSend sender = null;
            try {
                sender = (ApiSend) applicationContext.getBean(senders[i].getBeanName());
                loadSucceed = true;
            } catch (BeansException e) {
                logger.info(">>>>>> {} initialize failed，Check whether the bean Name is configured correctly ", senders[i].getName());
            }
            if (loadSucceed) {
                loadSucceedSenders.put(senders[i].getProviderCode(), sender);
                logger.info(">>>>>> {} initialized ", senders[i].getName());
            }
        }

        logger.info("######>>>>>> initialization completed >>>>>>######");

    }

    public ApiSend getSender(Integer providerCode) {
        if (providerCode != null && loadSucceedSenders.get(providerCode) != null) {
            logger.info(">>>>>> send provider is {}", loadSucceedSenders.get(providerCode));
            return loadSucceedSenders.get(providerCode);
        }
        logger.info(">>>>>> provider not found, providerCode is {}, please check NotificationFactory config", providerCode);
        return null;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}
