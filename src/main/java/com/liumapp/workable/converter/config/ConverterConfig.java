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
     * the save path for converted pdf file
     */
    private String pdfSavePath;

    /**
     * the save path for converted picture
     */
    private String picSavePath;

    /**
     * the save path for the file which is waiting to be converted
     */
    private String waitedSavePath;

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

    public ConverterConfig() {
    }

    public ConverterConfig(String pdfSavePath, String picSavePath, String waitedSavePath, String libreofficePath, int libreofficePort) {
        this.pdfSavePath = pdfSavePath;
        this.picSavePath = picSavePath;
        this.waitedSavePath = waitedSavePath;
        this.libreofficePath = libreofficePath;
        this.libreofficePort = libreofficePort;
    }
}
