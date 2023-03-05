package com.luntron.app.initializer;

import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.Ordered;

/**
 * @author luntron
 * @description
 * @date 2022-12-22 20:57
 */
public class DemoApplicationContextInitializer implements ApplicationContextInitializer, Ordered {
    @Override
    public void initialize(ConfigurableApplicationContext applicationContext) {
        System.out.println(">>>>>>>>>>>自定义DemoApplicationContextInitializer");
    }

    @Override
    public int getOrder() {
        return 0;
    }
}
