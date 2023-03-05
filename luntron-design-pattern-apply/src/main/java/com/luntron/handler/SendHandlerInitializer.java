package com.luntron.handler;

import com.luntron.config.SendHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

/**
 * @author luntron
 * @description 消息处理器初始化
 * @date ${DATE} ${TIME}
 * @file-header idea setting > file and templates > includes > file header
 */
@Component
public class SendHandlerInitializer implements ApplicationContextAware {
    private ApplicationContext applicationContext;
    /**
     * logback
     */
    private final static Logger logger = LoggerFactory.getLogger(SendHandlerInitializer.class);
    public static final Map<Integer, AbstractSendHandler> loadSucceedSendHandlers = new HashMap<>(4);

    @PostConstruct
    public void init() {
        logger.info("######>>>>>> initializing sendHandler >>>>>>######");
        SendHandler[] sendHandlers = SendHandler.values();
        for (int length = sendHandlers.length, i = 0; i < length; i++) {
            boolean loadSucceed = false;
            AbstractSendHandler sendHandler = null;
            try {
                sendHandler = (AbstractSendHandler) applicationContext.getBean(sendHandlers[i].getBeanName());
                loadSucceed = true;
            } catch (BeansException e) {
                logger.info(">>>>>> {} initialize failed，Check whether the bean Name is configured correctly ", sendHandlers[i].getName());
            }
            if (loadSucceed) {
                loadSucceedSendHandlers.put(sendHandlers[i].getCode(), sendHandler);
                logger.info(">>>>>> {} initialized ", sendHandlers[i].getName());
            }
        }

        logger.info("######>>>>>> initialization completed >>>>>>######");

    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}
