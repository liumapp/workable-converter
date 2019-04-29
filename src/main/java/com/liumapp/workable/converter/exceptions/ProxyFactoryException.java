package com.liumapp.workable.converter.exceptions;

/**
 * file ProxyFactoryException.java
 * author liumapp
 * github https://github.com/liumapp
 * email liumapp.com@gmail.com
 * homepage http://www.liumapp.com
 * date 2019/4/29
 */
public class ProxyFactoryException extends RuntimeException {

    private static final long serialVersionUID = -4802042115013648361L;

    public ProxyFactoryException() {
    }

    public ProxyFactoryException(String message) {
        super(message);
    }

    public ProxyFactoryException(String message, Throwable cause) {
        super(message, cause);
    }

    public ProxyFactoryException(Throwable cause) {
        super(cause);
    }

    public ProxyFactoryException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
