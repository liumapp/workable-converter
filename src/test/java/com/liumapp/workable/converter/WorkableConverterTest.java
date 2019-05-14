package com.liumapp.workable.converter;

import com.liumapp.qtools.file.basic.FileTool;
import com.liumapp.workable.converter.core.ConvertPattern;
import com.liumapp.workable.converter.exceptions.ConvertFailedException;
import com.liumapp.workable.converter.factory.*;
import com.liumapp.workable.converter.proxies.ConverterProxy;
import org.jodconverter.document.DefaultDocumentFormatRegistry;
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
    public void convertDocToPdfByFilePath() throws ConvertFailedException {
        WorkableConverter converter = ConverterProxy.getInstance().getProxy(WorkableConverter.class);
        ConvertPattern pattern = ConvertPatternManager.getInstance();
        pattern.setConvertByFilePathRequire("./data/test.doc", "./data/pdf/result1.pdf");
        pattern.setSrcFilePrefix(DefaultDocumentFormatRegistry.DOC);
        pattern.setDestFilePrefix(DefaultDocumentFormatRegistry.PDF);
        converter.setConverterType(CommonConverterManager.getInstance());

        assertEquals(true, converter.convert(pattern.getParameter()));
        assertEquals(true, FileTool.isFileExists("./data/pdf/result1.pdf"));
    }

    @Test
    public void convertDocxToPdfByFilePath () throws ConvertFailedException {
        WorkableConverter converter = ConverterProxy.getInstance().getProxy(WorkableConverter.class);
        ConvertPattern pattern = ConvertPatternManager.getInstance();
        pattern.setConvertByFilePathRequire("./data/test2.docx", "./data/pdf/result2.pdf");
        pattern.setSrcFilePrefix(DefaultDocumentFormatRegistry.DOCX);
        pattern.setDestFilePrefix(DefaultDocumentFormatRegistry.PDF);
        converter.setConverterType(CommonConverterManager.getInstance());

        assertEquals(true, converter.convert(pattern.getParameter()));
        assertEquals(true, FileTool.isFileExists("./data/pdf/result2.pdf"));
    }

    @Test
    public void convertHtmlToPdfByFilePath() throws ConvertFailedException {
        WorkableConverter converter = ConverterProxy.getInstance().getProxy(WorkableConverter.class);
        ConvertPattern pattern = ConvertPatternManager.getInstance();
        pattern.setConvertByFilePathRequire("./data/test3.html", "./data/pdf/result3.pdf");
        pattern.setSrcFilePrefix(DefaultDocumentFormatRegistry.HTML);
        pattern.setDestFilePrefix(DefaultDocumentFormatRegistry.PDF);
        converter.setConverterType(CommonConverterManager.getInstance());

        assertEquals(true, converter.convert(pattern.getParameter()));
        assertEquals(true, FileTool.isFileExists("./data/pdf/result3.pdf"));
    }

    //todo
    @Test
    public void convertDocToPngByFilePath() throws ConvertFailedException {
        WorkableConverter converter = ConverterProxy.getInstance().getProxy(WorkableConverter.class);

        ConvertPattern pattern = ConvertPatternManager.getInstance();
        pattern.setConvertByFilePathRequire("./data/test.doc", "./data/pic/test.png");
        pattern.setSrcFilePrefix(DefaultDocumentFormatRegistry.DOC);
        pattern.setDestFilePrefix(DefaultDocumentFormatRegistry.PNG);

        converter.setConverterType(CommonConverterManager.getInstance());
        converter.convert(pattern.getParameter());

//        assertEquals(true, FileTool.isFileExists("./data/pic/test1.png"));
//        assertEquals(true, FileTool.isFileExists("./data/pic/test2.png"));
//        assertEquals(true, FileTool.isFileExists("./data/pic/test3.png"));
    }

    /**
     * todo
     */
    @Test
    public void convertPngToPdfByFilePath() throws ConvertFailedException {

    }

    @Test
    public void convertDocToPdfByStream() throws ConvertFailedException {

//        WorkableConverter converter = ConverterProxy.getInstance().getProxy(WorkableConverter.class);
//        ConvertRequire require = ConvertRequireManager.getInstance();

//        converter.convertByStream();
    }

    @Test
    public void convertByBase64() throws ConvertFailedException {
//        WorkableConverter converter = ConverterProxy.getInstance().getProxy(WorkableConverter.class);
//        converter.convertByBase64();
    }

}