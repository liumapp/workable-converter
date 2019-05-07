package com.liumapp.workable.converter.factory;

import com.liumapp.workable.converter.beans.User;
import com.liumapp.workable.converter.invoker.ObjectInvoker;
import com.liumapp.workable.converter.services.UserService;
import com.liumapp.workable.converter.services.impl.UserServiceImpl;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Method;

import static org.junit.Assert.*;

/**
 * file CglibProxyFactoryTest.java
 * author liumapp
 * github https://github.com/liumapp
 * email liumapp.com@gmail.com
 * homepage http://www.liumapp.com
 * date 2019/5/7
 */
public class CglibProxyFactoryTest {

    private static Logger logger = LoggerFactory.getLogger(CglibProxyFactoryTest.class);

    @Test
    public void createInvokerProxy() {
        ProxyFactory proxyFactory = new CglibProxyFactory();
        ObjectInvoker logInvoker = new ObjectInvoker() {
            @Override
            public Object invoke(Object proxy, Method method, Object... arguments) throws Throwable {
                logger.info("the proxy has called " + method + " with arguments :" + arguments.toString());
                return arguments[0];
            }
        };
        UserService service = proxyFactory.createInvokerProxy(logInvoker, UserService.class);
        User user = new User();
        user.setId(1);
        user.setAge(19);
        user.setName("bonny");
        user.setSex("boy");
        service.add(user);
        User bonny = service.get(1);
        assertEquals("bonny", bonny.getName());
        assertEquals("boy", bonny.getSex());
        assertEquals(19, bonny.getAge());
    }
}