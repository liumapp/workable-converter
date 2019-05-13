package com.liumapp.workable.converter.config;

import com.liumapp.workable.converter.core.ConvertPattern;
import com.liumapp.workable.converter.core.Parameter;
import com.liumapp.workable.converter.decorators.CheckingConvertPatternParamsDecorator;
import com.liumapp.workable.converter.decorators.ChoiceConvertPatternDecorator;
import lombok.Getter;

import java.io.File;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.util.List;

/**
 * file ConvertRequire.java
 * author liumapp
 * github https://github.com/liumapp
 * email liumapp.com@gmail.com
 * homepage http://www.liumapp.com
 * date 2019/5/10
 */
@Getter
public class ConvertRequire implements Parameter, Serializable, ConvertPattern {

    private static final long serialVersionUID = 4920538182932714034L;

    /**
     * the file path waiting to convert
     */
    private String waitingFilePath;

    /**
     * the file name list waiting to be convert
     */
    private List<String> waitingFileNameList;

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

    /**
     * the file save path which had been converted.
     */
    private String resultFilePath;

    private File inputFile;

    private File outputFile;

    private ConvertRequire() {

    }

    public static ConvertRequire getConvertRequire() {
        ConvertPattern pattern = new CheckingConvertPatternParamsDecorator(new ChoiceConvertPatternDecorator(new ConvertRequire()));
        return (ConvertRequire) pattern;
    }

    /**
     * set the necessary parameters in convert by file path
     */
    @Override
    public void setConvertByFilePathRequire (String srcWaitingConvertFilePath, String destConvertedFilePath) {
        this.waitingFilePath = srcWaitingConvertFilePath;
        this.resultFilePath = destConvertedFilePath;
    }

}
