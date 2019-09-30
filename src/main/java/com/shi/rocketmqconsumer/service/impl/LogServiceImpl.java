package com.shi.rocketmqconsumer.service.impl;

import com.shi.rocketmqconsumer.entity.Log;
import com.shi.rocketmqconsumer.dao.LogMapper;
import com.shi.rocketmqconsumer.service.ILogService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author shiyakun
 * @since 2019-09-30
 */
@Service
public class LogServiceImpl extends ServiceImpl<LogMapper, Log> implements ILogService {

}
