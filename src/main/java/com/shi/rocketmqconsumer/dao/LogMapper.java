package com.shi.rocketmqconsumer.dao;

import com.shi.rocketmqconsumer.entity.Log;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.shi.rocketmqconsumer.pullconsumer.messagetemplate.MessageTemplate;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author shiyakun
 * @since 2019-09-30
 */
public interface LogMapper extends BaseMapper<Log> {
    void insertBatchLog(@Param("request") List<MessageTemplate> value);
}
