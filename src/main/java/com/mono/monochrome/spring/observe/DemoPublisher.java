package com.mono.monochrome.spring.observe;

import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

/**
 * @author monochrome
 * @date 2022/10/14
 */
@Component
public class DemoPublisher {

    private final ApplicationContext applicationContext;

    public DemoPublisher(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    public void publishEvent(DemoEvent demoEvent) {
        this.applicationContext.publishEvent(demoEvent);
    }
}
