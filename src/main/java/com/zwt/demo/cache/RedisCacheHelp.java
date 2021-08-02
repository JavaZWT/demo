package com.zwt.demo.cache;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

/**
 * @author zwt
 * @version 1.0
 * @desc TODO
 * @date 2021/8/2 14:22
 */
@Component
public class RedisCacheHelp {
    @Autowired
    public void setRedisTemplate(RedisTemplate redisTemplate) {
        RedisCache.setRedisTemplate(redisTemplate);
        RedisCache1.setRedisTemplate(redisTemplate);
    }
}
