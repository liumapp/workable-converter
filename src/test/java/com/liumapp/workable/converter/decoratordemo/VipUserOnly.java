package com.liumapp.workable.converter.decoratordemo;

import com.liumapp.workable.converter.beans.RoleEnums;
import com.liumapp.workable.converter.beans.User;
import com.liumapp.workable.converter.services.UserService;

/**
 * 执行get之前，需要校验口令
 * file VipUserOnly.java
 * author liumapp
 * github https://github.com/liumapp
 * email liumapp.com@gmail.com
 * homepage http://www.liumapp.com
 * date 2019/5/8
 */
public class VipUserOnly extends UserDecorator {

    public VipUserOnly(UserService userService) {
        super(userService);
    }

    @Override
    public boolean add(User user) {
        if (this.check(user.getRole())) {
            return super.add(user);
        } else {
            return false;
        }

    }

    @Override
    public boolean delete(int id) {
        return super.delete(id);
    }

    @Override
    public User get(int id) {
        return super.get(id);
    }

    public boolean check (RoleEnums role) {
        if (role.getRole() != null && !role.getRole().equals(RoleEnums.FREE_USER.getRole()) && role.getRole().length() != 0) {
            return true;
        }
        return false;
    }

}
