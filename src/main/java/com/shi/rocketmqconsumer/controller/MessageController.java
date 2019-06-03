package com.shi.rocketmqconsumer.controller;


import com.shi.rocketmqconsumer.annotation.CurrentLimit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author shiyakun
 * @since 2019-05-24
 */
@RestController
public class MessageController {

//    @Autowired
//    private RedisTemplate redisTemplate;

    @GetMapping("test")
    @CurrentLimit(time = 60,count = 200,key = "limit_count")
    public String aa(){
//        String redisKey = "test";
//        Long count = redisTemplate.opsForValue().increment(redisKey, 1);
//        if (count == 1) {
////设置有效期一分钟
//            redisTemplate.expire(redisKey, 60, TimeUnit.SECONDS);
//        }
//        if (count > 100) {
//            return "网络繁忙";
//        }
       return "调用成功";
    }
}
