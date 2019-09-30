package com.shi.rocketmqconsumer.pullconsumer.configuration;

import com.shi.rocketmqconsumer.pullconsumer.annotion.RocketMqTag;
import com.shi.rocketmqconsumer.pullconsumer.dbtask.DbTask;
import com.shi.rocketmqconsumer.pullconsumer.properties.MqProperties;
import com.shi.rocketmqconsumer.pullconsumer.pulltaskcallback.MqPullTaskCallback;
import com.shi.rocketmqconsumer.utils.SpringUtil;
import org.apache.rocketmq.client.consumer.DefaultMQPullConsumer;
import org.apache.rocketmq.client.consumer.MQPullConsumerScheduleService;
import org.apache.rocketmq.common.protocol.heartbeat.MessageModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

/**
 * @ClassName MqPullConsumer
 * @Author yakun.shi
 * @Date 2019/5/24 9:58
 * @Version 1.0
 **/

@Configuration
public class MqPullConsumer {
    public static final Logger logger = LoggerFactory.getLogger(MqPullConsumer.class);

    @Autowired
    private MqProperties mqProperties;

    /**
     * @Method
     * @Author yakun.shi
     * @Description 初始化 rocketMq 客户端
     * @Return
     * @Date 2019/7/31 17:31
     */
    @Bean
    public MQPullConsumerScheduleService getRocketMQConsumer() {

        MQPullConsumerScheduleService scheduleService =
                new MQPullConsumerScheduleService(mqProperties.getGroupName());
        scheduleService.setMessageModel(MessageModel.CLUSTERING);
        DefaultMQPullConsumer consumer =
                new DefaultMQPullConsumer(mqProperties.getGroupName());
        // 初始化 mq服务地址ip
        consumer.setNamesrvAddr(mqProperties.getNameServerAddress());
        scheduleService.setDefaultMQPullConsumer(consumer);
        // 获取 所有被RocketMqTag注解的类
        Map<String, Object> beansWithAnnotation = SpringUtil.getBeansWithAnnotation(RocketMqTag.class);
        // 初始化 DbTask, 注入beansWithAnnotation
        DbTask dbTask = new DbTask(beansWithAnnotation);
        // 初始化 pull 任务 并注入DbTask，DefaultMQPullConsumer
        scheduleService.registerPullTaskCallback(mqProperties.getTopic(),
                new MqPullTaskCallback(consumer, dbTask));

        try {
            // RocketMq client启动
            scheduleService.start();
            logger.info("pullCustomer is start !!! groupName:{},topics:{},nameSerAddress:{}",
                    mqProperties.getGroupName(),
                    mqProperties.getTopic(),
                    mqProperties.getNameServerAddress());
        } catch (Exception e) {
            logger.error("PullCustomer is start !!! groupName:{},topics:{},nameSerAddress:{}",
                    mqProperties.getGroupName(),
                    mqProperties.getTopic(),
                    mqProperties.getNameServerAddress(), e);
            e.printStackTrace();
        }
        return scheduleService;
    }
}
