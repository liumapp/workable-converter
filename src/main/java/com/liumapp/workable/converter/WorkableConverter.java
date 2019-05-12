package com.liumapp.workable.converter;

import com.liumapp.workable.converter.config.ConverterConfig;
import com.liumapp.workable.converter.config.ConvertRequire;
import com.liumapp.workable.converter.core.Converter;
import com.liumapp.workable.converter.core.Parameter;
import com.liumapp.workable.converter.decorators.ConnectAndStartLocalLibreOfficeDecorator;
import com.liumapp.workable.converter.exceptions.ConvertFailedException;
import com.liumapp.workable.converter.factory.ConverterConfigManager;
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

    public WorkableConverter() throws Throwable {
    }

    public void convertByFilePath (Parameter require) throws ConvertFailedException {
        Converter converter = new ConnectAndStartLocalLibreOfficeDecorator(converterType);
        
        converter.convert(require);
    }

    public void convertByStream (Parameter require) throws ConvertFailedException {
        converterType.convert(require);
    }

    public void convertByBase64 (Parameter require) throws ConvertFailedException {
        converterType.convert(require);
    }

    /**
     * auto convert according the data of require
     */
    @Override
    public <T> T convert(Parameter require) throws ConvertFailedException {
        return null;
    }
}
