package com.liumapp.workable.converter.factory;

import com.liumapp.workable.converter.filters.DefaultCglibProxyFactoryCallbackFilter;
import com.liumapp.workable.converter.handlers.EqualsHandler;
import com.liumapp.workable.converter.handlers.HashCodeHandler;
import com.liumapp.workable.converter.invoker.DefaultInvokerBridge;
import com.liumapp.workable.converter.invoker.ObjectInvoker;
import com.liumapp.workable.converter.templates.SubClassFactoryTemplate;
import net.sf.cglib.proxy.CallbackFilter;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.Callback;

import java.lang.reflect.Method;

/**
 * file CglibProxyFactory.java
 * author liumapp
 * github https://github.com/liumapp
 * email liumapp.com@gmail.com
 * homepage http://www.liumapp.com
 * date 2019/4/29
 */
public class CglibProxyFactory extends SubClassFactoryTemplate {

    /**
     * 创建具体cglib的enhancer对象
     */
    @Override
    public <T> T createInvokerProxy(ClassLoader classLoader, ObjectInvoker invoker, Class<?>... proxiedClasses) {
        Enhancer enhancer = new Enhancer();
        enhancer.setClassLoader(classLoader);
        enhancer.setInterfaces(toInterfaces(proxiedClasses));
        enhancer.setSuperclass(getSuperClass(proxiedClasses));
        enhancer.setCallbackFilter(new DefaultCglibProxyFactoryCallbackFilter());
        enhancer.setCallbacks(new Callback[] {
                new DefaultInvokerBridge(invoker),
                new EqualsHandler(),
                new HashCodeHandler()
        });
        @SuppressWarnings("unchecked")
        T result = (T) enhancer.create();
        return result;
    }

}
