package com.longfei.multi_datasource.listener;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * @author wei
 * @date 2020/9/17 3:51 下午
 */
@Component
public class HelloListener implements ApplicationListener<HelloEvent> {
    @Override
    public void onApplicationEvent(HelloEvent event) {
        System.out.println("监听到的事件是：" + event.getSource());
    }
}
