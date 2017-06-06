package com.tiancaibao.utils;

import java.util.concurrent.locks.ReentrantLock;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;
import redis.clients.jedis.exceptions.JedisConnectionException;
import redis.clients.jedis.exceptions.JedisDataException;
import redis.clients.jedis.exceptions.JedisException;

/**
 * Redis 工具类
 */
public class JedisUtil {

	protected static ReentrantLock lockPool = new ReentrantLock();
	protected static ReentrantLock lockJedis = new ReentrantLock();

	protected static Logger logger = Logger.getLogger(JedisUtil.class);

	// Redis服务器IP
	private static String ADDR_ARRAY = "127.0.0.1";

	// Redis的端口号
	private static int PORT = 6379;

	// 访问密码
	private static String AUTH = "";
	// 可用连接实例的最大数目，默认值为8；
	// 如果赋值为-1，则表示不限制；如果pool已经分配了maxActive个jedis实例，则此时pool的状态为exhausted(耗尽)。
	private static int MAX_ACTIVE = 100;

	// 控制一个pool最多有多少个状态为idle(空闲的)的jedis实例，默认值也是8。
	private static int MAX_IDLE = 30;

	// 等待可用连接的最大时间，单位毫秒，默认值为-1，表示永不超时。如果超过等待时间，则直接抛出JedisConnectionException；
	private static int MAX_WAIT = 1000;

	// 超时时间
	private static int TIMEOUT = 30000;

	// 在borrow一个jedis实例时，是否提前进行validate操作；如果为true，则得到的jedis实例均是可用的；
	private static boolean TEST_ON_BORROW = false;

	private static JedisPool jedisPool = null;

	/**
	 * redis过期时间,以秒为单位
	 */
	public final static int EXRP_HALF_HOUR = 30 * 60; // 一小时
	public final static int EXRP_HOUR = 60 * 60; // 一小时
	public final static int EXRP_DAY = 60 * 60 * 24; // 一天
	public final static int EXRP_MONTH = 60 * 60 * 24 * 30; // 一个月

	/**
	 * 初始化Redis连接池
	 */
	private static void initialPool() {
		try {
			JedisPoolConfig config = new JedisPoolConfig();
			config.setMaxTotal(MAX_ACTIVE);
			config.setMaxIdle(MAX_IDLE);
			config.setMaxWaitMillis(MAX_WAIT);
			// config.set.setMaxActive(MAX_ACTIVE);
			// config.setMaxIdle(MAX_IDLE);
			// config.setMaxWait(MAX_WAIT);
			config.setTestOnBorrow(TEST_ON_BORROW);

			// jedisPool = new JedisPool(config, ADDR_ARRAY.split(",")[0], PORT,
			// TIMEOUT,AUTH);
			jedisPool = new JedisPool(config, ADDR_ARRAY.split(",")[0], PORT, TIMEOUT);
		} catch (Exception e) {
			logger.error("First create JedisPool error : " + e);
		}
	}

	/**
	 * 在多线程环境同步初始化
	 */
	private static void poolInit() {
		lockPool.lock();
		try {
			if (jedisPool == null) {
				initialPool();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			lockPool.unlock();
		}
	}

	public static Jedis getJedis() {
		lockJedis.lock();
		boolean broken = false;

		if (jedisPool == null) {
			poolInit();
		}
		Jedis jedis = null;
		try {
			if (jedisPool != null) {
				jedis = jedisPool.getResource();
			}
		} catch (JedisException e) {
			broken = handleJedisException(e);
			logger.error("Get jedis error : " + e);
		} finally {
			closeResource(jedis, broken);
			lockJedis.unlock();
		}
		return jedis;
	}

	protected static boolean handleJedisException(JedisException jedisException) {
		if (jedisException instanceof JedisConnectionException) {
			logger.error("Redis connection  lost.", jedisException);
		} else if (jedisException instanceof JedisDataException) {
			if ((jedisException.getMessage() != null) && (jedisException.getMessage().indexOf("READONLY") != -1)) {
				logger.error("Redis connection are read-only slave.", jedisException);
			} else {
				// dataException, isBroken=false
				return false;
			}
		} else {
			logger.error("Jedis exception happen.", jedisException);
		}
		return true;
	}

	/**
	 * 释放jedis资源
	 *
	 * @param jedis
	 */
	protected static void closeResource(Jedis jedis, boolean conectionBroken) {
		try {
			if (conectionBroken) {
				jedisPool.returnBrokenResource(jedis);
			} else {
				jedisPool.returnResource(jedis);
			}
		} catch (Exception e) {
			logger.error("return back jedis failed, will fore close the jedis.", e);
			jedis = null;
		}
	}

	/**
	 * 设置 String
	 *
	 * @param key
	 * @param value
	 */
	public synchronized static void setString(String key, String value) {
		try {
			value = StringUtils.isEmpty(value) ? "" : value;
			getJedis().set(key, value);
		} catch (Exception e) {
			logger.error("Set key error : " + e);
		}
	}

	/**
	 * 设置 过期时间
	 *
	 * @param key
	 * @param seconds
	 *            以秒为单位
	 * @param value
	 */
	public synchronized static void setString(String key, int seconds, String value) {
		try {
			value = StringUtils.isEmpty(value) ? "" : value;
			getJedis().setex(key, seconds, value);
		} catch (Exception e) {
			logger.error("Set keyex error : " + e);
		}
	}

	/**
	 * 获取String值
	 *
	 * @param key
	 * @return value
	 */
	public synchronized static String getString(String key) {
		if (getJedis() == null || !getJedis().exists(key)) {
			return null;
		}
		return getJedis().get(key);
	}

	public static void main(String[] args) {
		Jedis j = JedisUtil.getJedis();
		j.set("seq","1321");
		// CrowdfundingProduct crowdfundingProduct=new CrowdfundingProduct();
		// crowdfundingProduct.setAuditTime("273821");
		// j.set("crowdfundingProduct".getBytes(),
		// SerializeUtil.serialize(crowdfundingProduct));
		// j.set("seq", "50");
		System.out.println(j.get("seq"));
		// System.out.println(((CrowdfundingProduct)SerializeUtil.unserialize(j.get("crowdfundingProduct".getBytes()))).getAuditTime());
		// Long i=j.incr("seq");
		// System.out.println(i);
		// j.set("newname", "中文测试");
		// System.out.println(JedisUtil.getJedis().get("newname"));
	}
}
