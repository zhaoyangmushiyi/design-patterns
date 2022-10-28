package com.monochrome.darklaunch.rule.parser;

import com.monochrome.darklaunch.rule.DarkRuleConfig;

import java.io.InputStream;

/**
 * @author monochrome
 * @date 2022/10/25
 */
public interface DarkRuleConfigParser {
    DarkRuleConfig parse(String configText);
    DarkRuleConfig parse(InputStream inputStream);
}
