//package com.shi.rocketmqconsumer.consumer;
//
//import com.google.gson.Gson;
//import com.shi.rocketmqconsumer.entity.Messagetag1;
//import com.shi.rocketmqconsumer.entity.Messagetag2;
//import com.shi.rocketmqconsumer.service.IMessagetag1Service;
//import com.shi.rocketmqconsumer.service.IMessagetag2Service;
//import com.shi.rocketmqconsumer.utils.SpringUtil;
//import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
//import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
//import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
//import org.apache.rocketmq.common.message.MessageExt;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.stereotype.Component;
//import org.springframework.util.CollectionUtils;
//
//import javax.swing.*;
//import java.util.List;
//
///**
// * @ClassName MQConsumeMsgListenerProcessor
// * @Author yakun.shi
// * @Date 2019/5/24 9:59
// * @Version 1.0
// **/
//@Component
//public class MQConsumeMsgListenerProcessor implements MessageListenerConcurrently {
//
//    private static final Logger logger = LoggerFactory.getLogger(MQConsumeMsgListenerProcessor.class);
//
//    private static final Gson gson = new Gson();
//
//    @Override
//    public ConsumeConcurrentlyStatus consumeMessage(List<MessageExt> msgs, ConsumeConcurrentlyContext context) {
//        if (CollectionUtils.isEmpty(msgs)) {
//            logger.info("接收到的消息为空，不做任何处理");
//            return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
//        }
//        MessageExt messageExt = msgs.get(0);
//        String msg = new String(messageExt.getBody());
//        MessageTemplate messageTemplate = gson.fromJson(msg, MessageTemplate.class);
//        IMessagetag1Service messagetag1Service = SpringUtil.getBean(IMessagetag1Service.class);
//        IMessagetag2Service messagetag2Service = SpringUtil.getBean(IMessagetag2Service.class);
//        //logger.info("接收到的消息是："+messageExt.toString());
//        logger.info("接收到的消息是：" + msg);
//        if (messageExt.getTopic().equals("Topic-1")) {
//            if (messageExt.getTags().equals("Tag-1")) {
//                int reconsumeTimes = messageExt.getReconsumeTimes();
//                Messagetag1 messagetag1 = new Messagetag1();
//                messagetag1.setMessageinfo(messageTemplate.getMessageinfo());
//                messagetag1.setMsgid(messageExt.getMsgId());
//                messagetag1.setTag(messageExt.getTags());
//                messagetag1.setTopic(messageExt.getTopic());
//
//                if (reconsumeTimes == 3) {
//                    return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
//                }
//                //TODO 处理对应的业务逻辑
//                messagetag1Service.save(messagetag1);
//            }
//        }
//        if (messageExt.getTopic().equals("Topic-1")) {
//            if (messageExt.getTags().equals("Tag-2")) {
//                //重试次数
//                int reconsumeTimes = messageExt.getReconsumeTimes();
//                Messagetag2 messagetag2 = new Messagetag2();
//                messagetag2.setMessageinfo(messageTemplate.getMessageinfo());
//                messagetag2.setMsgid(messageExt.getMsgId());
//                messagetag2.setTag(messageExt.getTags());
//                messagetag2.setTopic(messageExt.getTopic());
//                //TODO 处理对应的业务逻辑
//                messagetag2Service.save(messagetag2);
//                if (reconsumeTimes == 3) {
//                    return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
//                }
//            }
//        }
//
//        return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
//    }
//}
