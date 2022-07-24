package com.mono.monochrome.proxy.impl.dynamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author monochrome
 * @date 2022/7/23
 */
public class DynamicInvocationHandler implements InvocationHandler {

    private final Object proxiedObject;

    public DynamicInvocationHandler(Object proxiedObject) {
        this.proxiedObject = proxiedObject;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("login start：" + (new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date())));
        Object result = method.invoke(proxiedObject, args);
        System.out.println("login end：" + (new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date())));
        return result;
    }
}
