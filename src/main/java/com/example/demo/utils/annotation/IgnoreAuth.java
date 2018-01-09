package com.example.demo.utils.annotation;

import java.lang.annotation.*;

/**
 * Created by panbingcan on 2018/1/9.
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface IgnoreAuth {
}
