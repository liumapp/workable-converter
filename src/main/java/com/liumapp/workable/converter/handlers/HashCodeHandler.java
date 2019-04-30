package com.liumapp.workable.converter.handlers;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.io.Serializable;
import java.lang.reflect.Method;

/**
 * file HashCodeHandler.java
 * author liumapp
 * github https://github.com/liumapp
 * email liumapp.com@gmail.com
 * homepage http://www.liumapp.com
 * date 2019/4/30
 */
public class HashCodeHandler implements MethodInterceptor, Serializable {

    private static final long serialVersionUID = -4472787665047197669L;

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        return Integer.valueOf(System.identityHashCode(o));
    }

}
