package com.shi.rocketmqconsumer.annotation;

import java.lang.annotation.*;

/**
 * @Author yakun.shi
 * @Description 接口限流注解
 * @Date 2019/6/3 16:58
 **/
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
