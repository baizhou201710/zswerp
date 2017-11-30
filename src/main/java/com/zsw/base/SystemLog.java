package com.zsw.base;

import java.lang.annotation.*;


/**
 * 自定义日志注解
 *
 * @author baizhou
 * @create 2017-11-16 14:16
 */

@Target({ElementType.PARAMETER, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface SystemLog {
    String module()  default "";
    String method()  default "";
}