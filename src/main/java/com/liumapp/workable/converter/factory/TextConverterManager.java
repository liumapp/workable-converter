package com.liumapp.workable.converter.factory;

import com.liumapp.workable.converter.core.Converter;
import com.liumapp.workable.converter.strategies.TextConverter;

public class TextConverterManager extends AbstractConverterManager {

    private static class TemplateConverterManagerHolder {
        private static final TextConverterManager INSTANCE = new TextConverterManager();
    }

    private TextConverterManager() {
    }

    public static synchronized Converter getInstance () {
        return TextConverterManager.TemplateConverterManagerHolder.INSTANCE.getConverter();
    }

    @Override
    public Converter getConverter() {
        if (this.converter == null) {
            this.converter = new TextConverter();
        }
        return this.converter;
    }
}
