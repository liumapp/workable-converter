package com.liumapp.workable.converter.strategies;

import com.liumapp.qtools.file.base64.Base64FileTool;
import com.liumapp.workable.converter.WorkableConverter;
import com.liumapp.workable.converter.config.WaterMarkRequire;
import com.liumapp.workable.converter.core.ConvertPattern;
import com.liumapp.workable.converter.factory.ConvertPatternManager;
import org.jodconverter.document.DefaultDocumentFormatRegistry;
import org.junit.Test;

import java.io.File;
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
    public void byFilePath() throws IOException{
        WorkableConverter converter = new WorkableConverter();

        ConvertPattern pattern = ConvertPatternManager.getInstance();

        WaterMarkRequire waterMarkRequire = new WaterMarkRequire();
        waterMarkRequire.setWaterMarkPage(1);
        waterMarkRequire.setWaterMarkPicBase64(Base64FileTool.FileToBase64(new File("./data/watermark01.png")));

        pattern.setWaterMarkRequire(waterMarkRequire);
        pattern.setSrcFilePrefix(DefaultDocumentFormatRegistry.PDF);
        pattern.setDestFilePrefix(DefaultDocumentFormatRegistry.PDF);


    }

    @Test
    public void byStream() {
    }

    @Test
    public void byBase64() {
    }
}