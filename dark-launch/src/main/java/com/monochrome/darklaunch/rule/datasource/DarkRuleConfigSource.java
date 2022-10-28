package com.monochrome.darklaunch.rule.datasource;

import com.monochrome.darklaunch.rule.DarkRuleConfig;

/**
 * @author monochrome
 * @date 2022/10/25
 */
public interface DarkRuleConfigSource {

    DarkRuleConfig load();

}
