package com.mono.monochrome.proxy.impl.dynamicproxy;

import com.mono.monochrome.proxy.UserService;
import com.mono.monochrome.proxy.impl.UserServiceImpl;

import java.lang.reflect.Proxy;

/**
 * @author monochrome
 * @date 2022/7/23
 */
public class UserServiceDynamicProxy {

    private final UserServiceImpl userService;

    public UserServiceDynamicProxy() {
        this.userService = new UserServiceImpl();
    }

    public Object createProxy(Object proxiedObject) {
        Class<?>[] interfaces = proxiedObject.getClass().getInterfaces();
        DynamicInvocationHandler handler = new DynamicInvocationHandler(userService);
        return Proxy.newProxyInstance(proxiedObject.getClass().getClassLoader(), interfaces, handler);
    }

}
