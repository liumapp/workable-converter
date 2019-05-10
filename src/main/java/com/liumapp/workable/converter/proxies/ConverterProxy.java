package com.liumapp.workable.converter.proxies;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * file ConverterProxy.java
 * author liumapp
 * github https://github.com/liumapp
 * email liumapp.com@gmail.com
 * homepage http://www.liumapp.com
 * date 2019/5/10
 */
public class ConverterProxy {

    private static Logger LOGGER = LoggerFactory.getLogger(ConverterProxy.class);

    private static ConverterProxy converterProxy = new ConverterProxy();

    private ConverterProxy() {
    }

    public static ConverterProxy getInstance() {
        return converterProxy;
    }


}
