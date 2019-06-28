package com.liumapp.workable.converter.strategies;

import com.liumapp.qtools.file.base64.Base64FileTool;
import com.liumapp.qtools.file.basic.FileTool;
import com.liumapp.workable.converter.WorkableConverter;
import com.liumapp.workable.converter.config.WaterMarkRequire;
import com.liumapp.workable.converter.core.ConvertPattern;
import com.liumapp.workable.converter.exceptions.ConvertFailedException;
import com.liumapp.workable.converter.factory.ConvertPatternManager;
import com.liumapp.workable.converter.factory.WaterMarkConverterManager;
import org.apache.commons.io.FileUtils;
import org.jodconverter.document.DefaultDocumentFormatRegistry;
import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import static org.junit.Assert.*;

/**
 * file WaterMarkConverterTest.java
 * author liumapp
 * github https://github.com/liumapp
 * email liumapp.com@gmail.com
 * homepage http://www.liumapp.com
 * date 2019/5/30
 */
public class WaterMarkConverterTest {


    /**
     * add water mark only support pdf to pdf
     */
    @Test
    public void byFilePath() throws IOException, ConvertFailedException {
        WorkableConverter converter = new WorkableConverter();
        converter.setConverterType(WaterMarkConverterManager.getInstance());

        ConvertPattern pattern = ConvertPatternManager.getInstance();
        WaterMarkRequire waterMarkRequire = new WaterMarkRequire();

        waterMarkRequire.setWaterMarkPage(0);//0 means all age
        waterMarkRequire.setWaterMarkPDFBase64(Base64FileTool.FileToBase64(new File("./data/watermark.pdf")));

        pattern.setWaterMarkRequire(waterMarkRequire);
        pattern.setSrcFilePrefix(DefaultDocumentFormatRegistry.PDF);
        pattern.setDestFilePrefix(DefaultDocumentFormatRegistry.PDF);
        pattern.fileToFile("./data/test5.pdf", "./data/test6_with_mark01.pdf");

        boolean result = converter.convert(pattern.getParameter());
        assertEquals(true, result);

    }

    @Test
    public void byStream() throws IOException, ConvertFailedException {
        WorkableConverter converter = new WorkableConverter();
        converter.setConverterType(WaterMarkConverterManager.getInstance());

        ConvertPattern pattern = ConvertPatternManager.getInstance();
        WaterMarkRequire waterMarkRequire = new WaterMarkRequire();

        waterMarkRequire.setWaterMarkPage(0);//0 means all age
//        waterMarkRequire.setWaterMarkPDFBase64(Base64FileTool.FileToBase64(new File("./data/watermark.pdf")));
        waterMarkRequire.setWaterMarkPDFBytes(FileUtils.readFileToByteArray(new File("./data/watermark02.pdf")));

        pattern.setWaterMarkRequire(waterMarkRequire);
        pattern.setSrcFilePrefix(DefaultDocumentFormatRegistry.PDF);
        pattern.setDestFilePrefix(DefaultDocumentFormatRegistry.PDF);
        pattern.streamToStream(new FileInputStream("./data/test5.pdf"), new FileOutputStream("./data/test6_with_mark02.pdf"));

        boolean result = converter.convert(pattern.getParameter());
        assertEquals(true, result);
    }

    @Test
    public void byBase64() throws IOException, ConvertFailedException {
        WorkableConverter converter = new WorkableConverter();
        converter.setConverterType(WaterMarkConverterManager.getInstance());

        ConvertPattern pattern = ConvertPatternManager.getInstance();
        WaterMarkRequire waterMarkRequire = new WaterMarkRequire();

        waterMarkRequire.setWaterMarkPage(0);//0 means all age
        String base64 = Base64FileTool.FileToBase64(new File("./data/watermark.pdf"));
        System.out.println(base64);
        waterMarkRequire.setWaterMarkPDFBase64(base64);

        pattern.setWaterMarkRequire(waterMarkRequire);
        pattern.setSrcFilePrefix(DefaultDocumentFormatRegistry.PDF);
        pattern.setDestFilePrefix(DefaultDocumentFormatRegistry.PDF);
        String base641 = Base64FileTool.FileToBase64(new File("./data/1.pdf"));
        System.out.println(base641);
        pattern.base64ToBase64(base641);

        boolean result = converter.convert(pattern.getParameter());
        String base64Result = pattern.getBase64Result();
        Base64FileTool.saveBase64File(base64Result, "./data/test6_with_mark03.pdf");
        assertEquals(true, result);

    }
}