package com.liumapp.workable.converter.cglibdemo.lineproxy;

import java.lang.reflect.Method;

/**
 * file OnlyVipCanBeAddedProxy.java
 * author liumapp
 * github https://github.com/liumapp
 * email liumapp.com@gmail.com
 * homepage http://www.liumapp.com
 * date 2019/5/9
 */
public class OnlyVipCanBeAddedProxy extends DefaultProxyTemplate {

    @Override
    public void before(Class<?> cls, Method method, Object[] params) {
        super.before(cls, method, params);
    }

}
