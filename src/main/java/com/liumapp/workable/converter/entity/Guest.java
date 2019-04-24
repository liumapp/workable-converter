package com.liumapp.workable.converter.entity;

import org.springframework.stereotype.Component;

/**
 * Created by liumapp on 9/28/17.
 * E-mail:liumapp.com@gmail.com
 * home-page:http://www.liumapp.com
 */
@Component
public class Guest {

    private String name;

    private String sex;

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public Guest(String sex) {
        this.sex = sex;
    }
}
