package com.liumapp.workable.converter.decorators;

import com.liumapp.workable.converter.config.ConvertRequire;
import com.liumapp.workable.converter.core.Converter;
import com.liumapp.workable.converter.core.Parameter;
import com.liumapp.workable.converter.enums.Patterns;
import com.liumapp.workable.converter.exceptions.ConvertFailedException;
import com.liumapp.workable.converter.templates.NormalConverterTemplates;
import org.jodconverter.JodConverter;
import org.jodconverter.office.OfficeException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.time.ZonedDateTime;

/**
 * file CheckPrefixFormatDecorator.java
 * author liumapp
 * github https://github.com/liumapp
 * email liumapp.com@gmail.com
 * homepage http://www.liumapp.com
 * date 2019/5/14
 */
public class CheckPrefixFormatDecorator extends NormalConverterTemplates {

    private static Logger logger = LoggerFactory.getLogger(CheckPrefixFormatDecorator.class);

    public CheckPrefixFormatDecorator(Converter converter) {
        super(converter);
    }

    @Override
    public boolean convert(Parameter require) throws ConvertFailedException {
        logger.info("check prefix format begin at " + ZonedDateTime.now());
        ConvertRequire convertRequire = (ConvertRequire) require;
        if (convertRequire.getSrcFormat() == null || convertRequire.getDestFormat() == null) {
            return convertWithoutPrefix(convertRequire);
        }
        return super.convert(require);
    }

    /**
     * judge prefix by the file prefix
     */
    protected boolean convertWithoutPrefix (ConvertRequire require) throws ConvertFailedException {
        logger.warn("no convert file prefix detected , we will try to convert by the end of file prefix .");
        if (require.getPatterns() == Patterns.By_File_Path) return byFilePath(require);
        if (require.getPatterns() == Patterns.By_Stream) throw new ConvertFailedException("convert by stream must specified convert prefix.");
        throw new ConvertFailedException("can not found convert patterns .");

    }

    protected boolean byFilePath (ConvertRequire require) throws ConvertFailedException {
        logger.info("get waiting convert path :" + require.getWaitingFilePath());
        logger.info("get result convert path : " + require.getResultFilePath());
        File inputFile = new File(require.getWaitingFilePath());
        File outputFile = new File(require.getResultFilePath());
        try {
            JodConverter.convert(inputFile).to(outputFile).execute();
        } catch (OfficeException e) {
            throw new ConvertFailedException(e.getMessage());
        }
        return true;
    }
}
