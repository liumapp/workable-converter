package com.liumapp.workable.converter.config;

import com.liumapp.workable.converter.core.ConvertPattern;
import com.liumapp.workable.converter.core.Parameter;
import com.liumapp.workable.converter.enums.Patterns;
import com.liumapp.workable.converter.exceptions.ConvertFailedException;
import lombok.Getter;
import lombok.Setter;
import org.jodconverter.document.DocumentFormat;

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
     * the file base64 to be convert
     */
    private String srcBase64;

    /**
     * the converted file base64
     */
    @Setter
    private String destBase64;

    /**
     * the file save path which had been converted.
     */
    private String resultFilePath;

    private Patterns patterns;

    private DocumentFormat srcFormat;

    private DocumentFormat destFormat;

    private InputStream srcStream;

    private OutputStream destStream;

    /**
     * the folder to save file which had been converted
     */
    private String destConvertedPath;

    public ConvertRequire() {

    }

    /**
     * set the necessary parameters in convert by file path
     */
    @Override
    public void setConvertByFilePathRequire (String srcWaitingConvertFilePath, String destConvertedFilePath) throws ConvertFailedException {
        this.waitingFilePath = srcWaitingConvertFilePath;
        this.resultFilePath = destConvertedFilePath;
    }

    @Override
    public void fileToFile(String srcWaitingConvertFilePath, String destConvertedFilePath) throws ConvertFailedException {
        this.waitingFilePath = srcWaitingConvertFilePath;
        this.resultFilePath = destConvertedFilePath;
    }

    @Override
    public void fileToFiles(String srcWaitingConvertFilePath, String destConvertedPath) throws ConvertFailedException {
        this.waitingFilePath = srcWaitingConvertFilePath;
        this.destConvertedPath = destConvertedPath;
    }

    @Override
    public void setConvertByStream(InputStream srcStream, OutputStream destStream) {
        this.srcStream = srcStream;
        this.destStream = destStream;
    }

    @Override
    public void streamToStream(InputStream srcStream, OutputStream destStream) {
        this.srcStream = srcStream;
        this.destStream = destStream;
    }

    @Override
    public String getBase64Result() {
        return this.destBase64;
    }

    @Override
    public void setConvertByBase64(String srcBase64) {
        this.srcBase64 = srcBase64;
    }

    @Override
    public void base64ToBase64(String srcBase64) {
        this.srcBase64 = srcBase64;
    }

    @Override
    public void choicePatterns(Patterns patterns) {
        this.patterns = patterns;
    }

    @Override
    public void setSrcFilePrefix(DocumentFormat formatRegistry) {
        this.srcFormat = formatRegistry;
    }

    @Override
    public void setDestFilePrefix(DocumentFormat formatRegistry) {
        this.destFormat = formatRegistry;
    }

    @Override
    public Parameter getParameter() {
        return this;
    }

}
