package com.shi.rocketmqconsumer.impl;

import com.shi.rocketmqconsumer.entity.Message;
import com.shi.rocketmqconsumer.dao.MessageMapper;
import com.shi.rocketmqconsumer.service.IMessageService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author shiyakun
 * @since 2019-05-24
 */
@Service
public class MessageServiceImpl extends ServiceImpl<MessageMapper, Message> implements IMessageService {

}
