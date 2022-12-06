package com.jay.dynamicdatasource.config;

import com.jay.dynamicdatasource.annotation.DataSourceSelect;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @author Jay Yang
 * @date 2022/12/6
 */
@Aspect
@Component
@Order(-1)
public class DynamicDataSourceAspect {

    @Pointcut("@annotation(com.jay.dynamicdatasource.annotation.DataSourceSelect)")
    public void dataSourceSelectPointCut() {
    }

    @Before("dataSourceSelectPointCut()")
    public void doBefore(JoinPoint joinPoint) {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        DataSourceSelect dataSourceSelect = signature.getMethod()
                .getAnnotation(DataSourceSelect.class);
        String profile = dataSourceSelect.value();
        DynamicDataSourceHolder.setCurrentDataSource(profile);
    }

    @AfterReturning("dataSourceSelectPointCut()")
    public void doAfterReturning() {
        DynamicDataSourceHolder.remove();
    }

    @AfterThrowing("dataSourceSelectPointCut()")
    public void doAfterThrowing() {
        DynamicDataSourceHolder.remove();
    }

}
