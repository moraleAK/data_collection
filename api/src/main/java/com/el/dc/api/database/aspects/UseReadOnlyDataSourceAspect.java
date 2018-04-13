package com.el.dc.api.database.aspects;

import com.el.dc.api.database.DataSourceSelector;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Aspect
public class UseReadOnlyDataSourceAspect {
    private static Logger LOG = LoggerFactory.getLogger(UseReadOnlyDataSourceAspect.class);

    @Pointcut("@annotation(com.el.dc.api.database.annotations.UseReadOnlyDataSource)")
    public void doPointCut() { }

    @Before("@annotation(com.el.dc.api.database.annotations.UseReadOnlyDataSource)")
    public void doBefore(JoinPoint joinPoint) {
        LOG.debug("Using read only datasource for {}", joinPoint);
        DataSourceSelector.setDataSource(DataSourceSelector.READ);
    }

    @After("@annotation(com.el.dc.api.database.annotations.UseReadOnlyDataSource)")
    public void doAfter(JoinPoint joinPoint) {
        LOG.debug("Reverting datasource after {}", joinPoint);
        DataSourceSelector.clearDataSource();
    }
}
