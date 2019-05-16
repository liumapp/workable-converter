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
        return this.accordingRequire((ConvertRequire) require);
    }

    @Override
    protected boolean accordingRequire (ConvertRequire require) throws ConvertFailedException {
        if (require.getPatterns() == Patterns.By_File_Path) return byFilePath(require);
        if (require.getPatterns() == Patterns.By_Stream) return byStream(require);
        if (require.getPatterns() == Patterns.By_Base64) return byBase64(require);
        throw new ConvertFailedException("can not found convert patterns .");
    }

    @Override
    protected boolean byFilePath (ConvertRequire require) throws ConvertFailedException {
        
        return false;
    }

    @Override
    protected boolean byStream (ConvertRequire require) throws ConvertFailedException {
        return false;
    }

    @Override
    protected boolean byBase64 (ConvertRequire require) throws ConvertFailedException {
        return false;
    }



}
