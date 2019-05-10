package com.liumapp.workable.converter.exceptions;

/**
 * file ConvertFailedException.java
 * author liumapp
 * github https://github.com/liumapp
 * email liumapp.com@gmail.com
 * homepage http://www.liumapp.com
 * date 2019/5/10
 */
public class ConvertFailedException extends Exception {
    public ConvertFailedException() {
        super();
    }

    public ConvertFailedException(String message) {
        super(message);
    }

    public ConvertFailedException(String message, Throwable cause) {
        super(message, cause);
    }

    public ConvertFailedException(Throwable cause) {
        super(cause);
    }

    protected ConvertFailedException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
