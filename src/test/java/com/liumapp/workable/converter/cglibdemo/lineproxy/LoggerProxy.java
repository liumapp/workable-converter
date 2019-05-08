package com.liumapp.workable.converter.cglibdemo.lineproxy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Method;

/**
 * file LoggerProxy.java
 * author liumapp
 * github https://github.com/liumapp
 * email liumapp.com@gmail.com
 * homepage http://www.liumapp.com
 * date 2019/5/8
 */
public class LoggerProxy extends DefaultProxyTemplate {

    private static Logger logger = LoggerFactory.getLogger(LoggerFactory.class);

    @Override
    public void begin() {
        
        super.begin();
    }

    @Override
    public void before(Class<?> cls, Method method, Object[] params) {
        super.before(cls, method, params);
    }

    @Override
    public void after(Class<?> cls, Method method, Object[] params) {
        super.after(cls, method, params);
    }

    @Override
    public void end() {
        super.end();
    }
}
