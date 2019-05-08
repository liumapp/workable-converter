package com.liumapp.workable.converter.decoratordemo;

import com.liumapp.workable.converter.beans.User;
import com.liumapp.workable.converter.services.UserService;

/**
 * file AddGirlUserOnly.java
 * author liumapp
 * github https://github.com/liumapp
 * email liumapp.com@gmail.com
 * homepage http://www.liumapp.com
 * date 2019/5/8
 */
public class AddGirlUserOnly extends UserDecorator {

    public AddGirlUserOnly(UserService userService) {
        super(userService);
    }

    @Override
    public boolean add(User user) {
        if (check(user.getSex())) {
            return super.add(user);
        }
        return false;
    }

    private boolean check (String sex) {
        if (sex != null && sex.equals("girl")) {
            return true;
        }
        return false;
    }

}
