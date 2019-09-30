package com.shi.rocketmqconsumer.pullconsumer.annotion;

import java.lang.annotation.*;

/**
 * 普通消息监听
 *
 * @author lizhuo
 * @since 2019/1/4 下午10:11
 **/

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface RocketMqTag {

    String tag();

}
