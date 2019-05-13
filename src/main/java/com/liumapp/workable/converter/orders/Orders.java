package com.liumapp.workable.converter.orders;

import com.liumapp.workable.converter.core.ConsoleOrder;

/**
 * file Orders.java
 * author liumapp
 * github https://github.com/liumapp
 * email liumapp.com@gmail.com
 * homepage http://www.liumapp.com
 * date 2019/5/13
 */
public enum Orders implements ConsoleOrder {
    ;

    Orders(String order) {
        this.order = order;
    }

    public String getOrder() {
        return order;
    }

    private String order;

}
