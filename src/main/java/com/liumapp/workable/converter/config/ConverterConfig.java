package com.liumapp.workable.converter.config;

import com.liumapp.workable.converter.core.Parameter;
import lombok.Data;

/**
 * file ConverterConfig.java
 * author liumapp
 * github https://github.com/liumapp
 * email liumapp.com@gmail.com
 * homepage http://www.liumapp.com
 * date 2019/5/9
 */
@Data
public class ConverterConfig implements Parameter {

    /**
     * libreoffice home
     * example: C:\Program Files\LibreOffice
     */
    private String libreofficePath;

    /**
     * libreoffice listen port
     * default: 2002
     */
    private int libreofficePort;

    /**
     * tmp data save path.
     */
    private String tmpPath;

    public ConverterConfig() {
    }

    public ConverterConfig(String libreofficePath, int libreofficePort, String tmpPath) {
        this.libreofficePath = libreofficePath;
        this.libreofficePort = libreofficePort;
        this.tmpPath = tmpPath;
    }

}
