package com.liumapp.workable.converter.core;

import com.liumapp.workable.converter.exceptions.ConvertFailedException;

/**
 * file Convert.java
 * author liumapp
 * github https://github.com/liumapp
 * email liumapp.com@gmail.com
 * homepage http://www.liumapp.com
 * date 2019/5/10
 */
public interface Converter {

    <T> T convert (Parameter require) throws ConvertFailedException;

}
