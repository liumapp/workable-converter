package com.liumapp.workable.converter.strategies;


import com.liumapp.workable.converter.config.ConvertRequire;
import com.liumapp.workable.converter.core.Parameter;
import com.liumapp.workable.converter.exceptions.ConvertFailedException;

/**
 * file DocToPdfConverter.java
 * author liumapp
 * github https://github.com/liumapp
 * email liumapp.com@gmail.com
 * homepage http://www.liumapp.com
 * date 2019/5/13
 */
public class DocToPdfConverter extends ConverterStrategy {

    @Override
    public <T> T convert(Parameter require) throws ConvertFailedException {
        return convertAccordingRequire( (ConvertRequire) require);
    }

    private <T> T convertAccordingRequire(ConvertRequire require) throws ConvertFailedException {

        return null;
    }
}
