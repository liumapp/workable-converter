package com.liumapp.workable.converter.factory;

import com.liumapp.workable.converter.invoker.ObjectInvoker;
import com.liumapp.workable.converter.templates.SubClassFactoryTemplate;

/**
 * file CglibFactory.java
 * author liumapp
 * github https://github.com/liumapp
 * email liumapp.com@gmail.com
 * homepage http://www.liumapp.com
 * date 2019/4/29
 */
public class CglibFactory extends SubClassFactoryTemplate {

    /**
     * 创建具体cglib的enhancer对象
     */
    @Override
    public <T> T createInvokerProxy(ClassLoader classLoader, ObjectInvoker invoker, Class<?>... proxiedClasses) {
        
        return null;
    }
}
