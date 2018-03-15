package com.hooview.common.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;

import java.util.List;
import java.util.Set;

/**
 * @auther lee
 * @createTime 2018年01月31日 15时03分
 * @discription
 */
@Service("redisClient")
public class RedisClient {
    @Autowired
    private JedisUtil jedisUtil;
    /**
     * 通过key删除（字节）
     * @param key
     */
    public void del(byte [] key){
        Jedis jedis = jedisUtil.getJedis();
        jedis.del(key);
        jedisUtil.returnResource(jedis);
    }
    /**
     * 通过key删除
     * @param key
     */
    public void del(String key){
        Jedis jedis = jedisUtil.getJedis();
        jedis.del(key);
        jedisUtil.returnResource(jedis);
    }

    /**
     * 添加key value 并且设置存活时间(byte)
     * @param key
     * @param value
     * @param liveTime
     */
    public void set(byte [] key,byte [] value,int liveTime){
        Jedis jedis = jedisUtil.getJedis();
        jedis.set(key, value);
        jedis.expire(key, liveTime);
        jedisUtil.returnResource(jedis);
    }
    /**
     * 添加key value 并且设置存活时间
     * @param key
     * @param value
     * @param liveTime
     */
    public void set(String key,String value,int liveTime){
        Jedis jedis = jedisUtil.getJedis();
        jedis.set(key, value);
        jedis.expire(key, liveTime);
        jedisUtil.returnResource(jedis);
    }
    /**
     * 添加key value
     * @param key
     * @param value
     */
    public void set(String key,String value){
        Jedis jedis = jedisUtil.getJedis();
        jedis.set(key, value);
        //jedisUtil.returnResource(jedis);
    }
    /**添加key value (字节)(序列化)
     * @param key
     * @param value
     */
    public void set(byte [] key,byte [] value){
        Jedis jedis = jedisUtil.getJedis();
        jedis.set(key, value);
        jedisUtil.returnResource(jedis);
    }
    /**
     * 获取redis value (String)
     * @param key
     * @return
     */
    public String get(String key){
        Jedis jedis = jedisUtil.getJedis();
        String value = jedis.get(key);
        //jedisUtil.returnResource(jedis);
        return value;
    }
    /**
     * 获取redis value (byte [] )(反序列化)
     * @param key
     * @return
     */
    public byte[] get(byte [] key){
        Jedis jedis = jedisUtil.getJedis();
        byte[] value = jedis.get(key);
        jedisUtil.returnResource(jedis);
        return value;
    }

    /**
     * 通过正则匹配keys
     * @param pattern
     * @return
     */
    public Set<String> keys(String pattern){
        Jedis jedis = jedisUtil.getJedis();
        Set<String> value = jedis.keys(pattern);
        jedisUtil.returnResource(jedis);
        return value;
    }

    /**
     * 检查key是否已经存在
     * @param key
     * @return
     */
    public boolean exists(String key){
        Jedis jedis = jedisUtil.getJedis();
        boolean value = jedis.exists(key);
        jedisUtil.returnResource(jedis);
        return value;
    }

    /*******************redis list操作************************/
    /**
     * 往list中添加元素
     * @param key
     * @param value
     */
    public void lpush(String key,String value){
        Jedis jedis = jedisUtil.getJedis();
        jedis.lpush(key, value);
        jedisUtil.returnResource(jedis);
    }

    public void rpush(String key,String value){
        Jedis jedis = jedisUtil.getJedis();
        jedis.rpush(key, value);
        jedisUtil.returnResource(jedis);
    }

    /**
     * 数组长度
     * @param key
     * @return
     */
    public Long llen(String key){
        Jedis jedis = jedisUtil.getJedis();
        Long len = jedis.llen(key);
        jedisUtil.returnResource(jedis);
        return len;
    }

    /**
     * 获取下标为index的value
     * @param key
     * @param index
     * @return
     */
    public String lindex(String key,Long index){
        Jedis jedis = jedisUtil.getJedis();
        String str = jedis.lindex(key, index);
        jedisUtil.returnResource(jedis);
        return str;
    }

    public String lpop(String key){
        Jedis jedis = jedisUtil.getJedis();
        String str = jedis.lpop(key);
        jedisUtil.returnResource(jedis);
        return str;
    }

    public List<String> lrange(String key, long start, long end){
        Jedis jedis = jedisUtil.getJedis();
        List<String> str = jedis.lrange(key, start, end);
        jedisUtil.returnResource(jedis);
        return str;
    }
    /*********************redis list操作结束**************************/

    /**
     * 清空redis 所有数据
     * @return
     */
    public String flushDB(){
        Jedis jedis = jedisUtil.getJedis();
        String str = jedis.flushDB();
        jedisUtil.returnResource(jedis);
        return str;
    }
    /**
     * 查看redis里有多少数据
     */
    public long dbSize(){
        Jedis jedis = jedisUtil.getJedis();
        long len = jedis.dbSize();
        jedisUtil.returnResource(jedis);
        return len;
    }
    /**
     * 检查是否连接成功
     * @return
     */
    public String ping(){
        Jedis jedis = jedisUtil.getJedis();
        String str = jedis.ping();
        jedisUtil.returnResource(jedis);
        return str;
    }
}
