package com.luntron.app.initializer;

import org.springframework.boot.BootstrapRegistry;
import org.springframework.boot.BootstrapRegistryInitializer;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.Ordered;

/**
 * @author luntron
 * @description
 * @date 2022-12-22 20:57
 */
public class DemoBootStrapRegistryInitializer implements BootstrapRegistryInitializer, Ordered {

    @Override
    public int getOrder() {
        return 0;
    }

    @Override
    public void initialize(BootstrapRegistry registry) {
        System.out.println(">>>>>>>>>>>>>>自定义DemoBootStrapRegistryInitializer");
    }
}
