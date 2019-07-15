package com.liumapp.workable.converter;

import com.liumapp.workable.converter.config.ConverterConfig;
import com.liumapp.workable.converter.config.ConvertRequire;
import com.liumapp.workable.converter.core.Converter;
import com.liumapp.workable.converter.core.Parameter;
import com.liumapp.workable.converter.decorators.CheckPrefixFormatDecorator;
import com.liumapp.workable.converter.decorators.CheckingParamsForTextConverterDecorator;
import com.liumapp.workable.converter.decorators.ConnectAndStartLocalLibreOfficeDecorator;
import com.liumapp.workable.converter.exceptions.ConvertFailedException;
import com.liumapp.workable.converter.factory.ConverterConfigManager;
import com.liumapp.workable.converter.strategies.TextConverter;
import lombok.Getter;
import lombok.Setter;

/**
 * file WorkableConverter.java
 * author liumapp
 * github https://github.com/liumapp
 * email liumapp.com@gmail.com
 * homepage http://www.liumapp.com
 * date 2019/5/9
 */
public class WorkableConverter implements Converter {

    @Getter
    @Setter
    private Converter converterType;

    @Getter
    private ConverterConfig params = ConverterConfigManager.getInstance().getParams();

    public WorkableConverter() {
    }

    /**
     * auto convert according the data of require
     */
    @Override
    public boolean convert(Parameter require) throws ConvertFailedException {
        Converter converter;
        if (converterType instanceof TextConverter) {
            converter = new ConnectAndStartLocalLibreOfficeDecorator(new CheckPrefixFormatDecorator(new CheckingParamsForTextConverterDecorator(converterType)));
        } else {
            converter = new ConnectAndStartLocalLibreOfficeDecorator(new CheckPrefixFormatDecorator(converterType));
        }
        return converter.convert(require);
    }
}
