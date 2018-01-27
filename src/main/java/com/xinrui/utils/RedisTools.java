package com.xinrui.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Repository;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;


@Repository
public class RedisTools {

    @Autowired
    private RedisTemplate redisTemplate;  //pom.xml 引入redis包

    private Logger logger = LoggerFactory.getLogger(getClass());

    private ValueOperations valueOperations() {
        return redisTemplate.opsForValue();
    }

    /**
     * 设置值
     * @param key
     * @param value
     */
    public void set(String key, Object value) {
        ValueOperations valueOperations = valueOperations();
        valueOperations.set(key, value);
        logger.debug(String.format("Redis:set %s to redis.", key));
    }

    /**
     * 设置值（带过期时间： 秒）
     * @param key
     * @param value
     * @param time
     */
    public void set(String key, Object value, long time) {
        ValueOperations valueOperations = valueOperations();
        valueOperations.set(key, value, time, TimeUnit.SECONDS);
        logger.debug(String.format("Redis:set %s to redis,expire time %s seconds.", key, time));
    }

    /**
     * 设置值（带过期时间与单位）
     * @param key
     * @param value
     * @param time
     * @param timeUnit
     */
    public void set(String key, Object value, long time, TimeUnit timeUnit) {
        ValueOperations valueOperations = valueOperations();
        valueOperations.set(key, value, time, timeUnit);
        logger.debug(String.format("Redis:set %s to redis,expire time %s %s.", key, time, timeUnit.toString()));
    }

    /**
     * 设置多个值
     * @param map
     */
    public void multiSet(Map map) {
        ValueOperations valueOperations = valueOperations();
        valueOperations.multiSet(map);
        logger.debug(String.format("Redis:multiSet %s to redis", map.keySet().toString()));
    }


    /**
     * 获取值
     * @param key
     * @return
     */
    public Object get(String key) {
        ValueOperations valueOperations = valueOperations();
        Object object = valueOperations.get(key);
        return object;
    }

    /**
     * 获取多个值
     * @param keys
     * @return
     */
    public List<Object> multiGet(Collection keys) {
        if (CollectionUtils.isEmpty(keys)) {
            return new ArrayList<>();
        }
        ValueOperations valueOperations = valueOperations();
        List<Object> values = valueOperations.multiGet(keys);
        return values;
    }

    /**
     * 删除多个
     * @param keys
     */
    public void delete(String... keys) {
        if (keys == null || keys.length == 0) {
            return;
        }
        if (keys.length == 1) {
            redisTemplate.delete(keys[0]);
        } else {
            //redisTemplate.delete(CollectionUtils.arrayToList(keys));
            redisTemplate.delete(Arrays.asList(keys));
        }
        logger.debug(String.format("Redis:delete %s from redis", keys.toString()));
    }

    /**
     * 模糊匹配删除
     *
     * @param pattern
     */
    public void deleteLikePattern(String pattern) {
        redisTemplate.delete(redisTemplate.keys(pattern + "*"));
    }


    /**
     * 判断值是否存在
     * @param key
     * @return
     */
    public boolean exists(String key) {
        boolean exists = redisTemplate.hasKey(key);
        return exists;
    }


}
