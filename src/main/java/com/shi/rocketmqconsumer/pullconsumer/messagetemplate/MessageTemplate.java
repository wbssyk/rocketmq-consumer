package com.shi.rocketmqconsumer.pullconsumer.messagetemplate;

import java.io.Serializable;

/**
 * @Method
 * @Author yakun.shi
 * @Description
 * @Return
 * @Date 2019/9/16 9:23
 */
public class MessageTemplate implements Serializable {

    private String id;
    private String sendTime;
    private String messageInfo;
    private String topic;
    private String tag;
    private String ipAddress;
    private String mac;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMessageInfo() {
        return messageInfo;
    }

    public void setMessageInfo(String messageInfo) {
        this.messageInfo = messageInfo;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getSendTime() {
        return sendTime;
    }

    public void setSendTime(String sendTime) {
        this.sendTime = sendTime;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public String getMac() {
        return mac;
    }

    public void setMac(String mac) {
        this.mac = mac;
    }

    @Override
    public String toString() {
        return "MessageTemplate{" +
                "sendTime='" + sendTime + '\'' +
                ", messageInfo='" + messageInfo + '\'' +
                ", topic='" + topic + '\'' +
                ", tag='" + tag + '\'' +
                ", ipAddress='" + ipAddress + '\'' +
                ", mac='" + mac + '\'' +
                '}';
    }
}
