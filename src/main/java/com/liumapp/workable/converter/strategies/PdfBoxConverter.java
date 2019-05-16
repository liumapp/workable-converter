package com.liumapp.workable.converter.strategies;

import com.liumapp.workable.converter.config.ConvertRequire;
import com.liumapp.workable.converter.core.Parameter;
import com.liumapp.workable.converter.enums.Patterns;
import com.liumapp.workable.converter.exceptions.ConvertFailedException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * file PdfBoxConverter.java
 * author liumapp
 * github https://github.com/liumapp
 * email liumapp.com@gmail.com
 * homepage http://www.liumapp.com
 * date 2019/5/16
 */
public class PdfBoxConverter extends ConverterStrategy {

    private static Logger logger = LoggerFactory.getLogger(PdfBoxConverter.class);

    @Override
    public boolean convert (Parameter require) throws ConvertFailedException {
        logger.info("pdf box converter begin: ");
        return accordingRequire((ConvertRequire) require);
    }

    /**
     * todo
     */
    @Override
    protected boolean byFilePath (ConvertRequire require) throws ConvertFailedException {
        throw new ConvertFailedException("pdf box converter do not support by file path convert pattern");
    }

    @Override
    protected boolean byFileFolder(ConvertRequire require) throws ConvertFailedException {
        return false;
    }

    /**
     * todo
     */
    @Override
    protected boolean byStream (ConvertRequire require) throws ConvertFailedException {
        return false;
    }

    /**
     * todo
     */
    @Override
    protected boolean byBase64 (ConvertRequire require) throws ConvertFailedException {
        return false;
    }



}
