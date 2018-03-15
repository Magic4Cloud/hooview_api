package com.hooview.common.redis;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;


/**
 * @auther lee
 * @createTime 2018年01月31日 14时09分
 * @discription
 */
@Component
public class JedisUtil {


    //Redis服务器IP
    private static String ADDR_ARRAY;

    //Redis的端口号
    private static int PORT = 6379;

    //访问密码
    private static String AUTH;
    //可用连接实例的最大数目，默认值为8；
    //如果赋值为-1，则表示不限制；如果pool已经分配了maxActive个jedis实例，则此时pool的状态为exhausted(耗尽)。
    private static int MAX_ACTIVE;

    //控制一个pool最多有多少个状态为idle(空闲的)的jedis实例，默认值也是8。
    private static int MAX_IDLE;

    //等待可用连接的最大时间，单位毫秒，默认值为-1，表示永不超时。如果超过等待时间，则直接抛出JedisConnectionException；
    private static int MAX_WAIT;

    //超时时间
    private static int TIMEOUT;

    //在borrow一个jedis实例时，是否提前进行validate操作；如果为true，则得到的jedis实例均是可用的；
    private static boolean TEST_ON_BORROW = true;

    private static JedisPool jedisPool = null;


    /**
     * 初始化Redis连接池
     */
    private static void initialPool() {
        try {
            JedisPoolConfig config = new JedisPoolConfig();
            config.setMaxTotal(MAX_ACTIVE);
            config.setMaxIdle(MAX_IDLE);
            config.setMaxWaitMillis(MAX_WAIT);
            config.setTestOnBorrow(TEST_ON_BORROW);
            jedisPool = new JedisPool(config, ADDR_ARRAY.split(",")[0], PORT, TIMEOUT, AUTH);
        } catch (Exception e) {

        }
    }

    /**
     * 在多线程环境同步初始化
     */
    private static synchronized void poolInit() {
        if (jedisPool == null) {
            initialPool();
        }
    }


    /**
     * 同步获取Jedis实例
     * @return Jedis
     */
    public synchronized static Jedis getJedis() {
        if (jedisPool == null) {
            poolInit();
        }
        Jedis jedis = null;
        try {
            if (jedisPool != null) {
                jedis = jedisPool.getResource();
            }
        } catch (Exception e) {
        }finally{
            returnResource(jedis);
        }
        return jedis;
    }

    /**
     * 释放jedis资源
     *
     * @param jedis
     */
    public static void returnResource(final Jedis jedis) {
        if (jedis != null && jedisPool != null) {
            jedis.close();
        }
    }


    @Value("${redis.addr_array}")
    public void setAddrArray(String addrArray) {
        ADDR_ARRAY = addrArray;
    }


    @Value("${redis.auth}")
    public void setAUTH(String auth) {
        AUTH = auth;
    }


    @Value("${redis.max_active}")
    public void setMaxActive(int maxActive) {
        MAX_ACTIVE = maxActive;
    }


    @Value("${redis.max_idle}")
    public void setMaxIdle(int maxIdle) {
        MAX_IDLE = maxIdle;
    }


    @Value("${redis.max_wait}")
    public void setMaxWait(int maxWait) {
        MAX_WAIT = maxWait;
    }


    @Value("${redis.timeout}")
    public void setTIMEOUT(int timeout) {
        TIMEOUT = timeout;
    }
}
