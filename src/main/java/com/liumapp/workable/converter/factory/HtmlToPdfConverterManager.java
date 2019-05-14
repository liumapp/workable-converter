package com.liumapp.workable.converter.factory;

import com.liumapp.workable.converter.core.Converter;
import com.liumapp.workable.converter.strategies.HtmlToPdfConverter;

/**
 * file HtmlToPdfConverterManager.java
 * author liumapp
 * github https://github.com/liumapp
 * email liumapp.com@gmail.com
 * homepage http://www.liumapp.com
 * date 2019/5/10
 */
public class HtmlToPdfConverterManager extends AbstractConverterManager {

    private static class HtmlToPdfConverterManagerHolder {
        private static final HtmlToPdfConverterManager INSTANCE = new HtmlToPdfConverterManager();
    }

    private HtmlToPdfConverterManager() {
    }

    @Deprecated
    public static Converter getInstance () {
        return HtmlToPdfConverterManagerHolder.INSTANCE.getConverter();
    }

    @Override
    public Converter getConverter() {
        if (this.converter == null) {
            this.converter = new HtmlToPdfConverter();
        }
        return this.converter;
    }
}
