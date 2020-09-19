package com.longfei.multi_datasource.listener;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.stereotype.Component;

/**
 * @author wei
 * @date 2020/9/17 2:29 下午
 */
@Component
public class HelloPublisher implements ApplicationEventPublisherAware {

    private ApplicationEventPublisher helloPublisher;

    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        helloPublisher = applicationEventPublisher;
    }

    public void say(){
        System.out.println("hello say");
        HelloEvent event = new HelloEvent("hello word!");
        helloPublisher.publishEvent(event);
    }
}
