package com.mono.monochrome.di;

import com.mono.monochrome.di.bean.RateLimiter;
import com.mono.monochrome.di.bean.RedisCounter;
import com.mono.monochrome.di.impl.ClassPathXmlApplicationContext;

/**
 * @author monochrome
 * @date 2022/7/19
 */
public class Application {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("di/beans.xml");
        RedisCounter redisCounter = (RedisCounter) applicationContext.getBean("redisCounter");
        RateLimiter rateLimiter = (RateLimiter) applicationContext.getBean("rateLimiter");
        System.out.println(redisCounter);
        rateLimiter.test();
        System.out.println(redisCounter == rateLimiter.getRedisCounter());
    }
}
