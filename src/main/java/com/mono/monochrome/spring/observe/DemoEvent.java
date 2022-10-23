package com.mono.monochrome.spring.observe;

import org.springframework.context.ApplicationEvent;

/**
 * @author monochrome
 * @date 2022/10/14
 */
public class DemoEvent extends ApplicationEvent {

    private final String message;

    public DemoEvent(Object source, String message) {
        super(source);
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
