package com.shi.rocketmqconsumer.pullconsumer.dbtask;

import com.google.gson.Gson;
import com.shi.rocketmqconsumer.pullconsumer.annotion.RocketMqTag;
import com.shi.rocketmqconsumer.pullconsumer.messagetemplate.MessageTemplate;
import com.shi.rocketmqconsumer.pullconsumer.strategy.DbContext;
import com.shi.rocketmqconsumer.pullconsumer.strategy.Strategy;
import org.apache.rocketmq.client.consumer.PullResult;
import org.apache.rocketmq.common.message.MessageExt;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @program: dg-cloud
 * @description: 消息处理逻辑
 * @author: yaKun.shi
 * @create: 2019-07-23 10:55
 **/
public class DbTask {

    private static Logger logger = LoggerFactory.getLogger(DbTask.class);

    private PullResult pullResult;

    /**
     * @Author yakun.shi
     * @Description 获取 加了RocketMqTag注解的所有类
     * @Date 2019/7/31 17:24
     */
    private Map<String, Object> beansWithAnnotation;

    private static Gson gson = new Gson();


    /**
     * @Method
     * @Author yakun.shi
     * @Description 构造方法
     * @Return
     * @Date 2019/7/31 17:25
     */
    public DbTask(Map<String, Object> beans) {
        this.beansWithAnnotation = beans;
    }
    /**
     * @Method 
     * @Author yakun.shi
     * @Description 执行任务
     * @Return 
     * @Date 2019/7/31 17:15
     */
    public void task() throws Exception {
        switch (pullResult.getPullStatus()) {
            case FOUND:
                List<MessageExt> messageExtList = pullResult.getMsgFoundList();
                Map<String, List<MessageTemplate>> map = resolveMessageExt(messageExtList);
                this.store(map);
                break;
            case NO_MATCHED_MSG:
                break;
            case NO_NEW_MSG:
                break;
            case OFFSET_ILLEGAL:
                break;
            default:
                break;
        }
    }

    /**
     * @Method 
     * @Author yakun.shi
     * @Description 根据不同的 tag 来对消息进行分类
     * @Return 
     * @Date 2019/7/31 17:16
     */
    private Map<String, List<MessageTemplate>> resolveMessageExt(List<MessageExt> messageExtList) throws Exception {
        if (messageExtList != null && messageExtList.size() > 0) {
            LinkedList<MessageTemplate> messageTemplates = new LinkedList<>();
            for (MessageExt m : messageExtList) {
                String s = new String(m.getBody());
                MessageTemplate messageTemplate = gson.fromJson(s, MessageTemplate.class);
                messageTemplates.add(messageTemplate);
            }
            Map<String, List<MessageTemplate>> collect = messageTemplates.stream().
                    collect(Collectors.groupingBy(MessageTemplate::getTag));

            return collect;
        }
        return null;
    }


    /**
     * @Method
     * @Author yakun.shi
     * @Description 进行存储操作
     * @Return 
     * @Date 2019/7/31 17:16
     */
    public void store(Map<String, List<MessageTemplate>> map) throws Exception {
        if (map == null) {
            logger.info("rocketMq没有新的数据");
            return;
        }
        DbContext dbContext = new DbContext();
        // 执行策略
        dbContext.executeStrategy(resolveBean(), map);

    }


    /**
     * @Method
     * @Author yakun.shi
     * @Description 通过RocketMqTag注解来解析，注解的类名，
     *             以便根据不同的策略来执行不同的tag 存储逻辑
     * @Return
     * @Date 2019/7/31 17:19
     */
    public LinkedHashMap<String, Strategy> resolveBean() throws Exception {
        if (beansWithAnnotation == null) {
            return null;
        }
        HashSet<String> strings = new HashSet<>();
        LinkedHashMap<String, Strategy> linkedHashMap = new LinkedHashMap<>();
        Iterator<Map.Entry<String, Object>> iterator = beansWithAnnotation.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, Object> next = iterator.next();
            Object value = next.getValue();
            //获取注解值
            String tag = value.getClass().getAnnotation(RocketMqTag.class).tag();
            strings.add(tag);
            Strategy strategy = (Strategy) value;
            //把 tag 值和对应的类 一一对应
            linkedHashMap.put(tag, strategy);
        }
        if (strings.size() != linkedHashMap.size()) {
            return null;
        }
        return linkedHashMap;
    }

    /**
     * @Method
     * @Author yakun.shi
     * @Description 外部注入 主动拉取的消息 pullResult
     * @Return
     * @Date 2019/7/31 17:21
     */
    public void setPullResult(PullResult pullResult) {
        this.pullResult = pullResult;
    }



}
