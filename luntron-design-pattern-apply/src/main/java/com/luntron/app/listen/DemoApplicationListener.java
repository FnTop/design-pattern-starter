package com.luntron.app.listen;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;

/**
 * @author luntron
 * @description
 * @date 2022-12-22 20:59
 */
public class DemoApplicationListener implements ApplicationListener {
    @Override
    public void onApplicationEvent(ApplicationEvent event) {
        System.out.println(">>>>>>>>>>>>监听"+event.getSource());
    }
}
