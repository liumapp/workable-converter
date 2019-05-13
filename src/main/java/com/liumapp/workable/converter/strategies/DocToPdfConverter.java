package com.liumapp.workable.converter.strategies;


import com.liumapp.workable.converter.config.ConvertRequire;
import com.liumapp.workable.converter.core.Parameter;
import com.liumapp.workable.converter.exceptions.ConvertFailedException;

public class DocToPdfConverter extends ConverterStrategy {

    @Override
    public <T> T convert(Parameter require) throws ConvertFailedException {
        return convertAccordingRequire( (ConvertRequire) require);
    }

    private <T> T convertAccordingRequire(ConvertRequire require) throws ConvertFailedException {
        
        return null;
    }
}
