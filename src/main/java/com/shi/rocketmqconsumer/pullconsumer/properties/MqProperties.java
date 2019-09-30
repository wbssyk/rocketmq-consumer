package com.shi.rocketmqconsumer.pullconsumer.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName MqProperties
 * @Author yakun.shi
 * @Date 2019/6/11 16:56
 * @Version 1.0
 **/
@Configuration
@ConfigurationProperties(prefix = "rocketmq.consumer")
public class MqProperties {
    private String isOnOff;
    private String groupName;
    private String nameServerAddress;
    private String topic;
    private int consumeThreadMin;
    private int consumeThreadMax;
    private int consumeMessageBatchMaxSize;

    public String getIsOnOff() {
        return isOnOff;
    }

    public void setIsOnOff(String isOnOff) {
        this.isOnOff = isOnOff;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public String getNameServerAddress() {
        return nameServerAddress;
    }

    public void setNameServerAddress(String nameServerAddress) {
        this.nameServerAddress = nameServerAddress;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public int getConsumeThreadMin() {
        return consumeThreadMin;
    }

    public void setConsumeThreadMin(int consumeThreadMin) {
        this.consumeThreadMin = consumeThreadMin;
    }

    public int getConsumeThreadMax() {
        return consumeThreadMax;
    }

    public void setConsumeThreadMax(int consumeThreadMax) {
        this.consumeThreadMax = consumeThreadMax;
    }

    public int getConsumeMessageBatchMaxSize() {
        return consumeMessageBatchMaxSize;
    }

    public void setConsumeMessageBatchMaxSize(int consumeMessageBatchMaxSize) {
        this.consumeMessageBatchMaxSize = consumeMessageBatchMaxSize;
    }
}
