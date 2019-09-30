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
 * @since 2019-09-30
 */
public class Log extends Model<Log> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "ID", type = IdType.AUTO)
    private Integer id;

    @TableField("IP_ADDRESS")
    private String ipAddress;

    @TableField("MAC")
    private String mac;

    @TableField("JS_ERROR")
    private String jsError;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getJsError() {
        return jsError;
    }

    public void setJsError(String jsError) {
        this.jsError = jsError;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "Log{" +
        ", id=" + id +
        ", ipAddress=" + ipAddress +
        ", mac=" + mac +
        ", jsError=" + jsError +
        "}";
    }
}
