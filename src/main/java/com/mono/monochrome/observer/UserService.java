package com.mono.monochrome.observer;

import java.util.List;

/**
 * @author monochrome
 * @date 2022/8/12
 */
public class UserService {
    private EventBus eventBus;

    public UserService() {
        eventBus = new EventBus();
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
