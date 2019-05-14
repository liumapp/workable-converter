package com.liumapp.workable.converter.core;

import com.liumapp.workable.converter.enums.Patterns;
import com.liumapp.workable.converter.exceptions.ConvertFailedException;

/**
 * file ConvertPattern.java
 * author liumapp
 * github https://github.com/liumapp
 * email liumapp.com@gmail.com
 * homepage http://www.liumapp.com
 * date 2019/5/13
 */
public interface ConvertPattern extends Parameter {

    public void setConvertByFilePathRequire (String srcWaitingConvertFilePath, String destConvertedFilePath) throws ConvertFailedException;

    public void choicePatterns (Patterns patterns);

    public Parameter getParameter ();

}
