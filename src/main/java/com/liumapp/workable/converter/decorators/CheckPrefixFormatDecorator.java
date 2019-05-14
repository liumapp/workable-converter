package com.liumapp.workable.converter.decorators;

import com.liumapp.workable.converter.config.ConvertRequire;
import com.liumapp.workable.converter.core.Converter;
import com.liumapp.workable.converter.core.Parameter;
import com.liumapp.workable.converter.exceptions.ConvertFailedException;
import com.liumapp.workable.converter.templates.NormalConverterTemplates;
import org.jodconverter.JodConverter;

/**
 * file CheckPrefixFormatDecorator.java
 * author liumapp
 * github https://github.com/liumapp
 * email liumapp.com@gmail.com
 * homepage http://www.liumapp.com
 * date 2019/5/14
 */
public class CheckPrefixFormatDecorator extends NormalConverterTemplates {

    public CheckPrefixFormatDecorator(Converter converter) {
        super(converter);
    }

    @Override
    public boolean convert(Parameter require) throws ConvertFailedException {
        ConvertRequire convertRequire = (ConvertRequire) require;
        if (convertRequire.getSrcFormat() == null || convertRequire.getDestFormat() == null) {
            // todo
        }
        return super.convert(require);
    }


}
