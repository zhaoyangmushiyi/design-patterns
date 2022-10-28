package com.monochrome.darklaunch;

import com.monochrome.darklaunch.rule.DarkRule;
import com.monochrome.darklaunch.rule.DarkRuleConfig;
import com.monochrome.darklaunch.rule.datasource.DarkRuleConfigSource;
import com.monochrome.darklaunch.rule.datasource.FileDarkRuleConfigSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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

    public void addProgrammedDarkFeature(String featureKey, IDarkFeature darkFeature) {
        this.rule.addProgrammedDarkFeature(featureKey, darkFeature);
    }

    public IDarkFeature getDarkFeature(String featureKey) {
        IDarkFeature darkFeature = this.rule.getDarkFeature(featureKey);
        return darkFeature;
    }
}