package com.shi.rocketmqconsumer.exception;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import lombok.extern.log4j.Log4j2;
import org.springframework.boot.json.JsonSimpleJsonParser;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @ClassName GlobalCatchException
 * @Author yakun.shi
 * @Date 2019/6/3 15:21
 * @Version 1.0
 **/
@RestControllerAdvice
@Log4j2
public class GlobalCatchException {

    @ExceptionHandler(AccessLimitException.class)
    public String accessLimit(AccessLimitException a){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("code","500");
        jsonObject.put("msg","网络阻塞");
        log.error("接口限流出现错误：{}",a);
        return jsonObject.toJSONString();
    }
}
