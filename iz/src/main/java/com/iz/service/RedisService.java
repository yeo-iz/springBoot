package com.iz.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * redis service
 *
 * @author yt
 * @version 1.0
 * @date 2018/8/21
 * @remark
 */
@Service
public class RedisService {
  @Autowired private RedisTemplate redisTemplate;

  /**
   * 写入缓存
   *
   * @param key
   * @param value
   * @throws Exception
   */
  public void set(final String key, Object value) throws Exception {
    ValueOperations valueOperations = redisTemplate.opsForValue();
    valueOperations.set(key, value);
  }

  /**
   * 写入缓存设置时效时间
   *
   * @param key
   * @param value
   * @param expireTime
   * @throws Exception
   */
  public void set(final String key, Object value, Long expireTime) throws Exception {
    ValueOperations operations = redisTemplate.opsForValue();
    operations.set(key, value);
    redisTemplate.expire(key, expireTime, TimeUnit.SECONDS);
  }

  public void removes(final String... keys) {
    for (String key : keys) {
      remove(key);
    }
  }

  /**
   * 删除对应的value
   *
   * @param key
   */
  private void remove(final String key) {
    if (exists(key)) {
      redisTemplate.delete(key);
    }
  }

  /**
   * 批量删除key
   *
   * @param pattern
   */
  public void removePattern(final String pattern) {
    Set<Serializable> keys = redisTemplate.keys(pattern);
    if (keys.size() > 0) {
      redisTemplate.delete(keys);
    }
  }

  /**
   * 读取缓存
   *
   * @param key
   * @return
   */
  public Object get(final String key) {
    ValueOperations operations = redisTemplate.opsForValue();
    return operations.get(key);
  }

  /**
   * 列表添加
   *
   * @param keys
   * @param val
   */
  public void listPush(String[] keys, Object[] val) {
    ListOperations list = redisTemplate.opsForList();
    list.rightPush(keys, val);
  }

  /**
   * 列表获取
   *
   * @param k
   * @param l
   * @param l1
   * @return
   */
  public List<Object> lRange(String k, long l, long l1) {
    ListOperations<String, Object> list = redisTemplate.opsForList();
    return list.range(k, l, l1);
  }

  /**
   * 判断缓存中是否有对应的value
   *
   * @param key
   * @return
   */
  public boolean exists(final String key) {
    return redisTemplate.hasKey(key);
  }
}
