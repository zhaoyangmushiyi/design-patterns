package com.monochrome.darklaunch.rule.datasource;

import com.monochrome.darklaunch.rule.DarkRuleConfig;
import com.monochrome.darklaunch.rule.parser.DarkRuleConfigParser;
import com.monochrome.darklaunch.rule.parser.JsonDarkRuleConfigParser;
import com.monochrome.darklaunch.rule.parser.YamlDarkRuleConfigParser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

/**
 * @author monochrome
 * @date 2022/10/25
 */
public class FileDarkRuleConfigSource implements DarkRuleConfigSource {

    private static final Logger log = LoggerFactory.getLogger(FileDarkRuleConfigSource.class);
    public static final String DARK_RULE_CONFIG_NAME = "dark-rule";
    public static final String YAML_EXTENSION = "yaml";
    public static final String YML_EXTENSION = "yml";
    public static final String JSON_EXTENSION = "json";
    private static final String[] SUPPORT_EXTENSIONS = new String[]{YAML_EXTENSION, YML_EXTENSION, JSON_EXTENSION};
    private static final Map<String, DarkRuleConfigParser> PARSER_MAP = new HashMap<>();

    static {
        PARSER_MAP.put(YAML_EXTENSION, new YamlDarkRuleConfigParser());
        PARSER_MAP.put(YML_EXTENSION, new YamlDarkRuleConfigParser());
        PARSER_MAP.put(JSON_EXTENSION, new JsonDarkRuleConfigParser());
    }

    @Override
    public DarkRuleConfig load() {
        for (String extension : SUPPORT_EXTENSIONS) {
            try (InputStream in = this.getClass().getResourceAsStream("/" + getFileNameByExt(extension))) {
                if (in != null) {
                    DarkRuleConfigParser ruleConfigParser = PARSER_MAP.get(extension);
                    return ruleConfigParser.parse(in);
                }
            } catch (IOException e) {
                log.error("close file error:{}", e);
            }
        }
        return null;
    }

    private String getFileNameByExt(String extension) {
        return DARK_RULE_CONFIG_NAME + "." + extension;
    }
}
