package com.demo.test;

import com.demo.utils.JedisUtil;
import redis.clients.jedis.Jedis;
import sun.awt.SunHints;

public class connect {
    public static void main(String[] args) {
        Jedis jedis = JedisUtil.getJedis();
        jedis.set("keyww","valueww");
        String str =jedis.get("keyww");
        System.out.println(str);
        jedis.close();
    }
}
