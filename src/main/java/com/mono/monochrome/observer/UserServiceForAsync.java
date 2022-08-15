package com.mono.monochrome.observer;

import java.util.List;
import java.util.concurrent.Executors;

/**
 * @author monochrome
 * @date 2022/8/12
 */
public class UserServiceForAsync {
    private EventBus eventBus;

    public UserServiceForAsync() {
        eventBus = new AsyncEventBus(Executors.newFixedThreadPool(4));
    }

    public void setObservers(List<Object> observers) {
        for (Object observer : observers) {
            eventBus.register(observer);
        }
    }

    public void register() {
        //do register and return userId;
        Long userId = 111L;
        eventBus.post(userId);
    }
}
