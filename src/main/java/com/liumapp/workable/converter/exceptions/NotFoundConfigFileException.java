package com.liumapp.workable.converter.exceptions;

/**
 * file NotFoundConfigFileException.java
 * author liumapp
 * github https://github.com/liumapp
 * email liumapp.com@gmail.com
 * homepage http://www.liumapp.com
 * date 2019/5/9
 */
public class NotFoundConfigFileException extends Exception {

    public NotFoundConfigFileException() {
        super();
    }

    public NotFoundConfigFileException(String message) {
        super(message);
    }

    public NotFoundConfigFileException(String message, Throwable cause) {
        super(message, cause);
    }

    public NotFoundConfigFileException(Throwable cause) {
        super(cause);
    }

    protected NotFoundConfigFileException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

}
