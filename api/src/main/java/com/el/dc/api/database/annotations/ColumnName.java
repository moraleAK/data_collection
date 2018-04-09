package com.el.dc.api.database.annotations;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Created by daodao on 2018/3/14.
 */
@Target(FIELD)
@Retention(RUNTIME)
public @interface ColumnName {
    /**
     * 字段属性的中文名称
     */
    String value() default "";
}
