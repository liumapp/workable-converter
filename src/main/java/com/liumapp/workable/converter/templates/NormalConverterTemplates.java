package com.liumapp.workable.converter.templates;

import com.liumapp.workable.converter.core.Convert;

public abstract class NormalConverterTemplates implements Convert {

    private Convert convert;

    public NormalConverterTemplates(Convert convert) {
        this.convert = convert;
    }

    @Override
    public <T> T convert() {
        return convert.convert();
    }
}
