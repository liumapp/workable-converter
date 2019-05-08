package com.liumapp.workable.converter.decoratordemo;

import com.liumapp.workable.converter.beans.User;
import com.liumapp.workable.converter.services.UserService;

/**
 * 执行get之前，需要校验口令
 * file UserWithToken.java
 * author liumapp
 * github https://github.com/liumapp
 * email liumapp.com@gmail.com
 * homepage http://www.liumapp.com
 * date 2019/5/8
 */
public class UserWithToken extends UserDecorator {

    public UserWithToken(UserService userService) {
        super(userService);
    }

    @Override
    public boolean add(User user) {
        return super.add(user);
    }

    @Override
    public boolean delete(int id) {
        return super.delete(id);
    }

    @Override
    public User get(int id) {
        return super.get(id);
    }



}
