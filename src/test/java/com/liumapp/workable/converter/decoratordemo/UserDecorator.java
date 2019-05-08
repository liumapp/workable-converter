package com.liumapp.workable.converter.decoratordemo;

import com.liumapp.workable.converter.beans.User;
import com.liumapp.workable.converter.services.UserService;

/**
 * file UserDecorator.java
 * author liumapp
 * github https://github.com/liumapp
 * email liumapp.com@gmail.com
 * homepage http://www.liumapp.com
 * date 2019/5/8
 */
public abstract class UserDecorator implements UserService {

    private UserService userService;

    public UserDecorator(UserService userService) {
        this.userService = userService;
    }


    @Override
    public boolean add(User user) {
        return userService.add(user);
    }

    @Override
    public boolean delete(int id) {
        return userService.delete(id);
    }

    @Override
    public User get(int id) {
        return userService.get(id);
    }
}
