package com.liumapp.workable.converter.factory;

import com.liumapp.workable.converter.config.ConverterConfig;
import org.junit.Test;

import static org.junit.Assert.*;

public class ConverterConfigManagerTest {

    @Test
    public void getParams() {
        ConverterConfig params = null;
        try {
            params = ConverterConfigManager.getInstance().getParams();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        assertEquals("/Applications/LibreOffice.app/Contents", params.getLibreofficePath());
        assertEquals("./data/", params.getTmpPath());
        assertEquals(2002, params.getLibreofficePort());
    }
}