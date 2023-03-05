package com.luntron.config;

/**
 * @description 通知厂商枚举
 * @author luntron
 * @var providerCode x00y代表   x： 代表类型  y： 代表序号
 * @date 2022/1/2 2:58
 */

public enum NotificationFactory {

    /**
     * 短信通知
     */

    SmsWeiWang(1001, "smsWeiWangApiSend", "短信-微网"),

    SmsYunChu(1002, "smsYunChuApiSend", "短信-云出"),
    /**
     * 邮件通知
     */
    MailAli(2001, "mailAliApiSend", "邮件-阿里"),
    MailTencent(2002, "mailTencentApiSend", "邮件-腾讯"),

    ;
    private Integer providerCode;
    private String beanName;
    private String name;

    public Integer getProviderCode() {
        return providerCode;
    }

    public String getBeanName() {
        return beanName;
    }

    public String getName() {
        return name;
    }

    NotificationFactory(Integer providerCode, String beanName, String name) {
        this.providerCode = providerCode;
        this.beanName = beanName;
        this.name = name;
    }
}
