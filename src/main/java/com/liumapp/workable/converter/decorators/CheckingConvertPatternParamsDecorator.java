package com.liumapp.workable.converter.decorators;

import com.liumapp.qtools.file.basic.FileTool;
import com.liumapp.qtools.str.basic.StrTool;
import com.liumapp.workable.converter.config.ConvertRequire;
import com.liumapp.workable.converter.core.ConvertPattern;
import com.liumapp.workable.converter.exceptions.ConvertFailedException;
import com.liumapp.workable.converter.exceptions.UnsupportedConverterParameterException;
import com.liumapp.workable.converter.templates.NormalConvertRequireTemplates;
import org.jodconverter.document.DocumentFormat;

import java.io.InputStream;
import java.io.OutputStream;

/**
 * file CheckingConvertPatternParamsDecorator.java
 * author liumapp
 * github https://github.com/liumapp
 * email liumapp.com@gmail.com
 * homepage http://www.liumapp.com
 * date 2019/5/13
 */
public class CheckingConvertPatternParamsDecorator extends NormalConvertRequireTemplates {

    public CheckingConvertPatternParamsDecorator(ConvertPattern require) {
        super(require);
    }

    /**
     * check the path is a file ?
     * if the result file existed, then delete
     */
    @Override
    public void setConvertByFilePathRequire(String srcWaitingConvertFilePath, String destConvertedFilePath) throws ConvertFailedException {
        if (StrTool.isSpace(srcWaitingConvertFilePath) || StrTool.isSpace(destConvertedFilePath)) throw new ConvertFailedException("src waiting path and dest conveted path can not be null or empty");
        if (FileTool.isDirectory(srcWaitingConvertFilePath)) throw new ConvertFailedException(srcWaitingConvertFilePath + "must be a file path , and can not be a folder");
        if (FileTool.isDirectory(destConvertedFilePath)) throw new ConvertFailedException(destConvertedFilePath + "must be file path , and can not be a folder ");
        if (FileTool.isFileExists(destConvertedFilePath)) FileTool.deleteFile(destConvertedFilePath);
        super.setConvertByFilePathRequire(srcWaitingConvertFilePath, destConvertedFilePath);
    }

    @Override
    public void fileToFile(String srcWaitingConvertFilePath, String destConvertedFilePath) throws ConvertFailedException {
        if (StrTool.isSpace(srcWaitingConvertFilePath) || StrTool.isSpace(destConvertedFilePath)) throw new ConvertFailedException("src waiting path and dest conveted path can not be null or empty");
        if (FileTool.isDirectory(srcWaitingConvertFilePath)) throw new ConvertFailedException(srcWaitingConvertFilePath + "must be a file path , and can not be a folder");
        if (FileTool.isDirectory(destConvertedFilePath)) throw new ConvertFailedException(destConvertedFilePath + "must be file path , and can not be a folder ");
        if (FileTool.isFileExists(destConvertedFilePath)) FileTool.deleteFile(destConvertedFilePath);
        super.fileToFile(srcWaitingConvertFilePath, destConvertedFilePath);
    }

    /**
     * check the dest converted path is a folder ?
     */
    @Override
    public void fileToFiles(String srcWaitingConvertFilePath, String destConvertedPath) throws ConvertFailedException {
        if (StrTool.isSpace(srcWaitingConvertFilePath) || StrTool.isSpace(destConvertedPath)) throw new ConvertFailedException("src waiting path and dest conveted path can not be null or empty");
        if (FileTool.isDirectory(srcWaitingConvertFilePath)) throw new ConvertFailedException(srcWaitingConvertFilePath + "must be a file path , and can not be a folder");
        if (!FileTool.isDirectory(destConvertedPath)) throw new ConvertFailedException(destConvertedPath + "must be a folder , and can not be a file");
        super.fileToFiles(srcWaitingConvertFilePath, destConvertedPath);
    }

    /**
     * check not null
     */
    @Override
    public void setConvertByStream(InputStream srcStream, OutputStream destStream) throws ConvertFailedException {
        if (srcStream == null || destStream == null) throw new ConvertFailedException("src stream or dest stream can not be null");
        super.setConvertByStream(srcStream, destStream);
    }

    @Override
    public void streamToStream(InputStream srcStream, OutputStream destStream) throws ConvertFailedException {
        if (srcStream == null || destStream == null) throw new ConvertFailedException("src stream or dest stream can not be null");
        super.streamToStream(srcStream, destStream);
    }

    @Override
    public void setConvertByBase64(String srcBase64) throws ConvertFailedException {
        if (srcBase64 == null) throw new ConvertFailedException("src base64 can not be null");
        super.setConvertByBase64(srcBase64);
    }

    @Override
    public void base64ToBase64(String srcBase64) throws ConvertFailedException {
        if (srcBase64 == null)
            throw new ConvertFailedException("src base64 can not be null");
        super.base64ToBase64(srcBase64);
    }

    @Override
    public void setSrcFilePrefix(DocumentFormat formatRegistry) throws UnsupportedConverterParameterException {
        if (formatRegistry == null) throw new UnsupportedConverterParameterException("src format registry can not be null");
        super.setSrcFilePrefix(formatRegistry);
    }

    @Override
    public void setDestFilePrefix(DocumentFormat formatRegistry) throws UnsupportedConverterParameterException {
        if (formatRegistry == null) throw new UnsupportedConverterParameterException("dest format registry can not be null");
        super.setDestFilePrefix(formatRegistry);
    }
}
