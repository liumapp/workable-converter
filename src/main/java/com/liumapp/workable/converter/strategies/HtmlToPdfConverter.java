package com.liumapp.workable.converter.strategies;

import com.liumapp.workable.converter.config.ConvertRequire;
import com.liumapp.workable.converter.core.Parameter;
import com.liumapp.workable.converter.enums.Patterns;
import com.liumapp.workable.converter.exceptions.ConvertFailedException;
import org.jodconverter.JodConverter;
import org.jodconverter.office.OfficeException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;

/**
 * file HtmlToPdfConverter.java
 * author liumapp
 * github https://github.com/liumapp
 * email liumapp.com@gmail.com
 * homepage http://www.liumapp.com
 * date 2019/5/10
 */
public class HtmlToPdfConverter extends ConverterStrategy {

    private static Logger logger = LoggerFactory.getLogger(HtmlToPdfConverter.class);

    @Deprecated
    @Override
    public boolean convert(Parameter require) throws ConvertFailedException {
        logger.info("html to pdf converter begin.");
        return convertAccordingRequire((ConvertRequire) require);
    }

    private boolean convertAccordingRequire(ConvertRequire require) throws ConvertFailedException {
        if (require.getPatterns() == Patterns.By_File_Path) {
            return byFilePath(require);
        }
        return false;
    }

    private boolean byFilePath (ConvertRequire require) {
        logger.info("get waiting convert html file path : " + require.getWaitingFilePath());
        logger.info("get result file path : " + require.getResultFilePath());
        File inputFile = new File(require.getWaitingFilePath());
        File outputFile = new File(require.getResultFilePath());
        try {
            JodConverter.convert(inputFile).to(outputFile).execute();
        } catch (OfficeException e) {
            e.printStackTrace();
        }
        return true;
    }




}
