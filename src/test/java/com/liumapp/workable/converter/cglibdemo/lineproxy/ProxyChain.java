package com.liumapp.workable.converter.cglibdemo.lineproxy;

import lombok.Data;
import net.sf.cglib.proxy.MethodProxy;
import org.junit.Test;

import java.lang.reflect.Method;
import java.util.List;

/**
 * file ProxyChain.java
 * author liumapp
 * github https://github.com/liumapp
 * email liumapp.com@gmail.com
 * homepage http://www.liumapp.com
 * date 2019/5/8
 */
public class ProxyChain {

    private List<Proxy> proxyList;

    private int currentProxyIndex = 0;

    private Class<?> targetClass;

    private Object targetObject;

    private Method targetMethod;

    private Object[] methodParams;

    private MethodProxy methodProxy;

    private Object methodResult;

    public ProxyChain(Class<?> targetClass, Object targetObject, Method targetMethod, Object[] methodParams, MethodProxy methodProxy, Object methodResult) {
        this.targetClass = targetClass;
        this.targetObject = targetObject;
        this.targetMethod = targetMethod;
        this.methodParams = methodParams;
        this.methodProxy = methodProxy;
        this.methodResult = methodResult;
    }

    public List<Proxy> getProxyList() {
        return proxyList;
    }

    public int getCurrentProxyIndex() {
        return currentProxyIndex;
    }

    public Class<?> getTargetClass() {
        return targetClass;
    }

    public Object getTargetObject() {
        return targetObject;
    }

    public Method getTargetMethod() {
        return targetMethod;
    }

    public Object[] getMethodParams() {
        return methodParams;
    }

    public MethodProxy getMethodProxy() {
        return methodProxy;
    }

    public Object getMethodResult() {
        return methodResult;
    }

    public void doProxyChain () {
        if (currentProxyIndex < proxyList.size()) {
            proxyList.get(currentProxyIndex++).doProxy(this);
        } else {
            try {
                methodResult = methodProxy.invokeSuper(targetObject, methodParams);
            } catch (Throwable throwable) {
                throw new RuntimeException(throwable);
            }
        }
    }
}
