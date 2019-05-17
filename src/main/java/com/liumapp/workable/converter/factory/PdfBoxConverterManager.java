package com.liumapp.workable.converter.factory;

import com.liumapp.workable.converter.core.Converter;
import com.liumapp.workable.converter.strategies.PdfBoxConverter;

/**
 * file PdfBoxConverterManager.java
 * author liumapp
 * github https://github.com/liumapp
 * email liumapp.com@gmail.com
 * homepage http://www.liumapp.com
 * date 2019/5/17
 */
public class PdfBoxConverterManager extends AbstractConverterManager {

    private static class PdfBoxConverterManagerHolder {
        private static final PdfBoxConverterManager INSTANCE = new PdfBoxConverterManager();
    }

    private PdfBoxConverterManager() {
    }

    public static Converter getInstance () {
        return PdfBoxConverterManagerHolder.INSTANCE.getConverter();
    }

    @Override
    public Converter getConverter() {
        if (this.converter == null) {
            this.converter = new PdfBoxConverter();
        }
        return this.converter;
    }
}
