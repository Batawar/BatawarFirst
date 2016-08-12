package com.test.me;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

import javax.annotation.Resource;
import java.lang.reflect.Method;

/**
 * Created by jingbo.lin on 2016/8/11.
 */
@Configuration
@EnableCaching
//@PropertySource("classpath:redisProperity")
public class CacheConfiger extends CachingConfigurerSupport {
	@Bean
	public JedisConnectionFactory redisConnectionFactory() {
		JedisConnectionFactory redisConnectionFactory = new JedisConnectionFactory();

		// Defaults
		redisConnectionFactory.setHostName("127.0.0.1");
		redisConnectionFactory.setPort(6379);
		redisConnectionFactory.setDatabase(0);
		return redisConnectionFactory;
	}

	@Bean
	public RedisTemplate<Object, Object> redisTemplate(RedisConnectionFactory cf) {
		RedisTemplate<Object, Object> redisTemplate = new RedisTemplate<Object, Object>();
		redisTemplate.setConnectionFactory(cf);
		return redisTemplate;
	}

	@Bean
	public CacheManager cacheManager(RedisTemplate redisTemplate) {
		RedisCacheManager cacheManager = new RedisCacheManager(redisTemplate);

		// Number of seconds before expiration. Defaults to unlimited (0)
		cacheManager.setDefaultExpiration(300);
		return cacheManager;
	}

	@Bean
	public KeyGenerator keyGenerator() {
		return new KeyGenerator() {
			@Override
			public Object generate(Object o, Method method, Object... objects) {
				// This will generate a unique key of the class name, the method name,
				// and all method parameters appended.
				StringBuilder sb = new StringBuilder();
				sb.append(o.getClass().getName());
				sb.append(method.getName());
				for (Object obj : objects) {
					sb.append(obj.toString());
				}
				return sb.toString();
			}
		};
	}
//	private static final String PROPERTY_REDIS_NAME_HOST= "redis.host";
//	private static final String PROPERTY_REDIS_PROT= "redis.port";
//
//	@Resource
//	private Environment env;
//
//	@Bean
//	public CacheManager cacheManager(RedisTemplate redisTemplate){
//		return new RedisCacheManager(redisTemplate);
//	}
//
//	@Bean
//	public JedisConnectionFactory redisConnectionFactory(){
//		JedisConnectionFactory jedisConnectionFactory = new JedisConnectionFactory();
//		jedisConnectionFactory.afterPropertiesSet();
//		jedisConnectionFactory.setHostName(env.getRequiredProperty(PROPERTY_REDIS_NAME_HOST));
//		jedisConnectionFactory.setPort(Integer.parseInt(env.getRequiredProperty(PROPERTY_REDIS_PROT)));
//		return jedisConnectionFactory;
//	}
//
//	@Bean
//	public RedisTemplate<String,String> redisTemplate(RedisConnectionFactory redisCF){
//		RedisTemplate<String,String> redisTemplate = new RedisTemplate<String,String>();
//		redisTemplate.setConnectionFactory(redisCF);
//		redisTemplate.afterPropertiesSet();
//		return redisTemplate;
//	}

}
