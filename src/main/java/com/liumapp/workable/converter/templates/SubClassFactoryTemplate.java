package com.liumapp.workable.converter.templates;

import com.google.common.collect.Sets;
import com.liumapp.workable.converter.exceptions.ProxyFactoryException;

import java.io.Serializable;
import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;
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

    @Override
    public boolean canProxy(Class<?>... proxiedClasses) {
        try {
            getSuperClass(proxiedClasses);
            return true;
        } catch (ProxyFactoryException e) {
            // effective in java 不推荐使用这种写法（在exception的catch中进行逻辑的处理）
            // 后续有时间进行改造
            // todo
            return false;
        }
    }

    public static Class<?> getSuperClass (Class<?>[] proxiedClasses) {
        final Class<?>[] superClasses = toNonInterfaces(proxiedClasses);
        switch (superClasses.length) {
            case 0:
                return Object.class;
            case 1:
                Class<?> superClass = superClasses[0];
                if (Modifier.isFinal(superClass.getModifiers())) {
                    throw new ProxyFactoryException(
                            "Cannot proxy " + superClass.getName() + " as it is final"
                    );
                }
                if (!hasDefaultConstructor(superClass)) {
                    throw new ProxyFactoryException(
                            "Cannot proxy " + superClass.getName() + " as it has no visible default constructor."
                    );
                }
                return superClass;
            default:
                StringBuilder errorMessage = new StringBuilder("Canot proxy ");
                for (int i = 0; i < superClasses.length; i++) {
                    Class<?> cl = superClasses[i];
                    errorMessage.append(cl.getName());
                    if (i != superClasses.length - 1) {
                        errorMessage.append(", ");
                    }
                }
                errorMessage.append(" as multiple inheritance can not be allowed");
                throw new ProxyFactoryException(errorMessage.toString());
        }
    }

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

    private static Class<?>[] toNonInterfaces (Class<?>[] proxiedClasses) {
        Set<Class<?>> superClasses = Sets.newLinkedHashSet();
        for (Class<?> proxiedClass : proxiedClasses) {
            superClasses.add(proxiedClass);
        }

        return superClasses.toArray(new Class[superClasses.size()]);
    }

    private static boolean hasDefaultConstructor (Class<?> superClass) {
        final Constructor<?>[] declaredConstructors = superClass.getDeclaredConstructors();
        for (int i = 0; i < declaredConstructors.length; i++) {
            Constructor<?> constructor = declaredConstructors[i];
            if (constructor.getParameterTypes().length == 0 &&
                    (Modifier.isPublic(constructor.getModifiers()) || Modifier.isProtected(constructor.getModifiers()))) {
                return true;
            }
        }
        return false;
    }

}
