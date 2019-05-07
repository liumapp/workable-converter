package com.liumapp.workable.converter.invoker;

import net.sf.cglib.proxy.InvocationHandler;

import java.io.Serializable;
import java.lang.reflect.Method;

/**
 * file DefaultInvokerBridge.java
 * author liumapp
 * github https://github.com/liumapp
 * email liumapp.com@gmail.com
 * homepage http://www.liumapp.com
 * date 2019/4/30
 */
public class DefaultInvokerBridge implements InvocationHandler, Serializable {

    private static final long serialVersionUID = -2445951530794450396L;

    private final ObjectInvoker original;

    public DefaultInvokerBridge(ObjectInvoker invoker) {
        this.original = invoker;
    }

    @Override
    public Object invoke(Object o, Method method, Object[] objects) throws Throwable {
        return original.invoke(o, method, objects);
    }
}
