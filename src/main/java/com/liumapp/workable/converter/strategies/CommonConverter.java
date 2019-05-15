package com.liumapp.workable.converter.strategies;

import com.liumapp.qtools.file.base64.Base64FileTool;
import com.liumapp.qtools.file.basic.FileTool;
import com.liumapp.workable.converter.config.ConvertRequire;
import com.liumapp.workable.converter.core.Parameter;
import com.liumapp.workable.converter.enums.Patterns;
import com.liumapp.workable.converter.exceptions.ConvertFailedException;
import org.jodconverter.JodConverter;
import org.jodconverter.office.OfficeException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.Base64;

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
        if (require.getPatterns() == Patterns.By_Base64) return byBase64(require);
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
        try {
            JodConverter.convert(require.getSrcStream()).as(require.getSrcFormat())
                    .to(require.getDestStream()).as(require.getDestFormat()).execute();
        } catch (OfficeException e) {
            throw new ConvertFailedException(e.getMessage());
        }
        return true;
    }

    protected  boolean byBase64 (ConvertRequire require) throws ConvertFailedException {
        ByteArrayInputStream inputStream = null;
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        try {
            inputStream = Base64FileTool.decodeBase64ToInputStream(require.getSrcBase64());
            JodConverter.convert(inputStream)
                    .as(require.getSrcFormat())
                    .to(outputStream)
                    .as(require.getDestFormat()).execute();
            require.setDestBase64(Base64FileTool.ByteArrayToBase64(outputStream.toByteArray()));
        } catch (Exception e) {
            throw new ConvertFailedException(e.getMessage());
        } finally {
            try {
                inputStream.close();
                outputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return true;
    }

}
