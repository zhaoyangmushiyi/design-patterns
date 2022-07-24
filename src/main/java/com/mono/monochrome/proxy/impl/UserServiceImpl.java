package com.mono.monochrome.proxy.impl;

import com.mono.monochrome.proxy.UserService;

/**
 * @author monochrome
 * @date 2022/7/23
 */
public class UserServiceImpl implements UserService {

    @Override
    public void login(String username, String password) {
        System.out.println("User ["+username+"] logins!");
    }
}
