package com.liumapp.workable.converter.templates;

import com.liumapp.workable.converter.core.ConvertPattern;
import com.liumapp.workable.converter.core.Parameter;
import com.liumapp.workable.converter.core.Templates;
import com.liumapp.workable.converter.enums.Patterns;
import com.liumapp.workable.converter.exceptions.ConvertFailedException;
import org.jodconverter.document.DocumentFormat;

import java.io.InputStream;
import java.io.OutputStream;


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
    public void setConvertByFilePathRequire(String srcWaitingConvertFilePath, String destConvertedPath, boolean deleteTmp) throws ConvertFailedException {
        require.setConvertByFilePathRequire(srcWaitingConvertFilePath, destConvertedPath, deleteTmp);
    }

    @Override
    public void setConvertByStream(InputStream srcStream, OutputStream destStream) {
        require.setConvertByStream(srcStream, destStream);
    }

    @Override
    public String getBase64Result() {
        return require.getBase64Result();
    }

    @Override
    public void setConvertByBase64(String srcBase64) {
        require.setConvertByBase64(srcBase64);
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
    public Parameter getParameter() {
        return require.getParameter();
    }
}
