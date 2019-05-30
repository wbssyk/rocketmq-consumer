//package com.shi.rocketmqconsumer;
//
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.data.redis.core.RedisTemplate;
//import org.springframework.test.context.junit4.SpringRunner;
//
//@RunWith(SpringRunner.class)
//@SpringBootTest
//public class RocketmqConsumerApplicationTests {
//
//    private static final Logger logger = LoggerFactory.getLogger(RocketmqConsumerApplicationTests.class);
//    @Autowired
//    private RedisTemplate redisTemplate;
//    @Test
//    public void contextLoads() {
//        redisTemplate.opsForValue().set("a","测试集群");
//    }
//
//    @Test
//    public void get() {
//        Object a = redisTemplate.opsForValue().get("a");
//        System.out.println("-------------------------"+a.toString());
//        logger.info("{}:");
//        logger.info("--------------------------",a.toString());
//        logger.info("----------------------",a);
//    }
//}
