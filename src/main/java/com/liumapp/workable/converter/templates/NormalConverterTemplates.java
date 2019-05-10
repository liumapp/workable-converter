package com.liumapp.workable.converter.templates;

import com.liumapp.workable.converter.core.Converter;

public abstract class NormalConverterTemplates implements Converter {

    private Converter converter;

    public NormalConverterTemplates(Converter converter) {
        this.converter = converter;
    }

    @Override
    public <T> T convert() {
        return converter.convert();
    }
}
