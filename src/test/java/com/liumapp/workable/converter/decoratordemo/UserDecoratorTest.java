package com.liumapp.workable.converter.decoratordemo;

import com.liumapp.workable.converter.beans.RoleEnums;
import com.liumapp.workable.converter.beans.User;
import com.liumapp.workable.converter.beans.UserPool;
import com.liumapp.workable.converter.services.UserService;
import com.liumapp.workable.converter.services.impl.UserServiceImpl;
import org.junit.Test;

import java.util.HashMap;

import static org.junit.Assert.*;
/**
 * file UserDecoratorTest.java
 * author liumapp
 * github https://github.com/liumapp
 * email liumapp.com@gmail.com
 * homepage http://www.liumapp.com
 * date 2019/5/8
 */
public class UserDecoratorTest {

    @Test
    public void testAddVipAndGirlUserOnly () {
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

        UserService service = new AddVipUserOnly(new AddGirlUserOnly(new UserServiceImpl()));
        assertEquals(false, service.add(normalGirlUser));
        assertEquals(false, service.add(vipBoyUser));
        assertEquals(true, service.add(vipGirlUser));
        HashMap<Integer, User> userHashMap = UserPool.getInstance();
        assertEquals(1, userHashMap.size());

    }

}

