package com.liumapp.workable.converter.filters;

import net.sf.cglib.proxy.CallbackFilter;

import java.lang.reflect.Method;

public class DefaultCglibProxyFactoryCallbackFilter implements CallbackFilter {
    @Override
    public int accept(Method method) {
        return 0;
    }
}
