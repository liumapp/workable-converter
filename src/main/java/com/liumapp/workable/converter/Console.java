package com.liumapp.workable.converter;

import com.liumapp.workable.converter.orders.Orders;
import org.beryx.textio.TextIO;
import org.beryx.textio.TextIoFactory;

/**
 * file Console.java
 * author liumapp
 * github https://github.com/liumapp
 * email liumapp.com@gmail.com
 * homepage http://www.liumapp.com
 * date 2019/5/13
 */
public class Console {

    public static TextIO textIO;

    public static void main (String[] args) {
        textIO = TextIoFactory.getTextIO();
        textIO.getTextTerminal().getProperties().setPaneWidth(1280);
        textIO.getTextTerminal().getProperties().setPaneHeight(960);
        showPrimaryMenu();
    }

    private static void showPrimaryMenu () {
        Orders orders = textIO.newEnumInputReader(Orders.class)
                .read("choice your order...");
        handOrder(orders);
    }

    private static void handOrder (Orders orders) {
//        switch (orders)
        showPrimaryMenu();
    }

}
