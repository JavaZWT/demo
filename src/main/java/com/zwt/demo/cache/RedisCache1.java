package com.zwt.demo.cache;

import org.apache.ibatis.cache.Cache;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author zwt
 * @version 1.0
 * @desc 使用Redis实现Mybatis二级缓存 前缀
 * @date 2021/8/2 14:16
 */
public class RedisCache1 implements Cache{

    private static final Logger logger = LoggerFactory.getLogger(RedisCache1.class);

    private static RedisTemplate<String,Object> redisTemplate;

    private final String id;

    private final String KEY_ALL_PREFIX = "mybatis_redis_cache_%s";

    private final ReadWriteLock readWriteLock = new ReentrantReadWriteLock();

    @Override
    public ReadWriteLock getReadWriteLock(){
        return this.readWriteLock;
    }

    public static void setRedisTemplate(RedisTemplate redisTemplate){
        RedisCache1.redisTemplate = redisTemplate;
    }

    public RedisCache1(final String id){
        if (id == null) {
            throw new IllegalArgumentException("需要指定id");
        }
        this.id = id;
    }

    @Override
    public String getId(){
        return this.id;
    }

    @Override
    public void putObject(Object key, Object value){
        logger.info("MybatisRedisCache -> putObject: key=" + key + ",value=" + value);
        if(null!=value) {
            redisTemplate.opsForValue().set(String.format(KEY_ALL_PREFIX,key.toString()),value,60, TimeUnit.SECONDS);
        }
    }

    @Override
    public Object getObject(Object key) {
        logger.info("MybatisRedisCache -> getObject: key="+key);
        if(null != key) {
            return redisTemplate.opsForValue().get(String.format(KEY_ALL_PREFIX,key.toString()));
        }
        return null;
    }

    @Override
    public Object removeObject(Object key){
        logger.info("MybatisRedisCache -> removeObject: key="+key);
        if(null != key) {
            return redisTemplate.delete(String.format(KEY_ALL_PREFIX,key.toString()));
        }
        return null;
    }

    @Override
    public void clear() {
        Set<String> keys = redisTemplate.keys(String.format(KEY_ALL_PREFIX,"*"));
        redisTemplate.delete(keys);
        logger.info("MybatisRedisCache -> clear: 清除了" + keys.size() + "个对象");
    }

    @Override
    public int getSize() {
        Set<String> keys = redisTemplate.keys(String.format(KEY_ALL_PREFIX,"*"));
        return keys.size();
    }
}
