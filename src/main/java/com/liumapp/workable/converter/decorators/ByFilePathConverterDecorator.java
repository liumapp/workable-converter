package com.liumapp.workable.converter.decorators;

import com.liumapp.workable.converter.core.Converter;
import com.liumapp.workable.converter.core.Parameter;
import com.liumapp.workable.converter.exceptions.ConvertFailedException;
import com.liumapp.workable.converter.templates.NormalConverterTemplates;

/**
 * file ByFilePathConverter.java
 * author liumapp
 * github https://github.com/liumapp
 * email liumapp.com@gmail.com
 * homepage http://www.liumapp.com
 * date 2019/5/11
 */
public class ByFilePathConverterDecorator extends NormalConverterTemplates {

    public ByFilePathConverterDecorator(Converter converter) {
        super(converter);
    }

    @Override
    public <T> T convert(Parameter require) throws ConvertFailedException {
        return super.convert(require);
    }

}
