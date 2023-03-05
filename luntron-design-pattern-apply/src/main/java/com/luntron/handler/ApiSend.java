package com.luntron.handler;

import com.luntron.entity.RequestData;
import com.luntron.entity.ResponseResult;

/**
 * @author luntron
 * @description
 * @date 2022/1/2 18:50
 */
public interface ApiSend {
    ResponseResult send(RequestData requestData);
}

