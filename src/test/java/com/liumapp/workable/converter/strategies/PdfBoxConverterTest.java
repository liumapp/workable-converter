package com.liumapp.workable.converter.strategies;

import com.liumapp.qtools.file.base64.Base64FileTool;
import com.liumapp.qtools.file.basic.FileTool;
import com.liumapp.workable.converter.WorkableConverter;
import com.liumapp.workable.converter.core.ConvertPattern;
import com.liumapp.workable.converter.exceptions.ConvertFailedException;
import com.liumapp.workable.converter.factory.ConvertPatternManager;
import com.liumapp.workable.converter.factory.PdfBoxConverterManager;
import org.jodconverter.document.DefaultDocumentFormatRegistry;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.List;

import static org.junit.Assert.*;

/**
 * file PdfBoxConverterTest.java
 * author liumapp
 * github https://github.com/liumapp
 * email liumapp.com@gmail.com
 * homepage http://www.liumapp.com
 * date 2019/5/16
 */
public class PdfBoxConverterTest {

    @Test
    public void byFilePath() throws ConvertFailedException {
        WorkableConverter converter = new WorkableConverter();
        ConvertPattern pattern = ConvertPatternManager.getInstance();
        pattern.fileToFiles("./data/test5.pdf", "./data/");
        pattern.setSrcFilePrefix(DefaultDocumentFormatRegistry.PDF);
        pattern.setDestFilePrefix(DefaultDocumentFormatRegistry.PNG);
        converter.setConverterType(PdfBoxConverterManager.getInstance()); // pdf box converter manager only support pdf to png
        assertEquals(true, converter.convert(pattern.getParameter()));

        assertEquals(true, FileTool.isFileExists("./data/test5_0.png"));
        assertEquals(true, FileTool.isFileExists("./data/test5_1.png"));
        assertEquals(true, FileTool.isFileExists("./data/test5_2.png"));
        assertEquals(true, FileTool.isFileExists("./data/test5_3.png"));
    }

    @Test
    public void byBase64() throws IOException, ConvertFailedException {
        WorkableConverter converter = new WorkableConverter();
        ConvertPattern pattern = ConvertPatternManager.getInstance();
        pattern.base64ToBase64(Base64FileTool.FileToBase64(new File("./data/test5.pdf")));
        pattern.setSrcFilePrefix(DefaultDocumentFormatRegistry.PDF);
        pattern.setDestFilePrefix(DefaultDocumentFormatRegistry.PNG);
        converter.setConverterType(PdfBoxConverterManager.getInstance()); // pdf box converter manager only support pdf to png
        boolean result = converter.convert(pattern.getParameter());
        List<String> resultBase64 = pattern.getBase64Results();

        assertEquals(true, result);
        assertEquals(4, resultBase64.size());
    }

    /**
     * todo
     */
    @Test
    public void byStream() {

    }
}