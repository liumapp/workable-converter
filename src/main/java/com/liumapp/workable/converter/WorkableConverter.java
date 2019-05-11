package com.liumapp.workable.converter;

import com.liumapp.workable.converter.config.ConverterConfig;
import com.liumapp.workable.converter.config.ConvertRequire;
import com.liumapp.workable.converter.core.Converter;
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

    public void convertByFilePath () throws ConvertFailedException {
        converterType.convert();
    }

    public void convertByStream () throws ConvertFailedException {
        converterType.convert();
    }

    public void convertByBase64 () throws ConvertFailedException {
        converterType.convert();
    }

    /**
     * auto convert according the data of require
     */
    @Override
    public <T> T convert() throws ConvertFailedException {
        return null;
    }
}
