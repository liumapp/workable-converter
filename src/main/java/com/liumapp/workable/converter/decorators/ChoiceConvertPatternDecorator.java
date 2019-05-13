package com.liumapp.workable.converter.decorators;

import com.liumapp.workable.converter.core.ConvertPattern;
import com.liumapp.workable.converter.templates.NormalConvertRequireTemplates;

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
    public void setConvertByFilePathRequire(String srcWaitingConvertFilePath, String destConvertedFilePath) {
        super.setConvertByFilePathRequire(srcWaitingConvertFilePath, destConvertedFilePath);
    }

}
