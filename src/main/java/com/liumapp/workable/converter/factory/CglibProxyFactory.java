package com.liumapp.workable.converter.factory;

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

    private static final CallbackFilter CALLBACK_FILTERk =

    /**
     * 创建具体cglib的enhancer对象
     */
    @Override
    public <T> T createInvokerProxy(ClassLoader classLoader, ObjectInvoker invoker, Class<?>... proxiedClasses) {
        Enhancer enhancer = new Enhancer();
        enhancer.setClassLoader(classLoader);
        enhancer.setInterfaces(toInterfaces(proxiedClasses));
        enhancer.setSuperclass(getSuperClass(proxiedClasses));
        enhancer.setCallbackFilter();
        enhancer.setCallbacks(new Callback[] {
                new DefaultInvokerBridge(invoker)
        });
        return null;
    }

    private static class CglibProxyFactoryCallBackFilter implements CallbackFilter {
        @Override
        public int accept(Method method) {
            if ()
        }
    }


}
