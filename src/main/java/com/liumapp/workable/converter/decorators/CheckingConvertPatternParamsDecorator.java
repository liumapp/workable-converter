package com.liumapp.workable.converter.decorators;

import com.liumapp.qtools.file.basic.FileTool;
import com.liumapp.qtools.str.basic.StrTool;
import com.liumapp.workable.converter.config.ConvertRequire;
import com.liumapp.workable.converter.core.ConvertPattern;
import com.liumapp.workable.converter.exceptions.ConvertFailedException;
import com.liumapp.workable.converter.templates.NormalConvertRequireTemplates;

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

}
