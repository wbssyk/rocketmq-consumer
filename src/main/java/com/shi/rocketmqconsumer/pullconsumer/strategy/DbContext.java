package com.shi.rocketmqconsumer.pullconsumer.strategy;


import com.shi.rocketmqconsumer.pullconsumer.messagetemplate.MessageTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * @program: dg-cloud
 * @description: 处理不同tag逻辑
 * @author: yaKun.shi
 * @create: 2019-07-23 11:53
 **/
public class DbContext {

    private static Logger logger = LoggerFactory.getLogger(DbContext.class);

    /**
     * @Method
     * @Author yakun.shi
     * @Description 执行策略，根据不同的tag执行不同的方法
     * @Return
     * @Date 2019/7/31 17:10
     */
    public void executeStrategy(Map<String, Strategy> beans,Map<String, List<MessageTemplate>> map) throws Exception{
        if(beans==null){
            logger.info("注解tag重复");
            return;
        }
        Iterator<Map.Entry<String, List<MessageTemplate>>> iterator =
                map.entrySet().iterator();
        while (iterator.hasNext()){
            Map.Entry<String, List<MessageTemplate>> next = iterator.next();
            String key = next.getKey();
            //根据 tag  获取对应的 Strategy
            Strategy strategy = beans.get(key);
            if(strategy!=null){
                // 根据 tag 获取消息
                List<MessageTemplate> messageTemplates = map.get(key);
                // 执行不同的存库逻辑
                strategy.storeDb(messageTemplates);
            }else {
                throw new Exception();
            }
        }
    }
}
