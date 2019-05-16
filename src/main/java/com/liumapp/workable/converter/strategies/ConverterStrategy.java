package com.liumapp.workable.converter.strategies;

import com.liumapp.workable.converter.config.ConvertRequire;
import com.liumapp.workable.converter.core.Converter;
import com.liumapp.workable.converter.exceptions.ConvertFailedException;

/**
 * file ConverterStrategy.java
 * author liumapp
 * github https://github.com/liumapp
 * email liumapp.com@gmail.com
 * homepage http://www.liumapp.com
 * date 2019/5/10
 */
public abstract class ConverterStrategy implements Converter {

    protected abstract boolean accordingRequire(ConvertRequire require) throws ConvertFailedException;

    protected abstract boolean byFilePath (ConvertRequire require) throws ConvertFailedException;

    protected abstract boolean byStream (ConvertRequire require) throws ConvertFailedException;

    protected abstract boolean byBase64 (ConvertRequire require) throws ConvertFailedException;

}
