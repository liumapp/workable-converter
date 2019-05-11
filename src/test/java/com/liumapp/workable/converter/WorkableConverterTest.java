package com.liumapp.workable.converter;

import com.liumapp.workable.converter.core.Converter;
import com.liumapp.workable.converter.exceptions.ConvertFailedException;
import com.liumapp.workable.converter.proxies.ConverterProxy;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * file WorkableConverterTest.java
 * author liumapp
 * github https://github.com/liumapp
 * email liumapp.com@gmail.com
 * homepage http://www.liumapp.com
 * date 2019/5/10
 */
public class WorkableConverterTest {

    @Test
    public void convertByFilePath() throws ConvertFailedException {
        WorkableConverter converter = ConverterProxy.getInstance().getProxy(WorkableConverter.class);
        converter.convertByFilePath();

    }

    @Test
    public void convertByStream() {
    }

    @Test
    public void convertByBase64() {
    }

    @Test
    public void convert() {

    }
}