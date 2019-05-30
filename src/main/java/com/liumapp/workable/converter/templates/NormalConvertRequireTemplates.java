package com.liumapp.workable.converter.templates;

import com.liumapp.workable.converter.config.WaterMarkRequire;
import com.liumapp.workable.converter.core.ConvertPattern;
import com.liumapp.workable.converter.core.Parameter;
import com.liumapp.workable.converter.core.Templates;
import com.liumapp.workable.converter.enums.Patterns;
import com.liumapp.workable.converter.exceptions.ConvertFailedException;
import org.jodconverter.document.DocumentFormat;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;


/**
 * file NormalConvertRequireTemplates.java
 * author liumapp
 * github https://github.com/liumapp
 * email liumapp.com@gmail.com
 * homepage http://www.liumapp.com
 * date 2019/5/13
 */
public class NormalConvertRequireTemplates implements Templates, Parameter, ConvertPattern {

    protected ConvertPattern require;

    public NormalConvertRequireTemplates(ConvertPattern require) {
        this.require = require;
    }

    @Override
    public void setConvertByFilePathRequire(String srcWaitingConvertFilePath, String destConvertedFilePath) throws ConvertFailedException {
        require.setConvertByFilePathRequire(srcWaitingConvertFilePath, destConvertedFilePath);
    }

    @Override
    public void fileToFile(String srcWaitingConvertFilePath, String destConvertedFilePath) throws ConvertFailedException {
        require.fileToFile(srcWaitingConvertFilePath, destConvertedFilePath);
    }

    @Override
    public void fileToFiles(String srcWaitingConvertFilePath, String destConvertedPath) throws ConvertFailedException {
        require.fileToFiles(srcWaitingConvertFilePath, destConvertedPath);
    }

    @Override
    public void setConvertByStream(InputStream srcStream, OutputStream destStream) throws ConvertFailedException {
        require.setConvertByStream(srcStream, destStream);
    }

    @Override
    public void streamToStream(InputStream srcStream, OutputStream destStream) throws ConvertFailedException {
        require.streamToStream(srcStream, destStream);
    }

    @Override
    public String getBase64Result() {
        return require.getBase64Result();
    }

    @Override
    public List<String> getBase64Results() {
        return require.getBase64Results();
    }

    @Override
    public void setConvertByBase64(String srcBase64) throws ConvertFailedException {
        require.setConvertByBase64(srcBase64);
    }

    @Override
    public void base64ToBase64(String srcBase64) throws ConvertFailedException {
        require.base64ToBase64(srcBase64);
    }

    @Override
    public void choicePatterns(Patterns patterns) {
        require.choicePatterns(patterns);
    }

    @Override
    public void setSrcFilePrefix(DocumentFormat formatRegistry) {
        require.setSrcFilePrefix(formatRegistry);
    }

    @Override
    public void setDestFilePrefix(DocumentFormat formatRegistry) {
        require.setDestFilePrefix(formatRegistry);
    }

    @Override
    public void setWaterMarkRequire(WaterMarkRequire waterMarkRequire) {
        require.setWaterMarkRequire(waterMarkRequire);
    }

    @Override
    public Parameter getParameter() {
        return require.getParameter();
    }

}
