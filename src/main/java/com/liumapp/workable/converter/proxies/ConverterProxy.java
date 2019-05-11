package com.liumapp.workable.converter.proxies;

import com.liumapp.workable.converter.core.Proxy;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Method;
import java.time.LocalDateTime;

/**
 * file ConverterProxy.java
 * author liumapp
 * github https://github.com/liumapp
 * email liumapp.com@gmail.com
 * homepage http://www.liumapp.com
 * date 2019/5/10
 */
public class ConverterProxy implements Proxy, MethodInterceptor {

    private static Logger LOGGER = LoggerFactory.getLogger(ConverterProxy.class);

    private static ConverterProxy converterProxy = new ConverterProxy();

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        before(method);
        Object result = methodProxy.invokeSuper(o, objects);
        after(method);
        return result;
    }

    private static class ConverterProxyHolder {
        private static final ConverterProxy INSTANCE = new ConverterProxy();
    }

    private ConverterProxy() {
    }

    public static ConverterProxy getInstance() {
        return ConverterProxyHolder.INSTANCE;
    }

    public <T> T getProxy (Class<T> clz) {
        return (T) Enhancer.create(clz, this);
    }

    protected void before (Method method) {
        LOGGER.info("the method : " + method.getName() + " begin at " + LocalDateTime.now());
    }

    protected void after (Method method) {
        LOGGER.info("the method : " + method.getName() + " ended at " + LocalDateTime.now());
    }


}
