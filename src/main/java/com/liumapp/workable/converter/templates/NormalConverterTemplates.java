package com.liumapp.workable.converter.templates;

import com.liumapp.workable.converter.core.Converter;
import com.liumapp.workable.converter.core.Parameter;
import com.liumapp.workable.converter.core.Templates;
import com.liumapp.workable.converter.exceptions.ConvertFailedException;

/**
 * file NormalConverterTemplates.java
 * author liumapp
 * github https://github.com/liumapp
 * email liumapp.com@gmail.com
 * homepage http://www.liumapp.com
 * date 2019/5/10
 */
public abstract class NormalConverterTemplates implements Converter, Templates {

    private Converter converter;

    public NormalConverterTemplates(Converter converter) {
        this.converter = converter;
    }

    @Override
    public <T> T convert(Parameter require) throws ConvertFailedException {
        return converter.convert(require);
    }

}
