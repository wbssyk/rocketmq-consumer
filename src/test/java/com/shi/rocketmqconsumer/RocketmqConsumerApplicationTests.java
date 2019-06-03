//package com.shi.rocketmqconsumer;
//
//import com.shi.rocketmqconsumer.entity.Messagetag1;
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
//        Messagetag1 messagetag1 = new Messagetag1();
//        messagetag1.setMsgid("23232323");
//        redisTemplate.opsForZSet().add("2017-01-20",messagetag1,0.1f);
//    }
//
//    @Test
//    public void get() {
//
//        Object a = redisTemplate.opsForZSet().range("2017-01-20",-1,0);
//        System.out.println("-------------------------"+a.toString());
//        logger.info("{}:");
//        logger.info("--------------------------",a.toString());
//        logger.info("----------------------",a);
//    }
//}
