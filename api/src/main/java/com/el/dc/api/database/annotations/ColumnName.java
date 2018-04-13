package com.el.dc.api.database.annotations;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;


@Target(FIELD)
@Retention(RUNTIME)
public @interface ColumnName {
    /**
     * 字段属性的中文名称
     */
    String value() default "";
}
