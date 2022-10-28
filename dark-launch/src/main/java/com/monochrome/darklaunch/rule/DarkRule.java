package com.monochrome.darklaunch.rule;

import com.monochrome.darklaunch.DarkFeature;
import com.monochrome.darklaunch.IDarkFeature;

import javax.validation.constraints.NotNull;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author monochrome
 * @date 2022/10/27
 */
public class DarkRule {
    // 从配置文件加载的灰度规则
    private Map<String, IDarkFeature> darkFeatures = new HashMap<>();
    // 编程实现的灰度规则
    private ConcurrentHashMap<String, IDarkFeature> programmedDarkFeatures = new ConcurrentHashMap<>();

    public DarkRule(@NotNull DarkRuleConfig darkRuleConfig) {
        List<DarkRuleConfig.DarkFeatureConfig> darkFeatureConfigs = darkRuleConfig.getFeatures();
        for (DarkRuleConfig.DarkFeatureConfig darkFeatureConfig : darkFeatureConfigs) {
            darkFeatures.put(darkFeatureConfig.getKey(), new DarkFeature(darkFeatureConfig));
        }
    }

    public void addProgrammedDarkFeature(String featureKey, IDarkFeature darkFeature) {
        programmedDarkFeatures.put(featureKey, darkFeature);
    }

    public IDarkFeature getDarkFeature(String featureKey) {
        IDarkFeature darkFeature = programmedDarkFeatures.get(featureKey);
        return darkFeature == null ? darkFeatures.get(featureKey) : darkFeature;
    }
}
