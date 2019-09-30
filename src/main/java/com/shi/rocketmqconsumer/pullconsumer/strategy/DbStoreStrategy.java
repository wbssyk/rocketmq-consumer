package com.shi.rocketmqconsumer.pullconsumer.strategy;

import com.shi.rocketmqconsumer.dao.LogMapper;
import com.shi.rocketmqconsumer.pullconsumer.annotion.RocketMqTag;
import com.shi.rocketmqconsumer.pullconsumer.messagetemplate.MessageTemplate;
import com.sun.xml.internal.bind.v2.TODO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: dg-cloud
 * @description: 数据库存入策略
 * @author: yaKun.shi
 * @create: 2019-07-23 11:58
 **/
@Service
@RocketMqTag(tag = "error_log")
public class DbStoreStrategy implements Strategy{

    @Autowired
    private LogMapper logMapper;

    @Override
    public void storeDb(List<MessageTemplate> value) throws Exception {

    }
}
