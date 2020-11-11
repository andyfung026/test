package com.greencity.service.impl;

import com.greencity.service.HttpDetective;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.concurrent.TimeUnit;

/**
 * @author AndyFung
 * @version 1.0
 * @date 2020/11/3/003 17:36
 */
@Component("httpDetective")
public class HttpDetectiveImpl implements HttpDetective {

    @Autowired
    private RedisTemplate<String, Integer> integerRedisTemplate;

    @Autowired
    HttpDetective httpDetective;

    private final int RECORD_TIME=6000;
    private final int ALLOW_TIMES = 100;
    private final int REFUSE_TIME = 180000;

    @Override
    public boolean inspection(String ip) {
        Integer times = integerRedisTemplate.opsForValue().get(ip);
        if (times == null) {
            System.out.println("------有路人正常进入------");
            integerRedisTemplate.opsForValue().set(ip, 1, RECORD_TIME, TimeUnit.MILLISECONDS);
            return true;
        }else {
            if (times >= ALLOW_TIMES) {
                System.out.println("----认定为入侵行为，拦截访问，并且禁止目标短时间内再次访问，入侵者IP：" + ip);
                integerRedisTemplate.opsForValue().set(ip, ALLOW_TIMES, REFUSE_TIME, TimeUnit.MILLISECONDS);
                return false;
            }else {
                System.out.println("有可疑人员进入，" + times);
                integerRedisTemplate.opsForValue().increment(ip);
                return true;
            }
        }
    }


    @Bean
    public HandlerInterceptor visitorRegistration(){
        return new HandlerInterceptor() {
            @Override
            public boolean preHandle(HttpServletRequest request, HttpServletResponse response,Object handler)throws Exception{
                return httpDetective.inspection(request.getRemoteAddr());
            }
        };
    }

}
