package com.shi.rocketmqconsumer.annotation;


import java.lang.annotation.*;

@Target(ElementType.METHOD)  //注解用于方法中的参数
@Retention(RetentionPolicy.RUNTIME)
public @interface CurrentLimit {
    // 时间 单位为秒
    long time() default 0L;
    // 限制次数
    int count() default 0;
    // key
    String key();
}
