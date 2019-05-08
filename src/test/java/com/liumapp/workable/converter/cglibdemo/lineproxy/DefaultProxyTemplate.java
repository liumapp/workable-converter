package com.liumapp.workable.converter.cglibdemo.lineproxy;

import java.lang.reflect.Method;

/**
 * file DefaultProxyTemplate.java
 * author liumapp
 * github https://github.com/liumapp
 * email liumapp.com@gmail.com
 * homepage http://www.liumapp.com
 * date 2019/5/8
 */
public class DefaultProxyTemplate implements Proxy {

    @Override
    public void doProxy(ProxyChain proxyChain) {
        Class<?> cls = proxyChain.getTargetClass();
        Method method = proxyChain.getTargetMethod();
        Object[] params = proxyChain.getMethodParams();

        begin(cls);
        try {
            if (filter(cls, method, params)) {
                before(cls, method, params);
                proxyChain.doProxyChain();
                after(cls, method, params);
            } else {
                proxyChain.doProxyChain();
            }
        } catch (Throwable e) {
            error(cls, method, params, e);
        } finally {
            end(cls);
        }
    }

    public void begin(Class<?> cls) {
    }

    public boolean filter(Class<?> cls, Method method, Object[] params) {
        return true;
    }

    public void before(Class<?> cls, Method method, Object[] params) {
    }

    public void after(Class<?> cls, Method method, Object[] params) {
    }

    public void error(Class<?> cls, Method method, Object[] params, Throwable e) {
    }

    public void end(Class<?> cls) {
    }

}
