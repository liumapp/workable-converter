package com.liumapp.workable.converter.factory;

import com.liumapp.workable.converter.core.Converter;
import com.liumapp.workable.converter.core.Manager;
import com.liumapp.workable.converter.strategies.CommonConverter;

/**
 * file CommonConverterManager.java
 * author liumapp
 * github https://github.com/liumapp
 * email liumapp.com@gmail.com
 * homepage http://www.liumapp.com
 * date 2019/5/14
 */
public class CommonConverterManager extends AbstractConverterManager {

    private CommonConverter converter;

    private static class CommonConverterManagerHolder {
        private static final CommonConverterManager INSTANCE = new CommonConverterManager();
    }

    private CommonConverterManager() {
    }

    public static Converter getInstance () {
        return CommonConverterManagerHolder.INSTANCE.getConverter();
    }

    @Override
    public Converter getConverter() {
        if (this.converter == null) {
            this.converter = new CommonConverter();
        }
        return this.converter;
    }
}
