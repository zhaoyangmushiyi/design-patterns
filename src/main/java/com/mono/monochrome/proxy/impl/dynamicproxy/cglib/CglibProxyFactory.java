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
public class CglibProxyFactory<T> implements MethodInterceptor {

    private final T target;

    public CglibProxyFactory(T target) {
        this.target = target;
    }

    public Object getProxyInstance() {
        // cglib工具类
        Enhancer enhancer = new Enhancer();
        // 设置父类
        enhancer.setSuperclass(this.target.getClass());
        // 设置回调函数
        enhancer.setCallback(this);

        return enhancer.create();
    }

    @Override
    public Object intercept(Object o, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
        System.out.println("login start：" + (new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date())));
        Object result = method.invoke(target, args);
        System.out.println("login end：" + (new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date())));
        return result;
    }
}
