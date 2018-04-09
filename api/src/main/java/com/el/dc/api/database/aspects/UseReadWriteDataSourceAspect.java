package com.el.dc.api.database.aspects;

import com.el.wc.payment.commons.database.DataSourceSelector;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * User: Rolandz
 * Date: 5/24/16
 * Time: 3:53 PM
 */
@Aspect
public class UseReadWriteDataSourceAspect {
    private static Logger LOG = LoggerFactory.getLogger(UseReadWriteDataSourceAspect.class);

    @Pointcut("@annotation(com.el.wc.payment.commons.annotations.UseReadWriteDataSource)")
    public void doPointCut() { }

    @Before("@annotation(com.el.wc.payment.commons.annotations.UseReadWriteDataSource)")
    public void doBefore(JoinPoint joinPoint) {
        LOG.debug("Using read write datasource for" + joinPoint);
        DataSourceSelector.setDataSource(DataSourceSelector.WRITE);
    }

    @After("@annotation(com.el.wc.payment.commons.annotations.UseReadWriteDataSource)")
    public void doAfter(JoinPoint joinPoint) {
        LOG.debug("Reverting datasource after" + joinPoint);
        DataSourceSelector.clearDataSource();
    }
}
