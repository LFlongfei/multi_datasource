package com.longfei.multi_datasource.multi;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * 多数据源切换切面
 * @author wei
 * @date 2020/9/5 10:25 下午
 */
@Aspect
@Order(1)
@Component
public class DataSourceAspect {

    @Pointcut("@annotation(DataSource)")
    public void dsPointCut(){}

    @Around("dsPointCut()")
    public Object around(ProceedingJoinPoint point) throws Throwable {
        MethodSignature signature = (MethodSignature)point.getSignature();
        Method method = signature.getMethod();
        DataSource annotation = method.getAnnotation(DataSource.class);
        if(annotation!=null){
            DynamicDataSourceContextHolder.setDataSourceType(annotation.value().name());
        }

        try{
            return point.proceed();
        }finally {
            //执行方法完毕后销毁数据源
            DynamicDataSourceContextHolder.clearDataSourceType();
        }
    }
}
