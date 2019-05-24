package com.shi.rocketmqconsumer.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author shiyakun
 * @since 2019-05-24
 */
public class Message extends Model<Message> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private byte id;

    private byte topic;

    private byte tag;

    private byte message;

    @TableField("createTime")
    private byte createTime;

    @TableField("updateTime")
    private byte updateTime;

    private byte msgid;

    private byte status;


    public byte getId() {
        return id;
    }

    public void setId(byte id) {
        this.id = id;
    }

    public byte getTopic() {
        return topic;
    }

    public void setTopic(byte topic) {
        this.topic = topic;
    }

    public byte getTag() {
        return tag;
    }

    public void setTag(byte tag) {
        this.tag = tag;
    }

    public byte getMessage() {
        return message;
    }

    public void setMessage(byte message) {
        this.message = message;
    }

    public byte getCreateTime() {
        return createTime;
    }

    public void setCreateTime(byte createTime) {
        this.createTime = createTime;
    }

    public byte getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(byte updateTime) {
        this.updateTime = updateTime;
    }

    public byte getMsgid() {
        return msgid;
    }

    public void setMsgid(byte msgid) {
        this.msgid = msgid;
    }

    public byte getStatus() {
        return status;
    }

    public void setStatus(byte status) {
        this.status = status;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "Message{" +
        ", id=" + id +
        ", topic=" + topic +
        ", tag=" + tag +
        ", message=" + message +
        ", createTime=" + createTime +
        ", updateTime=" + updateTime +
        ", msgid=" + msgid +
        ", status=" + status +
        "}";
    }
}
