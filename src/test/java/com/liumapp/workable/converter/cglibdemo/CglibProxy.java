package com.liumapp.workable.converter.cglibdemo;

import com.liumapp.workable.converter.beans.User;
import com.liumapp.workable.converter.services.UserService;
import com.liumapp.workable.converter.services.impl.UserServiceImpl;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Method;
import static org.junit.Assert.*;

/**
 * file CglibProxy.java
 * author liumapp
 * github https://github.com/liumapp
 * email liumapp.com@gmail.com
 * homepage http://www.liumapp.com
 * date 2019/5/7
 */
public class CglibProxy implements MethodInterceptor {

    private static Logger logger = LoggerFactory.getLogger(CglibProxy.class);

    public <T> T getProxy(Class<T> cls) {
        return (T) Enhancer.create(cls, this);
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        before();
        Object result = methodProxy.invokeSuper(o, objects);
        after();
        return result;
    }

    public void before () {
        logger.info("before method begin...");
    }

    public void after () {
        logger.info("after method done...");
    }

    public static void main (String[] args) {
        CglibProxy cglibProxy = new CglibProxy();
        UserService userService = cglibProxy.getProxy(UserServiceImpl.class);
        User user = new User();
        user.setSex("girl");
        user.setName("mary");
        user.setId(2);
        user.setAge(15);
        userService.add(user);
        User mary = userService.get(2);
        assertEquals("girl", mary.getSex());
        assertEquals("mary", mary.getName());
    }
}
