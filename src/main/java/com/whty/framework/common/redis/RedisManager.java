package com.whty.framework.common.redis;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * redis 管理类
 */
public class RedisManager {

	private static JedisPool jedisPool = null;
	
	
	private static final Logger logger = LoggerFactory
			.getLogger(RedisManager.class);
	
	public RedisManager(String ip, String port,String maxActive,String maxIdle,String timeout) {
		super();
		JedisPoolConfig config = new JedisPoolConfig();
        config.setMaxActive(Integer.parseInt(maxActive));
        config.setMaxIdle(Integer.parseInt(maxIdle));
        config.setMaxWait(Long.parseLong(timeout));
        config.setTestOnBorrow(true);
		
		jedisPool = new JedisPool(config, ip,
				Integer.parseInt(port));
	}
	
	public void putKey(String key, String val,Integer expireTime) {
		Jedis jedis = jedisPool.getResource();
		try {
			jedis.set(key, val);
			jedis.expire(key,expireTime);
		} catch (Exception e) {
			logger.error(e.getMessage());
		} finally {
			jedisPool.returnResource(jedis);
		}
	}

	public String getKey(String key) {
		Jedis jedis = jedisPool.getResource();
		try {
			return jedis.get(key);
		} catch (Exception e) {
			logger.error(e.getMessage());
		} finally {
			jedisPool.returnResource(jedis);
		}
		return null;
	}
	
	public void removeKey(String key){
		Jedis jedis = jedisPool.getResource();
		try {
			jedis.del(key);
		} catch (Exception e) {
			logger.error(e.getMessage());
		} finally {
			jedisPool.returnResource(jedis);
		}
	}
}
