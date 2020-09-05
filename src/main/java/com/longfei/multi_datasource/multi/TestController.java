package com.longfei.multi_datasource.multi;

import com.longfei.multi_datasource.entity.Test;
import com.longfei.multi_datasource.mapper.TestDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wei
 * @date 2020/9/5 10:40 下午
 */
@RestController
public class TestController {
    @Autowired
    private TestDAO testDAO;

    @RequestMapping("local")
    @DataSource(DataSourceType.LOCAL)
    public Test local(){
        Test test = testDAO.selectByPrimaryKey(1);
        System.out.println(test);
        return test;
    }

    @RequestMapping("remote")
    @DataSource(DataSourceType.REMOTE)
    public Test remote(){
        Test test = testDAO.selectByPrimaryKey(1);
        System.out.println(test);
        return test;
    }
}
