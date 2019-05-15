package com.liumapp.workable.converter.decorators;

import com.liumapp.workable.converter.core.ConvertPattern;
import com.liumapp.workable.converter.enums.Patterns;
import com.liumapp.workable.converter.exceptions.ConvertFailedException;
import com.liumapp.workable.converter.templates.NormalConvertRequireTemplates;

import java.io.InputStream;
import java.io.OutputStream;

/**
 * file ChoiceConvertPatternDecorator.java
 * author liumapp
 * github https://github.com/liumapp
 * email liumapp.com@gmail.com
 * homepage http://www.liumapp.com
 * date 2019/5/13
 */
public class ChoiceConvertPatternDecorator extends NormalConvertRequireTemplates {

    public ChoiceConvertPatternDecorator(ConvertPattern require) {
        super(require);
    }

    @Override
    public void setConvertByFilePathRequire(String srcWaitingConvertFilePath, String destConvertedFilePath) throws ConvertFailedException {
        this.choicePatterns(Patterns.By_File_Path);
        super.setConvertByFilePathRequire(srcWaitingConvertFilePath, destConvertedFilePath);
    }

    @Override
    public void setConvertByStream(InputStream srcStream, OutputStream destStream) {
        this.choicePatterns(Patterns.By_Stream);
        super.setConvertByStream(srcStream, destStream);
    }

    @Override
    public void setConvertByBase64(String srcBase64, String destBase64) {
        this.choicePatterns(Patterns.By_Base64);
        super.setConvertByBase64(srcBase64, destBase64);
    }

    @Override
    public void choicePatterns(Patterns patterns) {
        super.choicePatterns(patterns);
    }
}
