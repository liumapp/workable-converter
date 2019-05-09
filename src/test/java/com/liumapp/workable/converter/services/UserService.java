package com.liumapp.workable.converter.services;

import com.liumapp.workable.converter.beans.User;

/**
 * file UserService.java
 * author liumapp
 * github https://github.com/liumapp
 * email liumapp.com@gmail.com
 * homepage http://www.liumapp.com
 * date 2019/5/7
 */
public interface UserService {

    public boolean add(User user);

    public boolean delete(int id);

    public User get(int id);

}
