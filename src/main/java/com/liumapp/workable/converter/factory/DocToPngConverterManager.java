package com.liumapp.workable.converter.factory;

import com.liumapp.workable.converter.core.Converter;
import com.liumapp.workable.converter.strategies.DocToPngConverter;

/**
 * file DocToPngConverterManager.java
 * author liumapp
 * github https://github.com/liumapp
 * email liumapp.com@gmail.com
 * homepage http://www.liumapp.com
 * date 2019/5/10
 */
public class DocToPngConverterManager extends AbstractConverterManager {

    private static class DocToPngConverterManagerHodler {
        private static final DocToPngConverterManager INSTANCE = new DocToPngConverterManager();
    }

    private DocToPngConverterManager() {
    }

    @Deprecated
    public static Converter getInstance () {
        return DocToPngConverterManagerHodler.INSTANCE.getConverter();
    }

    @Override
    public Converter getConverter() {
        if (this.converter == null) {
            this.converter = new DocToPngConverter();
        }
        return this.converter;
    }
}
