package com.liumapp.workable.converter;

/**
 * file ProxyFactory.java
 * author liumapp
 * github https://github.com/liumapp
 * email liumapp.com@gmail.com
 * homepage http://www.liumapp.com
 * date 2019/4/29
 */
public interface ProxyFactory {

    <T> T createInvokerProxy();

}
