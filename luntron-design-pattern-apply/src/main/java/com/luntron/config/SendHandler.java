package com.luntron.config;

/**
 * @description 发送类型.
 * 这里使用二进制的目的是减少数据库短信开关数据表，只需要维护一个userHandlerCode字段即可，减少查库，同时基于计算机底层二进制计算处理速度更快了
 * 开关默认值serHandlerCode=ob1000。添加邮件开关 serHandlerCode | 0b001 【或运算】 删除邮件开关serHandlerCode ^ ob001【亦或运算】
 * 判断开关是否成立 userHandlerCode & code = code  code为某个开关的二进制值或者2的n次方
 * @author luntron
 * @var userHandlerCode 用户的消息推送开关值,初始值为0
 * @var code            当前枚举的code值,code值为2的n次方倍
 * @var 0b              表示数的格式为二进制格式
 * @var 0b001           表示2的0次方 = 1
 * @date 2022/1/2 2:58
 */

public enum SendHandler {
    //0b001 = 2>>1  ，右移计算(除以二)
    mail(2 >> 1, "mailHandler", "邮件-ob001"),
    //0b010 = 2
    sms(2, "smsHandler", "短信-ob010"),
    /**
     * 2 << 1，左移计算(乘以2，2*2)  假如是2 << 4 ，2*2*2*2*2
     */
    app(2 << 1, "appHandler", "ob100"),

    other(2 << 10, "otherHandler", "other"),
    ;
    private Integer code;
    private String beanName;
    private String name;

    public Integer getCode() {
        return code;
    }

    public String getBeanName() {
        return beanName;
    }

    public String getName() {
        return name;
    }

    SendHandler(Integer code, String beanName, String name) {
        this.code = code;
        this.beanName = beanName;
        this.name = name;
    }
}
