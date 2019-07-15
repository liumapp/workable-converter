package com.liumapp.workable.converter.decorators;

import com.liumapp.workable.converter.config.ConvertRequire;
import com.liumapp.workable.converter.core.Converter;
import com.liumapp.workable.converter.core.Parameter;
import com.liumapp.workable.converter.exceptions.ConvertFailedException;
import com.liumapp.workable.converter.factory.ConverterConfigManager;
import com.liumapp.workable.converter.templates.ConverterStrategyTemplates;

import java.io.IOException;

/**
 * file CheckingParamsForTextConverterDecorator.java
 * author liumapp
 * github https://github.com/liumapp
 * email liumapp.com@gmail.com
 * homepage http://www.liumapp.com
 * date 2019/5/9
 */
public class CheckingParamsForTextConverterDecorator extends ConverterStrategyTemplates {


    public CheckingParamsForTextConverterDecorator(Converter converterStrategy) {
        super(converterStrategy);
    }

    @Override
    protected boolean accordingRequire(ConvertRequire require) throws ConvertFailedException {
        return super.accordingRequire(require);
    }

    @Override
    public boolean byFilePath(ConvertRequire require) throws ConvertFailedException {
        return false;
    }


    @Override
    public boolean byFileFolder(ConvertRequire require) throws ConvertFailedException {
        return false;
    }

    @Override
    public boolean byStream(ConvertRequire require) throws ConvertFailedException {
        return false;
    }

    @Override
    public boolean byBase64(ConvertRequire require) throws ConvertFailedException {
        return false;
    }

    @Override
    protected String saveTmpFileByBase64(String fileBase64, String prefix) throws IOException {
        return super.saveTmpFileByBase64(fileBase64, prefix);
    }

    @Override
    protected String saveTmpFileByBytes(byte[] fileBytes, String prefix) throws IOException {
        return super.saveTmpFileByBytes(fileBytes, prefix);
    }

    @Override
    public boolean convert(Parameter require) throws ConvertFailedException {
        String ttfPath = ConverterConfigManager.getInstance().getParams().getFontPath();

        if (ttfPath == null) {
            throw new ConvertFailedException("fonts path must need");
        }
        return super.convert(require);
    }
}
