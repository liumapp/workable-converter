package com.liumapp.workable.converter.factory;

import com.liumapp.workable.converter.invoker.ObjectInvoker;
import org.junit.Test;

import java.lang.reflect.Method;

import static org.junit.Assert.*;

public class CglibProxyFactoryTest {

    @Test
    public void createInvokerProxy() {
        ProxyFactory proxyFactory = new CglibProxyFactory();
        ObjectInvoker logInvoker = new ObjectInvoker() {
            @Override
            public Object invoke(Object proxy, Method method, Object... arguments) throws Throwable {
                return null;
            }
        };
    }
}