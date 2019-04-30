package com.liumapp.workable.converter.filters;

import com.liumapp.workable.converter.utils.ProxyUtil;
import net.sf.cglib.proxy.CallbackFilter;

import java.lang.reflect.Method;

public class DefaultCglibProxyFactoryCallbackFilter implements CallbackFilter {
    @Override
    public int accept(Method method) {
        if (ProxyUtil.isEqualsMethod(method)) {
            return 1;
        }
        if (ProxyUtil.isHashCode(method)) {
            return 2;
        }
        return 0;
    }
}
