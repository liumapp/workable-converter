package com.liumapp.workable.converter.strategies;


import com.liumapp.workable.converter.config.ConvertRequire;
import com.liumapp.workable.converter.core.Parameter;
import com.liumapp.workable.converter.enums.Patterns;
import com.liumapp.workable.converter.exceptions.ConvertFailedException;
import com.liumapp.workable.converter.factory.ConverterOfficeManager;
import org.jodconverter.JodConverter;
import org.jodconverter.office.OfficeException;
import org.jodconverter.office.OfficeManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;

/**
 * file DocToPdfConverter.java
 * author liumapp
 * github https://github.com/liumapp
 * email liumapp.com@gmail.com
 * homepage http://www.liumapp.com
 * date 2019/5/13
 */
public class DocToPdfConverter extends ConverterStrategy {

    private static Logger logger = LoggerFactory.getLogger(DocToPdfConverter.class);

    @Deprecated
    @Override
    public boolean convert(Parameter require) throws ConvertFailedException {
        logger.info("doc to pdf converter begin");
        return accordingRequire( (ConvertRequire) require);
    }

    @Override
    protected boolean accordingRequire(ConvertRequire require) throws ConvertFailedException {
        if (require.getPatterns() == Patterns.By_File_Path) {
            return byFilePath(require);
        }
        return false;
    }

    @Override
    protected boolean byFilePath (ConvertRequire require) throws ConvertFailedException {
        logger.info("get waiting convert file : " + require.getWaitingFilePath());
        logger.info("get result file path : " + require.getResultFilePath());
        File inputFile = new File(require.getWaitingFilePath());
        File outputFile = new File(require.getResultFilePath());
        try {
            JodConverter.convert(inputFile).to(outputFile).execute();
        } catch (OfficeException e) {
            throw new ConvertFailedException(e.getMessage());
        }
        return true;
    }

    @Override
    protected boolean byStream(ConvertRequire require) throws ConvertFailedException {
        return false;
    }

    @Override
    protected boolean byBase64(ConvertRequire require) throws ConvertFailedException {
        return false;
    }
}
