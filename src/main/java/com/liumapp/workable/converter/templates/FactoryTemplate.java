package com.liumapp.workable.converter.templates;

import com.liumapp.workable.converter.factory.ProxyFactory;
import com.liumapp.workable.converter.invoker.ObjectInvoker;

/**
 * file FactoryTemplate.java
 * author liumapp
 * github https://github.com/liumapp
 * email liumapp.com@gmail.com
 * homepage http://www.liumapp.com
 * date 2019/4/29
 */
public abstract class FactoryTemplate implements ProxyFactory {

    @Override
    public <T> T createInvokerProxy(ObjectInvoker invoker, Class<?>... proxiedClasses) {
        return createInvokerProxy(Thread.currentThread().getContextClassLoader(), invoker, proxiedClasses);
    }
}
