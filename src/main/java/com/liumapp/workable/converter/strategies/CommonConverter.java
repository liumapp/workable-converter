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
import java.time.LocalDateTime;
import java.time.ZonedDateTime;

/**
 * file CommonConverter.java
 * author liumapp
 * github https://github.com/liumapp
 * email liumapp.com@gmail.com
 * homepage http://www.liumapp.com
 * date 2019/5/14
 */
public class CommonConverter extends ConverterStrategy {

    private static Logger logger = LoggerFactory.getLogger(CommonConverter.class);

    @Override
    public boolean convert(Parameter require) throws ConvertFailedException {
        logger.info("common converter begin at " + ZonedDateTime.now());
        return accordingRequire((ConvertRequire) require);
    }

    protected boolean accordingRequire (ConvertRequire require) throws ConvertFailedException {
        if (require.getPatterns() == Patterns.By_File_Path) return byFilePath(require);
        if (require.getPatterns() == Patterns.By_Stream) return byStream(require);
        throw new ConvertFailedException("can not found convert patterns .");
    }

    protected boolean byFilePath (ConvertRequire require) throws ConvertFailedException {
        logger.info("input file path is : " + require.getWaitingFilePath());
        logger.info("output file path is : " + require.getResultFilePath());
        File inputFile = new File(require.getWaitingFilePath());
        File outputFile = new File(require.getResultFilePath());
        try {
            JodConverter.convert(inputFile).as(require.getSrcFormat())
                    .to(outputFile).as(require.getDestFormat()).execute();
        } catch (OfficeException e) {
            throw new ConvertFailedException(e.getMessage());
        }
        return true;
    }

    protected boolean byStream (ConvertRequire require) throws ConvertFailedException {

        return true;
    }

}
