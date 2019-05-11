package com.liumapp.workable.converter.factory;

import com.liumapp.workable.converter.core.Manager;
import org.jodconverter.office.LocalOfficeManager;
import org.jodconverter.office.OfficeException;
import org.jodconverter.office.OfficeManager;

/**
 * file ConverterOfficeManager.java
 * author liumapp
 * github https://github.com/liumapp
 * email liumapp.com@gmail.com
 * homepage http://www.liumapp.com
 * date 2019/5/11
 */
public class ConverterOfficeManager implements Manager {

    private static class ConverterOfficeManagerHolder {
        private static final OfficeManager INSTANCE = LocalOfficeManager.builder()
                .install()
                .portNumbers(ConverterConfigManager.getInstance().getParams().getLibreofficePort())
                .officeHome(ConverterConfigManager.getInstance().getParams().getLibreofficePath())
                .build();
    }

    private ConverterOfficeManager() {
    }

    public static OfficeManager getInstance () {
        return ConverterOfficeManagerHolder.INSTANCE;
    }



}
