package com.shi.rocketmqconsumer.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author shiyakun
 * @since 2019-05-26
 */
public class Messagetag2 extends Model<Messagetag2> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private String msgid;

    private String messageinfo;

    private String topic;

    private String tag;

    private Integer status;

    @TableField("bornTimestamp")
    private LocalDateTime bornTimestamp;

    @TableField("storeTimestamp")
    private LocalDateTime storeTimestamp;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMsgid() {
        return msgid;
    }

    public void setMsgid(String msgid) {
        this.msgid = msgid;
    }

    public String getMessageinfo() {
        return messageinfo;
    }

    public void setMessageinfo(String messageinfo) {
        this.messageinfo = messageinfo;
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

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public LocalDateTime getBornTimestamp() {
        return bornTimestamp;
    }

    public void setBornTimestamp(LocalDateTime bornTimestamp) {
        this.bornTimestamp = bornTimestamp;
    }

    public LocalDateTime getStoreTimestamp() {
        return storeTimestamp;
    }

    public void setStoreTimestamp(LocalDateTime storeTimestamp) {
        this.storeTimestamp = storeTimestamp;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "Messagetag2{" +
        ", id=" + id +
        ", msgid=" + msgid +
        ", messageinfo=" + messageinfo +
        ", topic=" + topic +
        ", tag=" + tag +
        ", status=" + status +
        ", bornTimestamp=" + bornTimestamp +
        ", storeTimestamp=" + storeTimestamp +
        "}";
    }
}
