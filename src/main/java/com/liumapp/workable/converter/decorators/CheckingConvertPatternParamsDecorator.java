package com.liumapp.workable.converter.decorators;

import com.liumapp.qtools.file.basic.FileTool;
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
     */
    @Override
    public void setConvertByFilePathRequire(String srcWaitingConvertFilePath, String destConvertedFilePath) throws ConvertFailedException {
        if (FileTool.isDirectory(srcWaitingConvertFilePath)) throw new ConvertFailedException(srcWaitingConvertFilePath + "must be a file path , can not be a folder");
        super.setConvertByFilePathRequire(srcWaitingConvertFilePath, destConvertedFilePath);
    }

}
