package com.liumapp.workable.converter.templates;

import com.google.common.collect.Sets;

import java.io.Serializable;
import java.util.Set;

/**
 * file SubClassFactoryTemplate.java
 * author liumapp
 * github https://github.com/liumapp
 * email liumapp.com@gmail.com
 * homepage http://www.liumapp.com
 * date 2019/4/29
 */
public abstract class SubClassFactoryTemplate extends FactoryTemplate {

    /**
     * 必须是接口才可以代理
     */
    protected static Class<?>[] toInterfaces (Class<?>[] proxiedClasses) {
        Set<Class<?>> interfaces = Sets.newLinkedHashSet();
        for (Class<?> proxiedClass : proxiedClasses) {
            if (proxiedClass.isInterface()) {
                interfaces.add(proxiedClass);
            }
        }

        interfaces.add(Serializable.class);
        return interfaces.toArray(new Class[interfaces.size()]);
    }

}
