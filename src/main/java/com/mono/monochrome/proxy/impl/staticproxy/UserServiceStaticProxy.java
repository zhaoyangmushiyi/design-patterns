package com.mono.monochrome.proxy.impl.staticproxy;

import com.mono.monochrome.proxy.impl.UserServiceImpl;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author monochrome
 * @date 2022/7/23
 */
public class UserServiceStaticProxy extends UserServiceImpl {

    @Override
    public void login(String username, String password) {
        System.out.println("login start：" + (new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date())));
        super.login(username, password);
        System.out.println("login end：" + (new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date())));
    }
}
