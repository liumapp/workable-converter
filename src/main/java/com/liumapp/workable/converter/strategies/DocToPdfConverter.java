package com.liumapp.workable.converter.strategies;


import com.liumapp.workable.converter.config.ConvertRequire;
import com.liumapp.workable.converter.core.Parameter;
import com.liumapp.workable.converter.enums.Patterns;
import com.liumapp.workable.converter.exceptions.ConvertFailedException;
import com.liumapp.workable.converter.factory.ConverterOfficeManager;
import org.jodconverter.office.OfficeManager;

/**
 * file DocToPdfConverter.java
 * author liumapp
 * github https://github.com/liumapp
 * email liumapp.com@gmail.com
 * homepage http://www.liumapp.com
 * date 2019/5/13
 */
public class DocToPdfConverter extends ConverterStrategy {

    private OfficeManager officeManager = ConverterOfficeManager.getInstance();

    @Override
    public boolean convert(Parameter require) throws ConvertFailedException {
        return convertAccordingRequire( (ConvertRequire) require);
    }

    private boolean convertAccordingRequire(ConvertRequire require) throws ConvertFailedException {
        if (require.getPatterns() == Patterns.By_File_Path) {
            return byFilePath();
        }
        return false;
    }

    private boolean byFilePath () {
        return true;
    }
}
