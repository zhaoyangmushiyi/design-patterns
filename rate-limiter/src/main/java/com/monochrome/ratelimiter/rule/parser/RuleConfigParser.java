package com.monochrome.ratelimiter.rule.parser;

import com.monochrome.ratelimiter.rule.RuleConfig;

import java.io.InputStream;

/**
 * @author monochrome
 * @date 2022/10/25
 */
public interface RuleConfigParser {
    RuleConfig parse(String configText);
    RuleConfig parse(InputStream inputStream);
}
