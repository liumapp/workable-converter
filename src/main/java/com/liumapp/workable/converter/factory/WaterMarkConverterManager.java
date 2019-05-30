package com.liumapp.workable.converter.factory;

import com.liumapp.workable.converter.core.Converter;
import com.liumapp.workable.converter.strategies.PdfBoxConverter;
import com.liumapp.workable.converter.strategies.WaterMarkConverter;

/**
 * file WaterMarkConverterManager.java
 * author liumapp
 * github https://github.com/liumapp
 * email liumapp.com@gmail.com
 * homepage http://www.liumapp.com
 * date 2019/5/30
 */
public class WaterMarkConverterManager extends AbstractConverterManager {

    private static class WaterMarkConverterManagerHolder {
        private static final WaterMarkConverterManager INSTANCE = new WaterMarkConverterManager();
    }

    private WaterMarkConverterManager() {
    }

    public static synchronized Converter getInstance () {
        return WaterMarkConverterManager.WaterMarkConverterManagerHolder.INSTANCE.getConverter();
    }

    @Override
    public Converter getConverter() {
        if (this.converter == null) {
            this.converter = new WaterMarkConverter();
        }
        return this.converter;
    }
}
