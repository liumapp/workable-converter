package com.liumapp.workable.converter.strategies;

import com.liumapp.qtools.file.basic.FileTool;
import com.liumapp.workable.converter.WorkableConverter;
import com.liumapp.workable.converter.core.ConvertPattern;
import com.liumapp.workable.converter.exceptions.ConvertFailedException;
import com.liumapp.workable.converter.factory.ConvertPatternManager;
import com.liumapp.workable.converter.factory.PdfBoxConverterManager;
import org.jodconverter.document.DefaultDocumentFormatRegistry;
import org.junit.Test;

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
        converter.setConverterType(PdfBoxConverterManager.getInstance());
        assertEquals(true, converter.convert(pattern.getParameter()));
        assertEquals(true, FileTool.isFileExists("./data/test5_1.png"));
        assertEquals(true, FileTool.isFileExists("./data/test5_2.png"));
        assertEquals(true, FileTool.isFileExists("./data/test5_3.png"));
        assertEquals(true, FileTool.isFileExists("./data/test5_4.png"));
    }

    @Test
    public void byStream() {
    }

    @Test
    public void byBase64() {
    }
}