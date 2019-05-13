package com.liumapp.workable.converter.demo;

import com.artofsolving.jodconverter.openoffice.connection.OpenOfficeConnection;
import com.artofsolving.jodconverter.openoffice.connection.SocketOpenOfficeConnection;

import java.net.ConnectException;

/**
 * file OpenOfficeConvertDemo.java
 * author liumapp
 * github https://github.com/liumapp
 * email liumapp.com@gmail.com
 * homepage http://www.liumapp.com
 * date 2019/5/13
 */
public class OpenOfficeConvertDemo {

    public static void main (String[] args) {
        OpenOfficeConnection connection = new SocketOpenOfficeConnection(8100);
        try {
            connection.connect();

        } catch (ConnectException e) {
            e.printStackTrace();
        }
    }

}
