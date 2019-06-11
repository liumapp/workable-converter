package com.liumapp.workable.converter.factory;

import com.liumapp.workable.converter.config.ConvertRequire;
import com.liumapp.workable.converter.core.ConvertPattern;
import com.liumapp.workable.converter.core.Manager;
import com.liumapp.workable.converter.decorators.CheckingConvertPatternParamsDecorator;
import com.liumapp.workable.converter.decorators.ChoiceConvertPatternDecorator;

/**
 * file ConvertPatternManager.java
 * author liumapp
 * github https://github.com/liumapp
 * email liumapp.com@gmail.com
 * homepage http://www.liumapp.com
 * date 2019/5/14
 */
public class ConvertPatternManager implements Manager {

    private ConvertPatternManager() {
    }

    public static synchronized ConvertPattern getInstance () {
        return new CheckingConvertPatternParamsDecorator(new ChoiceConvertPatternDecorator(new ConvertRequire()));
    }


    public static synchronized ConvertPattern getTextInstance () {
        return new CheckingConvertPatternParamsDecorator(new ChoiceConvertPatternDecorator(new ConvertRequire()));
    }
}
