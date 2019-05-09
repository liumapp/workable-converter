package com.liumapp.workable.converter.services.impl;

import com.liumapp.workable.converter.beans.User;
import com.liumapp.workable.converter.beans.UserPool;
import com.liumapp.workable.converter.services.UserService;

/**
 * file UserServiceImpl.java
 * author liumapp
 * github https://github.com/liumapp
 * email liumapp.com@gmail.com
 * homepage http://www.liumapp.com
 * date 2019/5/7
 */
public class UserServiceImpl implements UserService {

    @Override
    public boolean add(User user) {
        UserPool.getInstance().put(user.getId(), user);
        return true;
    }

    @Override
    public boolean delete(int id) {
        UserPool.getInstance().remove(id);
        return true;
    }

    @Override
    public User get(int id) {
        return UserPool.getInstance().get(id);
    }

}
