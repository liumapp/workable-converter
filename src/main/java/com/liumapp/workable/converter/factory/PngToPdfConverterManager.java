package com.liumapp.workable.converter.factory;

import com.liumapp.workable.converter.core.Converter;
import com.liumapp.workable.converter.strategies.PngToPdfConverter;

/**
 * file PngToPdfConverterManager.java
 * author liumapp
 * github https://github.com/liumapp
 * email liumapp.com@gmail.com
 * homepage http://www.liumapp.com
 * date 2019/5/10
 */
public class PngToPdfConverterManager extends AbstractConverterManager {

    private static class PngToPdfConverterManagerHolder {
        private static final PngToPdfConverterManager INSTANCE = new PngToPdfConverterManager();
    }

    private PngToPdfConverterManager() {
    }

    @Deprecated
    public static synchronized Converter getInstance () {
        return PngToPdfConverterManagerHolder.INSTANCE.getConverter();
    }

    @Override
    public Converter getConverter() {
        if (this.converter == null) {
            this.converter = new PngToPdfConverter();
        }
        return this.converter;
    }
}
