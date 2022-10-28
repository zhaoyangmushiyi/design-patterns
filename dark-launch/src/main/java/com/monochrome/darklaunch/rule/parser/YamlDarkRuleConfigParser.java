package com.monochrome.darklaunch.rule.parser;

import com.monochrome.darklaunch.rule.DarkRuleConfig;
import org.yaml.snakeyaml.Yaml;

import java.io.InputStream;

/**
 * @author monochrome
 * @date 2022/10/25
 */
public class YamlDarkRuleConfigParser implements DarkRuleConfigParser {
    @Override
    public DarkRuleConfig parse(String configText) {
        Yaml yaml = new Yaml();
        return yaml.loadAs(configText, DarkRuleConfig.class);
    }

    @Override
    public DarkRuleConfig parse(InputStream inputStream) {
        Yaml yaml = new Yaml();
        return yaml.loadAs(inputStream, DarkRuleConfig.class);
    }
}
