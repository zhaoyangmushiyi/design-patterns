package com.mono.monochrome.observer;

/**
 * @author monochrome
 * @date 2022/8/12
 */
public class Observer2 {

    @Subscribe
    public void handle(Long userId) {
        System.out.println("Observer2 handle:" + userId);
    }

}
