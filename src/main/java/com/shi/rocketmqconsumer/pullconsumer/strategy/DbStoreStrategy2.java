package com.shi.rocketmqconsumer.pullconsumer.strategy;

import com.shi.rocketmqconsumer.pullconsumer.annotion.RocketMqTag;
import com.shi.rocketmqconsumer.pullconsumer.messagetemplate.MessageTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: dg-cloud
 * @description: 数据库存入策略
 * @author: yaKun.shi
 * @create: 2019-07-23 11:58
 **/
@Service
@RocketMqTag(tag = "client_log")
public class DbStoreStrategy2 implements Strategy{

    @Autowired
    private RedisTemplate redisTemplate;


    /**
     * @Method
     * @Author yakun.shi
     * @Description 存库逻辑
     * @Return
     * @Date 2019/7/31 17:09
     */
    @Override
    public void storeDb(List<MessageTemplate> value) {
        for (int i = 0; i <value.size() ; i++) {
            System.out.println(value.get(i).toString());
        }
        redisTemplate.opsForList().leftPushAll("client_log",value);
    }
}
