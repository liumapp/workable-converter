package com.liumapp.workable.converter.handlers;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.io.Serializable;
import java.lang.reflect.Method;

/**
 * file EqualsHandler.java
 * author liumapp
 * github https://github.com/liumapp
 * email liumapp.com@gmail.com
 * homepage http://www.liumapp.com
 * date 2019/4/30
 */
public abstract class EqualsHandler implements MethodInterceptor, Serializable {

    private static final long serialVersionUID = -1118031901763468558L;

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        return Boolean.valueOf(o == objects[0]);
    }
}
