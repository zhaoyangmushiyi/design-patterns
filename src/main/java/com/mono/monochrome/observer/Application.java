package com.mono.monochrome.observer;

import java.util.Arrays;

/**
 * @author monochrome
 * @date 2022/8/12
 */
public class Application {

    public static void main(String[] args) {
        UserService userService = new UserService();
        userService.setObservers(Arrays.asList(new Observer1(), new Observer2()));
        userService.register();

        UserServiceForAsync userServiceForAsync = new UserServiceForAsync();
        userServiceForAsync.setObservers(Arrays.asList(new Observer1(), new Observer2()));
        userServiceForAsync.register();
    }

}
