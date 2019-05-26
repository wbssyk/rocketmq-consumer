package com.shi.rocketmqconsumer.consumer;

import java.io.Serializable;
import java.util.Date;

public class MessageTemplate implements Serializable {

    private String id;
    private Date messageSendTime;
    private String messageinfo;
    private String sendMessageType;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getMessageSendTime() {
        return messageSendTime;
    }

    public void setMessageSendTime(Date messageSendTime) {
        this.messageSendTime = messageSendTime;
    }

    public String getMessageinfo() {
        return messageinfo;
    }

    public void setMessageinfo(String messageinfo) {
        this.messageinfo = messageinfo;
    }

    public String getSendMessageType() {
        return sendMessageType;
    }

    public void setSendMessageType(String sendMessageType) {
        this.sendMessageType = sendMessageType;
    }
}
