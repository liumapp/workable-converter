package com.liumapp.workable.converter.exceptions;

/**
 * file NotFoundLibreofficeHome.java
 * author liumapp
 * github https://github.com/liumapp
 * email liumapp.com@gmail.com
 * homepage http://www.liumapp.com
 * date 2019/5/9
 */
public class NotFoundLibreofficeHome extends Exception {

    public NotFoundLibreofficeHome() {
        super();
    }

    public NotFoundLibreofficeHome(String message) {
        super(message);
    }

    public NotFoundLibreofficeHome(String message, Throwable cause) {
        super(message, cause);
    }

    public NotFoundLibreofficeHome(Throwable cause) {
        super(cause);
    }

    protected NotFoundLibreofficeHome(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
