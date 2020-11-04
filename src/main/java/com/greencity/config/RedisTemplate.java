package com.greencity.config;

import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.SerializationException;
import reactor.util.annotation.Nullable;

import java.nio.charset.StandardCharsets;

/**
 * @author AndyFung
 * @version 1.0
 * @date 2020/11/3/003 17:07
 */
public class RedisTemplate implements RedisSerializer<Integer> {

    @Override
    public byte[] serialize(@Nullable Integer integer) throws SerializationException {
        return integer == null ? null : integer.toString().getBytes(StandardCharsets.UTF_8);
    }

    @Override
    public Integer deserialize(@Nullable byte[] bytes) throws SerializationException {
        return bytes == null ? null : Integer.valueOf(new String(bytes, StandardCharsets.UTF_8));
    }
}
