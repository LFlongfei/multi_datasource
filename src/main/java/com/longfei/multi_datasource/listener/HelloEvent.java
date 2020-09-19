package com.longfei.multi_datasource.listener;

import org.springframework.context.ApplicationEvent;

/**
 * @author wei
 * @date 2020/9/17 2:22 下午
 */
public class HelloEvent extends ApplicationEvent {
    public HelloEvent(Object source) {
        super(source);
    }
}
