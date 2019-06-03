package com.shi.rocketmqconsumer.aop;

import com.shi.rocketmqconsumer.annotation.CurrentLimit;
import com.shi.rocketmqconsumer.exception.AccessLimitException;
import com.shi.rocketmqconsumer.utils.SpringUtil;
import jdk.nashorn.internal.runtime.logging.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

/**
 * @Author yakun.shi
 * @Description //接口限流AOP实现
 * @Date 2019/6/3 16:58
 **/
@Aspect
@Logger
@Component
public class LimitCount {


    @Autowired
    private RedisTemplate redisTemplate;

    /**
     * 定义有一个切入点，范围为web包下的类
     */
    @Pointcut("@annotation(com.shi.rocketmqconsumer.annotation.CurrentLimit)")
    public void limitCount() {
    }

    @Before("limitCount()")
    public void doBefore(JoinPoint joinPoint) {
    }

    /**
     * 检查参数是否为空
     */
    @Around("limitCount()")
    public Object doAround(ProceedingJoinPoint pjp) throws Throwable {
        MethodSignature signature = ((MethodSignature) pjp.getSignature());
        //得到拦截的方法
        Method method = signature.getMethod();

        CurrentLimit annotation = method.getAnnotation(CurrentLimit.class);
        int count = annotation.count();
        long time = annotation.time();
        String key = annotation.key();
        // 使用redis自增原子性来限制接口请求次数
        Long increment = redisTemplate.opsForValue().increment(key, 1);
        if (increment == 1) {
            //设置有效期一分钟
            redisTemplate.expire(key, time, TimeUnit.SECONDS);
        }
        if (increment > 10) {
           throw new AccessLimitException();
        }
        return pjp.proceed();
    }

    /**
     * 在切入点return内容之后切入内容（可以用来对处理返回值做一些加工处理）
     *
     * @param joinPoint
     */
    @AfterReturning("limitCount()")
    public void doAfterReturning(JoinPoint joinPoint) {
    }

}
