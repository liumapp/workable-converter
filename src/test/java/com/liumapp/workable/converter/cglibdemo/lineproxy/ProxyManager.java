package com.liumapp.workable.converter.cglibdemo.lineproxy;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;
import java.util.List;

/**
 * file ProxyManager.java
 * author liumapp
 * github https://github.com/liumapp
 * email liumapp.com@gmail.com
 * homepage http://www.liumapp.com
 * date 2019/5/8
 */
public class ProxyManager {

    private static ProxyManager instance = null;

    private ProxyManager() {
    }

    public static ProxyManager getInstance() {
        if (instance == null) {
            instance = new ProxyManager();
        }
        return instance;
    }

    @SuppressWarnings("unchecked")
    public <T> T createProxy(final Class<?> targetClass, final List<Proxy> proxyList) {
        return (T) Enhancer.create(targetClass, (MethodInterceptor) (target, method, args, proxy) -> {
            ProxyChain proxyChain = new ProxyChain(targetClass, target, method, args, proxy, proxyList);
            return proxyChain.getMethodResult();
        });
    }
}
