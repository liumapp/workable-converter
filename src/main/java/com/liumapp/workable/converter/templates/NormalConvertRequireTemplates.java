package com.liumapp.workable.converter.templates;

import com.liumapp.workable.converter.config.ConvertRequire;
import com.liumapp.workable.converter.core.ConvertPattern;
import com.liumapp.workable.converter.core.Parameter;
import com.liumapp.workable.converter.core.Templates;
import com.liumapp.workable.converter.enums.Patterns;
import com.liumapp.workable.converter.exceptions.ConvertFailedException;
import org.jodconverter.document.DefaultDocumentFormatRegistry;


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
    public void choicePatterns(Patterns patterns) {
        require.choicePatterns(patterns);
    }

    @Override
    public void setSrcFilePrefix(DefaultDocumentFormatRegistry formatRegistry) {
        require.setSrcFilePrefix(formatRegistry);
    }

    @Override
    public void setDestFilePrefix(DefaultDocumentFormatRegistry formatRegistry) {
        require.setDestFilePrefix(formatRegistry);
    }

    @Override
    public Parameter getParameter() {
        return require.getParameter();
    }
}
