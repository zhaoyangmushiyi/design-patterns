package com.monochrome.ratelimiter;

import com.monochrome.ratelimiter.alg.RateLimitAlg;
import com.monochrome.ratelimiter.rule.*;
import com.monochrome.ratelimiter.rule.datasource.FileRuleConfigSource;
import com.monochrome.ratelimiter.rule.datasource.RuleConfigSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author monochrome
 * @date 2022/10/23
 */

public class RateLimiter {
    private static final Logger log = LoggerFactory.getLogger(RateLimiter.class);
    // 为每个api在内存中存储限流计数器
    private ConcurrentHashMap<String, RateLimitAlg> counters = new ConcurrentHashMap<>();
    private RateLimitRule rule;

    public RateLimiter() {
        // 主要修改在这儿，调用RuleConfigSource类来实现配置加载，支持多种配置文件的读取
        RuleConfigSource ruleConfigSource = new FileRuleConfigSource();
        RuleConfig ruleConfig = ruleConfigSource.load();
        // 将限流规则构建成支持快速查找的数据结构RateLimitRule
        this.rule = new RateLimitRule(ruleConfig);
    }

    public boolean limit(String appId, String url) {
        ApiLimit apiLimit = rule.getLimit(appId, url);
        if (apiLimit == null) {
            return true;
        }

        // 获取api对应在内存中的限流计数器（rateLimitCounter）
        String counterKey = appId + ":" + apiLimit.getApi();
        RateLimitAlg rateLimitCounter = counters.get(counterKey);
        if (rateLimitCounter == null) {
            RateLimitAlg newRateLimitCounter = new RateLimitAlg(apiLimit.getLimit());
            rateLimitCounter = counters.putIfAbsent(counterKey, newRateLimitCounter);
            if (rateLimitCounter == null) {
                rateLimitCounter = newRateLimitCounter;
            }
        }

        // 判断是否限流
        return rateLimitCounter.tryAcquire();
    }
}
