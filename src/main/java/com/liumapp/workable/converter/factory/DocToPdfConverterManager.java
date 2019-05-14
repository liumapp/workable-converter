package com.liumapp.workable.converter.factory;

import com.liumapp.workable.converter.core.Converter;
import com.liumapp.workable.converter.strategies.DocToPdfConverter;

/**
 * file DocToPdfConverterManager.java
 * author liumapp
 * github https://github.com/liumapp
 * email liumapp.com@gmail.com
 * homepage http://www.liumapp.com
 * date 2019/5/10
 */
public class DocToPdfConverterManager extends AbstractConverterManager {

    private static class DocToPdfConverterManagerHolder {
        private static final DocToPdfConverterManager INSTANCE = new DocToPdfConverterManager();
    }

    private DocToPdfConverterManager() {

    }

    @Deprecated
    public static Converter getInstance () {
        return DocToPdfConverterManagerHolder.INSTANCE.getConverter();
    }

    @Override
    public Converter getConverter() {
        if (this.converter == null) {
            this.converter = new DocToPdfConverter();
        }
        return this.converter;
    }

}
