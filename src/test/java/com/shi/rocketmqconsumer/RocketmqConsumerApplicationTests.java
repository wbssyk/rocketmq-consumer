package com.shi.rocketmqconsumer;

import com.shi.rocketmqconsumer.entity.Messagetag1;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.Resource;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RocketmqConsumerApplicationTests {

    private static final Logger logger = LoggerFactory.getLogger(RocketmqConsumerApplicationTests.class);

    @Test
    public void contextLoads() {
    }


}
