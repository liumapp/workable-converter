package com.liumapp.workable.converter.templates;

import com.liumapp.workable.converter.core.Converter;
import com.liumapp.workable.converter.core.Parameter;
import com.liumapp.workable.converter.core.Templates;
import com.liumapp.workable.converter.exceptions.ConvertFailedException;
import com.liumapp.workable.converter.strategies.ConverterStrategy;

/**
 * file ConverterStrategyTemplates.java
 * author liumapp
 * github https://github.com/liumapp
 * email liumapp.com@gmail.com
 * homepage http://www.liumapp.com
 * @Date 2019/07/15 10:49
 */
public abstract class ConverterStrategyTemplates extends ConverterStrategy implements Templates, Converter {

    protected ConverterStrategy converter;

    public ConverterStrategyTemplates(Converter converterStrategy) {
        this.converter = (ConverterStrategy) converterStrategy;
    }

    @Override
    public boolean convert(Parameter require) throws ConvertFailedException {
        return converter.convert(require);
    }

}
