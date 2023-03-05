package com.luntron;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import javax.annotation.PreDestroy;
import java.util.HashMap;
import java.util.Map;


/**
 * @author luntron
 * @description 启动类
 * @date 2022/1/2 2:34
 */

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class, MongoAutoConfiguration.class})
public class DesignPatternApplyApp implements BeanPostProcessor, ApplicationContextAware, DisposableBean {
    public static void main(String[] args) {
        SpringApplication.run(DesignPatternApplyApp.class, args);
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        //impl BeanPostProcessor
        return BeanPostProcessor.super.postProcessBeforeInitialization(bean, beanName);
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        //impl BeanPostProcessor
        return BeanPostProcessor.super.postProcessAfterInitialization(bean, beanName);
    }

    private ApplicationContext applicationContext;
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        //impl ApplicationContextAware
        this.applicationContext = applicationContext;
    }

    @PreDestroy
    public void destory() {
        System.out.println("程序准备销毁");
    }

    @Override
    public void destroy() throws Exception {
        //impl DisposableBean
        System.out.println("程序已销毁");
    }
}
