package com.demo.utils;

import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

public class JedisUtil {
    private static JedisPool pool=null;
    static {
        try {
            GenericObjectPoolConfig poolConfig =new GenericObjectPoolConfig();
            poolConfig.setMaxTotal(100);
            poolConfig.setMaxIdle(10);
            String host ="192.168.10.48";
            pool =new JedisPool(poolConfig,host);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public static Jedis getJedis(){
        Jedis jedis=null;
        if (pool!=null){
            jedis=pool.getResource();
        }
        return jedis;
    }
    public static void closeJedis(Jedis jedis){
        if (jedis!=null){
            jedis.close();
        }
    }
}
