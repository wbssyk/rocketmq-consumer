package com.shi.rocketmqconsumer.consumer;

import com.google.gson.Gson;
import com.shi.rocketmqconsumer.entity.Messagetag1;
import com.shi.rocketmqconsumer.entity.Messagetag2;
import com.shi.rocketmqconsumer.service.IMessagetag1Service;
import com.shi.rocketmqconsumer.service.IMessagetag2Service;
import com.shi.rocketmqconsumer.utils.DateUtils;
import com.shi.rocketmqconsumer.utils.SpringUtil;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import org.apache.rocketmq.common.message.MessageExt;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

/**
 * @ClassName MQRedisConsumeMsgListenerProcessor
 * @Author yakun.shi
 * @Date 2019/5/28 13:21
 * @Version 1.0
 **/
@Component
public class MQRedisConsumeMsgListenerProcessor implements MessageListenerConcurrently {

    private final static Logger logger = LoggerFactory.getLogger(MQRedisConsumeMsgListenerProcessor.class);
    private static final Gson gson = new Gson();

    @Autowired
    private RedisTemplate redisTemplate;

    @Override
    public ConsumeConcurrentlyStatus consumeMessage(List<MessageExt> msgs, ConsumeConcurrentlyContext context) {
        if (CollectionUtils.isEmpty(msgs)) {
            logger.info("接收到的消息为空，不做任何处理");
            return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
        }
        MessageExt messageExt = msgs.get(0);
        String msg = new String(messageExt.getBody());
        MessageTemplate messageTemplate = gson.fromJson(msg, MessageTemplate.class);

        logger.info("接收到的消息是：" + msg);
        if (messageExt.getTopic().equals("Topic-1")) {
            if (messageExt.getTags().equals("Tag-1")) {
                Messagetag1 messagetag1 = new Messagetag1();
                messagetag1.setMessageinfo(messageTemplate.getMessageinfo());
                messagetag1.setMsgid(messageExt.getMsgId());
                messagetag1.setTag(messageExt.getTags());
                messagetag1.setTopic(messageExt.getTopic());
//                redisTemplate.opsForValue().set(messageExt.getMsgId(),messagetag1);

                if (messageExt.getReconsumeTimes() == 3) {
                    return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
                }
                try {
                    redisTemplate.opsForList().leftPush(DateUtils.dateToString(LocalDateTime.now()),messagetag1);
                } catch (Throwable e) {
                    e.printStackTrace();
                }
            }
        }
        return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
    }
}
