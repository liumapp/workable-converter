package com.liumapp.workable.converter.cglibdemo.lineproxy;

import com.liumapp.workable.converter.beans.RoleEnums;
import com.liumapp.workable.converter.beans.User;
import com.liumapp.workable.converter.services.impl.UserServiceImpl;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * file ProxyLineTest.java
 * author liumapp
 * github https://github.com/liumapp
 * email liumapp.com@gmail.com
 * homepage http://www.liumapp.com
 * date 2019/5/9
 */
public class ProxyLineTest {

    @Test
    public void testLineProxy () {
        List<Proxy> proxyList = new ArrayList<>();
        proxyList.add(new OnlyGirlCanBeAddedProxy());
        proxyList.add(new OnlyVipCanBeAddedProxy());
        proxyList.add(new LoggerProxy());

        UserServiceImpl userProxies = ProxyManager.getInstance().createProxy(UserServiceImpl.class, proxyList);

        User normalGirlUser = new User();
        normalGirlUser.setName("mary");
        normalGirlUser.setSex("girl");
        normalGirlUser.setRole(RoleEnums.FREE_USER);

        User vipBoyUser = new User();
        vipBoyUser.setName("jony");
        vipBoyUser.setSex("boy");
        vipBoyUser.setRole(RoleEnums.VIP_USER);

        User vipGirlUser = new User();
        vipGirlUser.setName("alisa");
        vipGirlUser.setSex("girl");
        vipGirlUser.setRole(RoleEnums.SUPER_VIP_USER);

        assertEquals(false, userProxies.add(normalGirlUser));
        assertEquals(false, userProxies.add(vipBoyUser));
        assertEquals(true, userProxies.add(vipGirlUser));
    }


}
