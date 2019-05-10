package com.liumapp.workable.converter.factory;

import com.liumapp.workable.converter.core.Converter;

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

    public static Converter getInstance () {
        return PngToPdfConverterManagerHolder.INSTANCE.getConverter();
    }

    @Override
    public Converter getConverter() {
        return null;
    }
}
