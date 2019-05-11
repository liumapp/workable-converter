package com.liumapp.workable.converter;

import com.liumapp.workable.converter.config.ConvertRequire;
import com.liumapp.workable.converter.core.Converter;
import com.liumapp.workable.converter.exceptions.ConvertFailedException;
import com.liumapp.workable.converter.factory.DocToPdfConverterManager;
import com.liumapp.workable.converter.proxies.ConverterProxy;
import org.junit.Before;
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
        converter.setConverter(DocToPdfConverterManager.getInstance());
        converter.setRequire(initRequireInfo());
        converter.convertByFilePath();

    }

    @Test
    public void convertByStream() throws ConvertFailedException {
        WorkableConverter converter = ConverterProxy.getInstance().getProxy(WorkableConverter.class);
        converter.convertByStream();
    }

    @Test
    public void convertByBase64() throws ConvertFailedException {
        WorkableConverter converter = ConverterProxy.getInstance().getProxy(WorkableConverter.class);
        converter.convertByBase64();
    }

    @Test
    public void convert() throws ConvertFailedException {
        Converter converter = ConverterProxy.getInstance().getProxy(WorkableConverter.class);
        converter.convert();

    }

    private ConvertRequire initRequireInfo () {
        ConvertRequire require = new ConvertRequire();
        return require;
    }
}