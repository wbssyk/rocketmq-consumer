package com.shi.rocketmqconsumer.pullconsumer.strategy;


import com.shi.rocketmqconsumer.pullconsumer.messagetemplate.MessageTemplate;

import java.util.List;

/**
 * @program: dg-cloud
 * @description: 策略接口
 * @author: yaKun.shi
 * @create: 2019-07-23 11:59
 **/
public interface Strategy {

    /**
     * @Method
     * @Author yakun.shi
     * @Description 执行存库业务逻辑
     * @Return
     * @Date 2019/7/31 17:30
     */
    void storeDb(List<MessageTemplate> value) throws Exception;
}
