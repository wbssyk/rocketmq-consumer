package com.shi.rocketmqconsumer.pullconsumer.pulltaskcallback;

import com.shi.rocketmqconsumer.pullconsumer.dbtask.DbTask;
import org.apache.rocketmq.client.consumer.DefaultMQPullConsumer;
import org.apache.rocketmq.client.consumer.PullResult;
import org.apache.rocketmq.client.consumer.PullTaskCallback;
import org.apache.rocketmq.client.consumer.PullTaskContext;
import org.apache.rocketmq.common.message.MessageQueue;

/**
 * @program: dg-cloud
 * @description: 自定义实现 PullTaskCallback
 * @author: yaKun.shi
 * @create: 2019-07-23 10:20
 **/
public class MqPullTaskCallback implements PullTaskCallback {

    private DefaultMQPullConsumer consumer;

    private DbTask dbTask;

    public MqPullTaskCallback(DefaultMQPullConsumer consumer,DbTask dbTask) {
        this.consumer = consumer;
        this.dbTask = dbTask;
    }

    /**
     * @Method
     * @Author yakun.shi
     * @Description 执行主动pull操作
     * @Return
     * @Date 2019/7/31 17:27
     */
    @Override
    public void doPullTask(MessageQueue mq, PullTaskContext context) {
        try {
            long offset = consumer.fetchConsumeOffset(mq, false);
            if (offset < 0) {
                offset = 0;
            }
            // 获取pullResult
            PullResult pullResult = consumer.pull(mq, "*",
                    offset, 32);
            // 注入pullResult
            dbTask.setPullResult(pullResult);
            // 执行业务逻辑
            dbTask.task();
            // 更新offset
            consumer.updateConsumeOffset(mq, pullResult.getNextBeginOffset());
            // 每次pull的间隔
            context.setPullNextDelayTimeMillis(8000);
        } catch (Exception e) {
            e.printStackTrace();
            // 失败停止 pull
            context.setPullNextDelayTimeMillis(400000000);
        }
    }
}
