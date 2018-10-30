package com.iz.config;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import redis.clients.jedis.JedisPoolConfig;

/**
 * redis配置
 *
 * @author yt
 * @version 1.0
 * @date 2018/8/20
 * @remark
 */
@Configuration
@EnableCaching
public class RedisConfig extends CachingConfigurerSupport {
  @Value("${spring.redis.host}")
  private String host;

  @Value("${spring.redis.port}")
  private int port;

  @Value("${spring.redis.password}")
  private String password;

  @Value("${spring.redis.pool.max-active}")
  private int maxActive;

  @Value("${spring.redis.pool.max-idle}")
  private int maxIdle;

  @Value("${spring.redis.pool.min-idle}")
  private int minIdle;

  @Value("${spring.redis.pool.max-wait}")
  private int maxWait;

  @Bean
  public JedisConnectionFactory jedisConnectionFactory() {
    JedisConnectionFactory factory = new JedisConnectionFactory();
    factory.setPassword(password);
    factory.setHostName(host);
    factory.setPort(port);
    JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
    jedisPoolConfig.setMaxTotal(maxActive);
    jedisPoolConfig.setMaxIdle(maxIdle);
    jedisPoolConfig.setMinIdle(minIdle);
    jedisPoolConfig.setMaxWaitMillis(maxWait);
    factory.setPoolConfig(jedisPoolConfig);
    return factory;
  }

  /**
   * 重写生成key的策略
   *
   * @return
   */
  //  @Override
  //  public KeyGenerator keyGenerator() {
  //    return new KeyGenerator() {
  //      @Override
  //      public Object generate(Object target, Method method, Object... objects) {
  //        StringBuilder sb = new StringBuilder();
  //        sb.append(target.getClass().getName());
  //        sb.append(method.getName());
  //        for (Object obj : objects) {
  //          sb.append(obj.toString());
  //        }
  //        return sb.toString();
  //      }
  //    };
  //  }

  /**
   * 重写缓存管理
   *
   * @return
   */
  //  @Override
  //  @Bean
  //  public CacheManager cacheManager() {
  //    RedisConnectionFactory connectionFactory = new JedisConnectionFactory();
  //    // 初始化一个RedisCacheWriter
  //    RedisCacheWriter redisCacheWriter =
  //        RedisCacheWriter.nonLockingRedisCacheWriter(connectionFactory);
  //    //
  // 设置CacheManager的值序列化方式为JdkSerializationRedisSerializer,但其实RedisCacheConfiguration默认就是使用StringRedisSerializer序列化key，JdkSerializationRedisSerializer序列化value,所以以下注释代码为默认实现
  //    // ClassLoader loader = this.getClass().getClassLoader();
  //    // JdkSerializationRedisSerializer jdkSerializer = new
  // JdkSerializationRedisSerializer(loader);
  //    // RedisSerializationContext.SerializationPair<Object> pair =
  //    // RedisSerializationContext.SerializationPair.fromSerializer(jdkSerializer);
  //    // RedisCacheConfiguration
  //    //
  // defaultCacheConfig=RedisCacheConfiguration.defaultCacheConfig().serializeValuesWith(pair);
  //    RedisCacheConfiguration defaultCacheConfig = RedisCacheConfiguration.defaultCacheConfig();
  //    // 设置默认超过期时间是30秒
  //    // defaultCacheConfig.entryTtl(Duration.ofSeconds(30));
  //    // 初始化RedisCacheManager
  //    RedisCacheManager cacheManager = new RedisCacheManager(redisCacheWriter,
  // defaultCacheConfig);
  //    return cacheManager;
  //  }

  @Bean
  public RedisTemplate<String, String> getRedisTemplate(
      RedisConnectionFactory redisConnectionFactory) {
    RedisTemplate<String, String> redisTemplate = new RedisTemplate<>();
    redisTemplate.setConnectionFactory(redisConnectionFactory);
    // key序列化方式,但是如果方法上有Long等非String类型的话，会报类型转换错误
    // Long类型不可以会出现异常信息;
    RedisSerializer<String> redisSerializer = new StringRedisSerializer();
    redisTemplate.setKeySerializer(redisSerializer);
    Jackson2JsonRedisSerializer jackson2JsonRedisSerializer =
        new Jackson2JsonRedisSerializer(Object.class);
    ObjectMapper om = new ObjectMapper();
    om.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
    om.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
    jackson2JsonRedisSerializer.setObjectMapper(om);

    redisTemplate.setValueSerializer(jackson2JsonRedisSerializer);
    redisTemplate.setHashValueSerializer(jackson2JsonRedisSerializer);
    redisTemplate.afterPropertiesSet();

    return redisTemplate;
  }
}
