package com.shi.rocketmqconsumer.impl;

import com.shi.rocketmqconsumer.entity.User;
import com.shi.rocketmqconsumer.dao.UserMapper;
import com.shi.rocketmqconsumer.service.IUserService;
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
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

}
