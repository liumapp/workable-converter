package com.liumapp.workable.converter.exceptions;

/**
 * file UnsupportedParameterException.java
 * author liumapp
 * github https://github.com/liumapp
 * email liumapp.com@gmail.com
 * homepage http://www.liumapp.com
 * date 2019/5/16
 */
public class UnsupportedConverterParameterException extends RuntimeException {
    public UnsupportedConverterParameterException() {
        super();
    }

    public UnsupportedConverterParameterException(String message) {
        super(message);
    }

    public UnsupportedConverterParameterException(String message, Throwable cause) {
        super(message, cause);
    }

    public UnsupportedConverterParameterException(Throwable cause) {
        super(cause);
    }

    protected UnsupportedConverterParameterException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
