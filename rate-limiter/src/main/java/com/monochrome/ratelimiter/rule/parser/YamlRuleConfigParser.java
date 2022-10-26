package com.monochrome.ratelimiter.rule.parser;

import com.monochrome.ratelimiter.rule.RuleConfig;
import org.yaml.snakeyaml.Yaml;

import java.io.InputStream;

/**
 * @author monochrome
 * @date 2022/10/25
 */
public class YamlRuleConfigParser implements RuleConfigParser {
    @Override
    public RuleConfig parse(String configText) {
        Yaml yaml = new Yaml();
        return yaml.loadAs(configText, RuleConfig.class);
    }

    @Override
    public RuleConfig parse(InputStream inputStream) {
        Yaml yaml = new Yaml();
        return yaml.loadAs(inputStream, RuleConfig.class);
    }
}
