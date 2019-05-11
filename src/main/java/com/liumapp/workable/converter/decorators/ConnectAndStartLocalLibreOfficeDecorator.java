package com.liumapp.workable.converter.decorators;

import com.liumapp.workable.converter.core.Converter;
import com.liumapp.workable.converter.core.Parameter;
import com.liumapp.workable.converter.exceptions.ConvertFailedException;
import com.liumapp.workable.converter.factory.ConverterOfficeManager;
import com.liumapp.workable.converter.templates.NormalConverterTemplates;
import org.jodconverter.office.OfficeException;
import org.jodconverter.office.OfficeManager;

/**
 * file ConnectAndStartLocalLibreOfficeDecorator.java
 * author liumapp
 * github https://github.com/liumapp
 * email liumapp.com@gmail.com
 * homepage http://www.liumapp.com
 * date 2019/5/11
 */
public class ConnectAndStartLocalLibreOfficeDecorator extends NormalConverterTemplates {

    private OfficeManager officeManager;

    public ConnectAndStartLocalLibreOfficeDecorator(Converter converter) {
        super(converter);
    }

    @Override
    public <T> T convert(Parameter require) throws ConvertFailedException {
        officeManager = ConverterOfficeManager.getInstance();
        if (!officeManager.isRunning()) {
            try {
                officeManager.start();
            } catch (OfficeException e) {
                e.printStackTrace();
                throw new ConvertFailedException("connect to libreoffice failed!");
            }
        }
        return super.convert(require);
    }

}
