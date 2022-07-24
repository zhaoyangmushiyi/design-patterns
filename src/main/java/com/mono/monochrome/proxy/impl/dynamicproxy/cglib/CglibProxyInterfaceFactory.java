package com.mono.monochrome.proxy.impl.dynamicproxy.cglib;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * cglib创建有实现的对象
 * @author monochrome
 * @date 2022/7/24
 */
public class CglibProxyInterfaceFactory implements MethodInterceptor {

    public <T> T getProxyInstance(Class<T> clz) {
        return (T) Enhancer.create(clz, this);
    }

    @Override
    public Object intercept(Object o, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
        System.out.println("login start：" + (new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date())));
        Object result = methodProxy.invokeSuper(o, args);
        System.out.println("login end：" + (new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date())));
        return result;
    }
}
