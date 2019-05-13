package com.liumapp.workable.converter.templates;

import com.liumapp.workable.converter.config.ConvertRequire;
import com.liumapp.workable.converter.core.ConvertPattern;
import com.liumapp.workable.converter.core.Parameter;
import com.liumapp.workable.converter.core.Templates;
import com.sun.xml.internal.rngom.digested.DDataPattern;

/**
 * file NormalConvertRequireTemplates.java
 * author liumapp
 * github https://github.com/liumapp
 * email liumapp.com@gmail.com
 * homepage http://www.liumapp.com
 * date 2019/5/13
 */
public class NormalConvertRequireTemplates implements Templates, Parameter, ConvertPattern {

    private ConvertPattern require;

    public NormalConvertRequireTemplates(ConvertPattern require) {
        this.require = require;
    }

    @Override
    public void setConvertByFilePathRequire(String srcWaitingConvertFilePath, String destConvertedFilePath) {
        require.setConvertByFilePathRequire(srcWaitingConvertFilePath, destConvertedFilePath);
    }
}
