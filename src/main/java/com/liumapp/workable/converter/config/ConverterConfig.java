package com.liumapp.workable.converter.config;

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
public class ConverterConfig {

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

}
