package com.mono.monochrome.spring.observe;

import org.springframework.context.ApplicationListener;

/**
 * @author monochrome
 * @date 2022/10/14
 */
public class DemoListener implements ApplicationListener<DemoEvent> {
    @Override
    public void onApplicationEvent(DemoEvent event) {
        String message = event.getMessage();
        System.out.println(message);
    }
}
