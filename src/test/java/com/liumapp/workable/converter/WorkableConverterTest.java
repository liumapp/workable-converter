package com.liumapp.workable.converter;

import com.liumapp.qtools.file.base64.Base64FileTool;
import com.liumapp.qtools.file.basic.FileTool;
import com.liumapp.workable.converter.config.ConvertRequire;
import com.liumapp.workable.converter.core.ConvertPattern;
import com.liumapp.workable.converter.exceptions.ConvertFailedException;
import com.liumapp.workable.converter.factory.*;
import com.liumapp.workable.converter.proxies.ConverterProxy;
import org.jodconverter.document.DefaultDocumentFormatRegistry;
import org.junit.Test;

import java.io.*;

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
//        WorkableConverter converter = ConverterProxy.getInstance().getProxy(WorkableConverter.class);
        WorkableConverter converter = new WorkableConverter();
        ConvertPattern pattern = ConvertPatternManager.getInstance();
        pattern.fileToFile("./data/test.doc", "/tmp/pdf/result1.pdf");
        pattern.setSrcFilePrefix(DefaultDocumentFormatRegistry.DOC);
        pattern.setDestFilePrefix(DefaultDocumentFormatRegistry.PDF);
        converter.setConverterType(CommonConverterManager.getInstance());
        boolean convert = converter.convert(pattern.getParameter());
        assertEquals(true,convert);
        //assertEquals(true, FileTool.isFileExists("/tmp/pdf/result1.pdf"));
    }

    /**
     * but we do suggest you set convert result prefix.
     */


    @Test
    public void convertDocToPdfByStream() throws FileNotFoundException, ConvertFailedException {
        // you can also choice not use proxy
        WorkableConverter converter = new WorkableConverter();
        ConvertPattern pattern = ConvertPatternManager.getInstance();
        pattern.streamToStream(new FileInputStream("/tmp/doc/幸运大转盘活动协议书.docx"),  new FileOutputStream("/tmp/pdf/result1_2.pdf"));
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        pattern.streamToStream(new FileInputStream("./data/test.doc"), bos);
        pattern.streamToStream(new FileInputStream("./data/test.doc"), new FileOutputStream("./data/pdf/result1_2.pdf"));
        // attention !!! convert by stream must set prefix.
        pattern.setSrcFilePrefix(DefaultDocumentFormatRegistry.DOC);
        pattern.setDestFilePrefix(DefaultDocumentFormatRegistry.PDF);
        converter.setConverterType(CommonConverterManager.getInstance());
        assertEquals(true, converter.convert(pattern.getParameter()));
       // assertEquals(true, FileTool.isFileExists("./data/pdf/result1_2.pdf"));
    }

    @Test
    public void convertDocToPdfByBase64() throws ConvertFailedException, IOException {
        WorkableConverter converter = new WorkableConverter();
        ConvertPattern pattern = ConvertPatternManager.getInstance();
        pattern.base64ToBase64(Base64FileTool.FileToBase64(new File("/tmp/doc/幸运大转盘活动协议书.docx")));
        // attention !!! convert by base64 must set prefix.
        pattern.setSrcFilePrefix(DefaultDocumentFormatRegistry.DOC);
        pattern.setDestFilePrefix(DefaultDocumentFormatRegistry.PDF);
        converter.setConverterType(CommonConverterManager.getInstance());
        assertEquals(true, converter.convert(pattern.getParameter()));
        Base64FileTool.saveBase64File(pattern.getBase64Result(), "/tmp/pdf/result1_3.pdf");//save dest base64 to file
        //assertEquals(true, FileTool.isFileExists("/tmp/pdf/result1_3.pdf"));
    }

    @Test
    public void convertDocxToPdfByFilePath () throws ConvertFailedException {
        WorkableConverter converter = ConverterProxy.getInstance().getProxy(WorkableConverter.class);
        ConvertPattern pattern = ConvertPatternManager.getInstance();
        pattern.fileToFile("./data/fonts-test.docx", "./data/pdf/result2.pdf");
        pattern.setSrcFilePrefix(DefaultDocumentFormatRegistry.DOCX);
        pattern.setDestFilePrefix(DefaultDocumentFormatRegistry.PDF);
        converter.setConverterType(CommonConverterManager.getInstance());

        assertEquals(true, converter.convert(pattern.getParameter()));
        assertEquals(true, FileTool.isFileExists("./data/pdf/result2.pdf"));
    }
    @Test
    public void convertDocxToPdfByByStream () throws ConvertFailedException, FileNotFoundException {
        WorkableConverter converter = ConverterProxy.getInstance().getProxy(WorkableConverter.class);
        ConvertPattern pattern = ConvertPatternManager.getInstance();
        pattern.streamToStream(new FileInputStream("/tmp/doc/幸运大转盘活动协议书.docx"), new FileOutputStream("/tmp/pdf/result1_7.pdf"));
        pattern.setSrcFilePrefix(DefaultDocumentFormatRegistry.DOCX);
        pattern.setDestFilePrefix(DefaultDocumentFormatRegistry.PDF);
        converter.setConverterType(CommonConverterManager.getInstance());

        assertEquals(true, converter.convert(pattern.getParameter()));
        //assertEquals(true, FileTool.isFileExists("./data/pdf/result2.pdf"));
    }

    @Test
    public void convertHtmlToPdfByFilePath() throws ConvertFailedException {
        WorkableConverter converter = ConverterProxy.getInstance().getProxy(WorkableConverter.class);
        ConvertPattern pattern = ConvertPatternManager.getInstance();
        pattern.fileToFile("/tmp/4.html", "/tmp/result5.pdf");
        pattern.setSrcFilePrefix(DefaultDocumentFormatRegistry.HTML);
        pattern.setDestFilePrefix(DefaultDocumentFormatRegistry.PDF);
        converter.setConverterType(CommonConverterManager.getInstance());
        assertEquals(true, converter.convert(pattern.getParameter()));
       // assertEquals(true, FileTool.isFileExists("./data/pdf/result4.pdf"));
    }
    @Test
    public void convertDocToPdfByFilePathWithoutPrefix() throws ConvertFailedException {
//      WorkableConverter converter = ConverterProxy.getInstance().getProxy(WorkableConverter.class);
        WorkableConverter converter = new WorkableConverter();//you can also choice not use proxy, plz yourself.
        ConvertPattern pattern = ConvertPatternManager.getInstance();
        pattern.fileToFile("/tmp/doc/幸运大转盘活动协议书.docx", "/tmp/pdf/result1_1.pdf");
//      pattern.setSrcFilePrefix(DefaultDocumentFormatRegistry.DOC);
//      pattern.setDestFilePrefix(DefaultDocumentFormatRegistry.PDF);
        converter.setConverterType(CommonConverterManager.getInstance());
        assertEquals(true, converter.convert(pattern.getParameter()));
        //assertEquals(true, FileTool.isFileExists("./data/pdf/result1_1.pdf"));
    }
    //todo
    @Test
    public void convertDocToPngByFilePath() throws ConvertFailedException {
        WorkableConverter converter = ConverterProxy.getInstance().getProxy(WorkableConverter.class);
        ConvertPattern pattern = ConvertPatternManager.getInstance();
        pattern.setConvertByFilePathRequire("/tmp/pdf/result1_3.pdf", "/tmp/pic/test3.png");
        pattern.setSrcFilePrefix(DefaultDocumentFormatRegistry.DOC);
        pattern.setDestFilePrefix(DefaultDocumentFormatRegistry.PNG);
        converter.setConverterType(CommonConverterManager.getInstance());
        converter.convert(pattern.getParameter());
    }
}