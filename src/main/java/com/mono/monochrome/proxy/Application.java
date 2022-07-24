package com.mono.monochrome.proxy;

import com.mono.monochrome.proxy.impl.UserServiceImpl;
import com.mono.monochrome.proxy.impl.dynamicproxy.UserServiceDynamicProxy;
import com.mono.monochrome.proxy.impl.dynamicproxy.cglib.CglibProxyFactory;
import com.mono.monochrome.proxy.impl.dynamicproxy.cglib.CglibProxyInterfaceFactory;
import com.mono.monochrome.proxy.impl.staticproxy.UserServiceStaticProxy;

/**
 * @author monochrome
 * @date 2022/7/23
 */
public class Application {

    public static void main(String[] args) {

        System.out.println("静态代理：");
        UserService userService = new UserServiceStaticProxy();
        userService.login("username","password");

        System.out.println("java动态代理：");
        UserServiceDynamicProxy userServiceDynamicProxy = new UserServiceDynamicProxy();
        UserService userService1 = (UserService) userServiceDynamicProxy.createProxy(new UserServiceImpl());
        userService1.login("username","password");

        System.out.println("cglib代理有实现的类：");
        CglibProxyFactory<UserService> userServiceCglibProxyFactory = new CglibProxyFactory<>(new UserServiceImpl());
        UserService userService2 = (UserService) userServiceCglibProxyFactory.getProxyInstance();
        userService2.login("username","password");

        System.out.println("cglib代理接口：");
        CglibProxyInterfaceFactory cglibProxyInterfaceFactory = new CglibProxyInterfaceFactory();
        UserService userService3 = cglibProxyInterfaceFactory.getProxyInstance(UserServiceImpl.class);
        userService3.login("username","password");
    }

}
