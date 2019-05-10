package com.liumapp.workable.converter;

import com.liumapp.workable.converter.core.Converter;
import com.liumapp.workable.converter.factory.ConverterConfigManager;
import lombok.Data;

/**
 * file WorkableConverter.java
 * author liumapp
 * github https://github.com/liumapp
 * email liumapp.com@gmail.com
 * homepage http://www.liumapp.com
 * date 2019/5/9
 */
@Data
public class WorkableConverter {

    private Converter convert;

    private ConverterConfigManager converterConfigManager;

}
