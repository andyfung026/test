package com.greencity.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericToStringSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

/**
 * @author AndyFung
 * @version 1.0
 * @date 2020/11/3/003 17:21
 */
@Configuration
public class RedisConfig {

//redis-server redis.windows.conf
    @Bean("integerRedisSerializer")
    public RedisTemplate<String, Integer> intRedisTemplate(RedisConnectionFactory redisConnectionFactory) {
        RedisTemplate<String, Integer> re = new RedisTemplate();
        re.setConnectionFactory(redisConnectionFactory);
        //redis 序列化key放的String类型
        re.setKeySerializer(new StringRedisSerializer());
        //redis 序列化value放的累加integer类型
        re.setValueSerializer(new GenericToStringSerializer<>(Integer.class));
        return re;
    }

}
