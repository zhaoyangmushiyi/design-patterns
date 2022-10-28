package com.monochrome.darklaunch;

import com.monochrome.darklaunch.rule.DarkRule;
import com.monochrome.darklaunch.rule.DarkRuleConfig;
import com.monochrome.darklaunch.rule.datasource.DarkRuleConfigSource;
import com.monochrome.darklaunch.rule.datasource.FileDarkRuleConfigSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.yaml.snakeyaml.Yaml;

import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @author monochrome
 * @date 2022/10/27
 */

public class DarkLaunch {
    private static final Logger log = LoggerFactory.getLogger(DarkLaunch.class);
    private static final int DEFAULT_RULE_UPDATE_TIME_INTERVAL = 60; // in seconds
    private DarkRuleConfigSource ruleConfigSource;
    private DarkRule rule;
    private ScheduledExecutorService executor;

    public DarkLaunch(int ruleUpdateTimeInterval) {
        ruleConfigSource = new FileDarkRuleConfigSource();
        DarkRuleConfig ruleConfig = ruleConfigSource.load();
        this.rule = new DarkRule(ruleConfig);
        this.executor = Executors.newSingleThreadScheduledExecutor();
        this.executor.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                DarkRuleConfig newRuleConfig = ruleConfigSource.load();
                DarkRule newDarkRule = new DarkRule(newRuleConfig);
                rule = newDarkRule;
            }
        }, ruleUpdateTimeInterval, ruleUpdateTimeInterval, TimeUnit.SECONDS);
    }

    public DarkLaunch() {
        this(DEFAULT_RULE_UPDATE_TIME_INTERVAL);
    }

    private void loadRule() {
        // 将灰度规则配置文件dark-rule.yaml中的内容读取DarkRuleConfig中
        InputStream in = null;
        DarkRuleConfig ruleConfig = null;
        try {
            in = this.getClass().getResourceAsStream("/dark-rule.yaml");
            if (in != null) {
                Yaml yaml = new Yaml();
                ruleConfig = yaml.loadAs(in, DarkRuleConfig.class);
            }
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    log.error("close file error:{}", e);
                }
            }
        }

        if (ruleConfig == null) {
            throw new RuntimeException("Can not load dark rule.");
        }
        // 更新规则并非直接在this.rule上进行，
        // 而是通过创建一个新的DarkRule，然后赋值给this.rule，
        // 来避免更新规则和规则查询的并发冲突问题
        DarkRule newRule = new DarkRule(ruleConfig);
        this.rule = newRule;
    }

    public DarkFeature getDarkFeature(String featureKey) {
        DarkFeature darkFeature = this.rule.getDarkFeature(featureKey);
        return darkFeature;
    }
}