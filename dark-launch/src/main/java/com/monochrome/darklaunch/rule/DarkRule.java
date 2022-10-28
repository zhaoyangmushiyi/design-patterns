package com.monochrome.darklaunch.rule;

import com.monochrome.darklaunch.DarkFeature;

import javax.validation.constraints.NotNull;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author monochrome
 * @date 2022/10/27
 */
public class DarkRule {
    private Map<String, DarkFeature> darkFeatures = new HashMap<>();

    public DarkRule(@NotNull DarkRuleConfig darkRuleConfig) {
        List<DarkRuleConfig.DarkFeatureConfig> darkFeatureConfigs = darkRuleConfig.getFeatures();
        for (DarkRuleConfig.DarkFeatureConfig darkFeatureConfig : darkFeatureConfigs) {
            darkFeatures.put(darkFeatureConfig.getKey(), new DarkFeature(darkFeatureConfig));
        }
    }

    public DarkFeature getDarkFeature(String featureKey) {
        return darkFeatures.get(featureKey);
    }
}
