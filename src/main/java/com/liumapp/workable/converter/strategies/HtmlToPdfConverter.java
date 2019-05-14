package com.liumapp.workable.converter.strategies;

import com.liumapp.workable.converter.core.Parameter;
import com.liumapp.workable.converter.exceptions.ConvertFailedException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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

    @Override
    public boolean convert(Parameter require) throws ConvertFailedException {
        logger.info("html to pdf converter begin.");
        return false;
    }




}
