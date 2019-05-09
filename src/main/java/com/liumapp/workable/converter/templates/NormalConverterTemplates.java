package com.liumapp.workable.converter.templates;

import com.liumapp.workable.converter.core.Converter;

public class NormalConverterTemplates implements Converter {

    private Converter converter;

    public NormalConverterTemplates(Converter converter) {
        this.converter = converter;
    }

    @Override
    public void convert() {
        converter.convert();
    }
}
