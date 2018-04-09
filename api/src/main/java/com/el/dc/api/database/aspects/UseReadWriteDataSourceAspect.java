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
public class UseReadWriteDataSourceAspect {
    private static Logger LOG = LoggerFactory.getLogger(UseReadWriteDataSourceAspect.class);

    @Pointcut("@annotation(com.el.dc.api.database.annotations.UseReadWriteDataSource)")
    public void doPointCut() { }

    @Before("@annotation(com.el.dc.api.database.annotations.UseReadWriteDataSource)")
    public void doBefore(JoinPoint joinPoint) {
        LOG.debug("Using read write datasource for" + joinPoint);
        DataSourceSelector.setDataSource(DataSourceSelector.WRITE);
    }

    @After("@annotation(com.el.dc.api.database.annotations.UseReadWriteDataSource)")
    public void doAfter(JoinPoint joinPoint) {
        LOG.debug("Reverting datasource after" + joinPoint);
        DataSourceSelector.clearDataSource();
    }
}
