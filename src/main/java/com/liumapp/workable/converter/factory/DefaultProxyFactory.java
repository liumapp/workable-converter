package com.liumapp.workable.converter.factory;

import com.liumapp.workable.converter.invoker.ObjectInvoker;

import java.util.ServiceLoader;

/**
 * file DefaultProxyFactory.java
 * author liumapp
 * github https://github.com/liumapp
 * email liumapp.com@gmail.com
 * homepage http://www.liumapp.com
 * date 2019/4/30
 */
public class DefaultProxyFactory implements ProxyFactory {

    public static final DefaultProxyFactory INSTANCE = new DefaultProxyFactory();

    private static final ServiceLoader<ProxyFactory> SERVICES = ServiceLoader.load(ProxyFactory.class);

    @Override
    public <T> T createInvokerProxy(ObjectInvoker invoker, Class<?>... proxiedClasses) {
        @SuppressWarnings("unchecked")
        T result = (T)
        return null;
    }

    @Override
    public <T> T createInvokerProxy(ClassLoader classLoader, ObjectInvoker invoker, Class<?>... proxiedClasses) {
        return null;
    }

    private ProxyFactory getCapableProxyFactory (Class<?>... proxiedClasses) {
        for (ProxyFactory proxyFactory : SERVICES) {
//            if (proxyFactory.c)
        }
    }
}
