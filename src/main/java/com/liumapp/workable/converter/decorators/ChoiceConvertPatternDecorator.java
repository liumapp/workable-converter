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
        this.choicePatterns(Patterns.By_File_To_File);
        super.setConvertByFilePathRequire(srcWaitingConvertFilePath, destConvertedFilePath);
    }

    @Override
    public void fileToFile(String srcWaitingConvertFilePath, String destConvertedFilePath) throws ConvertFailedException {
        this.choicePatterns(Patterns.By_File_To_File);
        super.fileToFile(srcWaitingConvertFilePath, destConvertedFilePath);
    }

    @Override
    public void fileToFiles(String srcWaitingConvertFilePath, String destConvertedPath) throws ConvertFailedException {
        this.choicePatterns(Patterns.By_File_To_Folder);
        super.fileToFiles(srcWaitingConvertFilePath, destConvertedPath);
    }

    @Override
    public void setConvertByStream(InputStream srcStream, OutputStream destStream) throws ConvertFailedException {
        this.choicePatterns(Patterns.By_Stream);
        super.setConvertByStream(srcStream, destStream);
    }

    @Override
    public void streamToStream(InputStream srcStream, OutputStream destStream) throws ConvertFailedException {
        this.choicePatterns(Patterns.By_Stream);
        super.streamToStream(srcStream, destStream);
    }

    @Override
    public void setConvertByBase64(String srcBase64) throws ConvertFailedException {
        this.choicePatterns(Patterns.By_Base64);
        super.setConvertByBase64(srcBase64);
    }

    @Override
    public void base64ToBase64(String srcBase64) throws ConvertFailedException {
        this.choicePatterns(Patterns.By_Base64);
        super.base64ToBase64(srcBase64);
    }

    @Override
    public void choicePatterns(Patterns patterns) {
        super.choicePatterns(patterns);
    }
}
