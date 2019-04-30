package com.liumapp.workable.converter.factory;

import com.liumapp.workable.converter.invoker.ObjectInvoker;

/**
 * file ProxyFactory.java
 * author liumapp
 * github https://github.com/liumapp
 * email liumapp.com@gmail.com
 * homepage http://www.liumapp.com
 * date 2019/4/29
 */
public interface ProxyFactory {



    <T> T createInvokerProxy (ObjectInvoker invoker, Class<?>... proxiedClasses);

    <T> T createInvokerProxy (ClassLoader classLoader, ObjectInvoker invoker, Class<?>... proxiedClasses);

}
