package com.shi.rocketmqconsumer.controller;

import org.apache.rocketmq.client.consumer.DefaultMQPullConsumer;
import org.apache.rocketmq.client.exception.MQBrokerException;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.impl.consumer.PullResultExt;
import org.apache.rocketmq.common.message.MessageExt;
import org.apache.rocketmq.common.message.MessageQueue;
import org.apache.rocketmq.remoting.exception.RemotingException;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @ClassName TestPull
 * @Author yakun.shi
 * @Date 2019/6/20 9:08
 * @Version 1.0
 **/
public class TestPull {

    private static final Map<MessageQueue, Long> offsetTable = new HashMap<MessageQueue, Long>();
    public static void main(String[] args) throws MQClientException, RemotingException, InterruptedException, MQBrokerException {
        DefaultMQPullConsumer consumer = new DefaultMQPullConsumer("77777");
        consumer.setNamesrvAddr("192.168.1.200:9876;192.168.1.201:9876;192.168.1.202:9876");

        consumer.start();
        try {
            Set<MessageQueue> mqs = consumer.fetchSubscribeMessageQueues("777");
            for(MessageQueue mq:mqs) {
                System.out.println("Consume from the queue: " + mq);
                //	long offset = consumer.fetchConsumeOffset(mq, true);
                //	PullResultExt pullResult =(PullResultExt)consumer.pull(mq, null, getMessageQueueOffset(mq), 32);
                //消息未到达默认是阻塞10秒，private long consumerPullTimeoutMillis = 1000 * 10;
                PullResultExt pullResult =(PullResultExt)consumer.pullBlockIfNotFound(mq, null, getMessageQueueOffset(mq), 100);
                System.out.println(pullResult);
                putMessageQueueOffset(mq, pullResult.getNextBeginOffset());
                switch (pullResult.getPullStatus()) {
                    case FOUND:
                        List<MessageExt> messageExtList = pullResult.getMsgFoundList();
                        int size = messageExtList.size();
                        System.out.println(size);
                        for (MessageExt m : messageExtList) {
                            System.out.println(new String(m.getBody()));
                        }
                        break;
                    case NO_MATCHED_MSG:
                        break;
                    case NO_NEW_MSG:
                        break ;
                    case OFFSET_ILLEGAL:
                        break;
                    default:
                        break;
                }
            }
        } catch (MQClientException e) {
            e.printStackTrace();
        }
    }
    private static void putMessageQueueOffset(MessageQueue mq, long offset) {
        offsetTable.put(mq, offset);
    }

    private static long getMessageQueueOffset(MessageQueue mq) {
        Long offset = offsetTable.get(mq);
        if (offset != null)
            return offset;
        return 0;
    }
}
