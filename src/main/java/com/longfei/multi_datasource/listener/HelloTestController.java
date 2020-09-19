package com.longfei.multi_datasource.listener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wei
 * @date 2020/9/17 3:53 下午
 */
@RestController
public class HelloTestController {
    @Autowired
    private HelloPublisher helloPublisher;

    @RequestMapping("/listener/test")
    public void test(){
        helloPublisher.say();
    }
}
