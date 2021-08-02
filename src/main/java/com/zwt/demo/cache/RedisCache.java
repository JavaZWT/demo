package com.zwt.demo.cache;

import org.apache.ibatis.cache.Cache;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author zwt
 * @version 1.0
 * @desc 使用Redis实现Mybatis二级缓存 Hash 表
 * @date 2021/8/2 14:16
 */
public class RedisCache implements Cache{

    private static final Logger logger = LoggerFactory.getLogger(RedisCache.class);

    private static RedisTemplate<String,Object> redisTemplate;

    private final String id;

    private final String HASH_KEY = "mybatis_redis_cache";

    private final ReadWriteLock readWriteLock = new ReentrantReadWriteLock();

    @Override
    public ReadWriteLock getReadWriteLock(){
        return this.readWriteLock;
    }

    public static void setRedisTemplate(RedisTemplate redisTemplate){
        RedisCache.redisTemplate = redisTemplate;
    }

    public RedisCache(final String id){
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
            redisTemplate.opsForHash().put(HASH_KEY,key.toString(),value);
        }
    }

    @Override
    public Object getObject(Object key) {
        logger.info("MybatisRedisCache -> getObject: key="+key);
        if(null != key) {
            return redisTemplate.opsForHash().get(HASH_KEY,key.toString());
        }
        return null;
    }

    @Override
    public Object removeObject(Object key){
        logger.info("MybatisRedisCache -> removeObject: key="+key);
        if(null != key) {
            return redisTemplate.opsForHash().delete(HASH_KEY,key);
        }
        return null;
    }

    @Override
    public void clear() {
        Long size = redisTemplate.opsForHash().size(HASH_KEY);
        redisTemplate.delete(HASH_KEY);
        logger.info("MybatisRedisCache -> clear: 清除了" + size + "个对象");
    }

    @Override
    public int getSize() {
        Long size = redisTemplate.opsForHash().size(HASH_KEY);
        return size == null ? 0 : size.intValue();
    }
}
