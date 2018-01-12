package com.example.demo.utils.annotation;

import java.lang.annotation.*;

/**
 * Created by Alex on 2018/1/12.
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface SysLog {
    String value() default "";
}
