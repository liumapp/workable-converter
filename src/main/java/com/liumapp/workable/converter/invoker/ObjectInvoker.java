package com.liumapp.workable.converter.invoker;

import java.io.Serializable;
import java.lang.reflect.Method;

/**
 * file ObjectInvoker.java
 * author liumapp
 * github https://github.com/liumapp
 * email liumapp.com@gmail.com
 * homepage http://www.liumapp.com
 * date 2019/4/29
 */
public interface ObjectInvoker extends Serializable {

    Object invoke (Object proxy, Method method, Object... arguments) throws Throwable;

}
