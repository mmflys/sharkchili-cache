package com.shark.cache.jedis;

import com.shark.cache.CacheBootStrap;
import com.shark.cache.container.CacheContainer;
import org.testng.annotations.Test;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import static org.testng.Assert.assertTrue;
import static org.testng.AssertJUnit.assertEquals;

/**
 * @Author: sharkchili
 * @Date: 2018/11/21 0021
 */
public class JedisPoolTest {

	@Test
	public void checkConnections(){
		JedisPool pool = new JedisPool(new JedisPoolConfig(), "47.99.220.192", 6379, 2000);
		Jedis jedis=pool.getResource();
		jedis.auth("sharkchili-redis-6379-flyfish");
		jedis.set("test","true");
		assertEquals("true",jedis.get("test"));
		jedis.close();
		pool.destroy();
		assertTrue(pool.isClosed());
	}

	@Test
	public void testContainer(){
		Jedis jedis=CacheBootStrap.get().<CacheContainer>container().getResource();
		//jedis.auth("sharkchili-redis-6379-flyfish");
		jedis.set("tests","false");
		System.out.println(jedis.get("tests"));
		//assertEquals("true",jedis.get("tests"));
	}
}
