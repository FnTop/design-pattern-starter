package com.luntron.handler;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author luntron
 * @description
 * @date 2022/1/2 4:49
 */
@Component
public class DispatchSendHandler {

    public List<AbstractSendHandler> getHandlers(Integer handlerCode) {
        List<AbstractSendHandler> sendHandlers = new ArrayList<>(8);
        for (Map.Entry<Integer, AbstractSendHandler> sendHandler : SendHandlerInitializer.loadSucceedSendHandlers.entrySet()) {
            Integer defaultCode = sendHandler.getKey();
            //判断用户开启哪些通知
            if ((handlerCode & defaultCode) == defaultCode) {
                sendHandlers.add(sendHandler.getValue());
            }
        }
        return sendHandlers;
    }

    public AbstractSendHandler getHandler(Integer handlerCode) {
        for (Map.Entry<Integer, AbstractSendHandler> sendHandler : SendHandlerInitializer.loadSucceedSendHandlers.entrySet()) {
            Integer defaultCode = sendHandler.getKey();
            //获取当前通知
            if ((handlerCode & defaultCode) == defaultCode) {
                return sendHandler.getValue();
            }
        }
        throw new NullPointerException(">>>>>> handler not found, handlerCode is " + handlerCode + ", please check SendHandler config");
    }
}
