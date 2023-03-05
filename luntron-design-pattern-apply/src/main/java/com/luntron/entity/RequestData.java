package com.luntron.entity;

import lombok.Data;

/**
 * @author luntron
 * @description
 * @date 2022/1/2 4:54
 */
@Data
public class RequestData {
    /**
     * 消息code,判断发送邮件、短信、站内信
     */
    private Integer code;
    /**
     * 子code,比如上方是短信，短信厂商很多，那具体通过哪个厂商发就由此字段判断
     */
    private Integer providerCode;

    public RequestData setProviderCode(Integer providerCode) {
        this.providerCode = providerCode;
        return this;
    }

    public RequestData setCode(Integer code) {
        this.code = code;
        return this;
    }
}
