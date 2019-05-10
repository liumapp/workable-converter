package com.liumapp.workable.converter.factory;

import com.liumapp.workable.converter.core.Converter;
import com.liumapp.workable.converter.core.Manager;

/**
 * file WorkableConverterManager.java
 * author liumapp
 * github https://github.com/liumapp
 * email liumapp.com@gmail.com
 * homepage http://www.liumapp.com
 * date 2019/5/9
 */
public abstract class AbstractConverterManager implements Manager {

    protected Converter converter;

    public abstract Converter getConverter ();

}
