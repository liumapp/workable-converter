package com.liumapp.workable.converter.strategies;

import com.liumapp.workable.converter.WorkableConverter;
import com.liumapp.workable.converter.config.WaterMarkRequire;
import com.liumapp.workable.converter.core.ConvertPattern;
import com.liumapp.workable.converter.factory.ConvertPatternManager;
import org.junit.Test;

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

    @Test
    public void byFilePath() {
        WorkableConverter converter = new WorkableConverter();
        ConvertPattern pattern = ConvertPatternManager.getInstance();
        pattern.setWaterMarkRequire(new WaterMarkRequire());
    }

    @Test
    public void byStream() {
    }

    @Test
    public void byBase64() {
    }
}