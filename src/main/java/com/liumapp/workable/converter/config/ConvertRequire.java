package com.liumapp.workable.converter.config;

import com.liumapp.workable.converter.core.Parameter;
import lombok.Data;

import java.io.File;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

/**
 * file ConvertRequire.java
 * author liumapp
 * github https://github.com/liumapp
 * email liumapp.com@gmail.com
 * homepage http://www.liumapp.com
 * date 2019/5/10
 */
@Data
public class ConvertRequire implements Parameter {

    /**
     * the file path waiting to convert
     */
    private String waitingFilePath;

    /**
     * the File object waiting to convert
     */
    private File waitingFile;

    /**
     * the pic files path waiting to convert
     */
    private List<String> picsFilePath;

    /**
     * the pic File objects waiting to convert
     */
    private List<File> picsFile;

    /**
     * the pic files base64 values waiting to convert
     */
    private List<String> picsBase64;

    /**
     * the input stream waiting to convert
     */
    private InputStream waitingIS;

    /**
     * the output stream which had been converted
     */
    private OutputStream resultOS;

    /**
     * the file base64 waiting to convert
     */
    private String waitingBase64;

}
