package com.monochrome.ratelimiter.rule.datasource;

import com.monochrome.ratelimiter.rule.RuleConfig;

/**
 * @author monochrome
 * @date 2022/10/25
 */
public interface RuleConfigSource {

    RuleConfig load();

}
