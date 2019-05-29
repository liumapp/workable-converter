package com.liumapp.workable.converter.strategies;

import com.liumapp.workable.converter.config.ConvertRequire;
import com.liumapp.workable.converter.core.Parameter;
import com.liumapp.workable.converter.exceptions.ConvertFailedException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.ZonedDateTime;

/**
 * file WaterMarkConverter.java
 * author liumapp
 * github https://github.com/liumapp
 * email liumapp.com@gmail.com
 * homepage http://www.liumapp.com
 * date 2019/5/29
 */
public class WaterMarkConverter extends ConverterStrategy {

    private static Logger logger = LoggerFactory.getLogger(WaterMarkConverter.class);

    @Override
    public boolean convert(Parameter require) throws ConvertFailedException {
        logger.info("watermark converter begin at : " + ZonedDateTime.now());
        return accordingRequire((ConvertRequire) require);
    }

    @Override
    protected boolean byFilePath(ConvertRequire require) throws ConvertFailedException {
        return false;
    }

    @Override
    protected boolean byFileFolder(ConvertRequire require) throws ConvertFailedException {
        return false;
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
