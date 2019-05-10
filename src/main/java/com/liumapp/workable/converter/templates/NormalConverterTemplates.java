package com.liumapp.workable.converter.templates;

import com.liumapp.workable.converter.core.Converter;
import com.liumapp.workable.converter.exceptions.ConvertFailedException;

public abstract class NormalConverterTemplates implements Converter {

    private Converter converter;

    public NormalConverterTemplates(Converter converter) {
        this.converter = converter;
    }

    @Override
    public <T> T convert() throws ConvertFailedException {
        return null;
    }
}
