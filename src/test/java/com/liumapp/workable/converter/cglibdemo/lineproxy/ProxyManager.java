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

    private Class<?> targetClass;

    private List<Proxy> proxyList;

    public ProxyManager(Class<?> targetClass, List<Proxy> proxyList) {
        this.targetClass = targetClass;
        this.proxyList = proxyList;
    }

    @SuppressWarnings("unchecked")
    public <T> T createProxy () {
        return (T) Enhancer.create(targetClass, new MethodInterceptor() {
            @Override
            public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                ProxyChain proxyChain = new ProxyChain(targetClass, o, method, objects, methodProxy, proxyList);
                proxyChain.doProxyChain();
                return proxyChain.getMethodResult();
            }
        });
    }
}
