package com.mono.monochrome.observer;

/**
 * @author monochrome
 * @date 2022/8/12
 */
public class Observer1 {

    @Subscribe
    public void handle(Long userId) {
        System.out.println("Observer1 handle:" + userId);
    }

}
