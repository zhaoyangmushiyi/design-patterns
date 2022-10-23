package com.monochrome.ratelimiter.rule;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author monochrome
 * @date 2022/10/23
 */

public class RateLimitRule {

    Map<String, ApiLimit> apiLimitMap = new HashMap<>();

    public RateLimitRule(RuleConfig ruleConfig) {
        List<RuleConfig.AppRuleConfig> configs = ruleConfig.getConfigs();
        for (RuleConfig.AppRuleConfig config : configs) {
            String appId = config.getAppId();
            List<ApiLimit> limits = config.getLimits();
            for (ApiLimit limit : limits) {
                apiLimitMap.putIfAbsent(appId + ":" + limit.getApi(), limit);
            }
        }
    }

    public ApiLimit getLimit(String appId, String api) {
        return apiLimitMap.get(appId + ":" + api);
    }

}