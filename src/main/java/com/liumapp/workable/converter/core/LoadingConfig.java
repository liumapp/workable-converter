package com.liumapp.workable.converter.core;

import com.liumapp.qtools.property.core.ConfigurationNode;
import com.liumapp.workable.converter.config.ConverterConfig;

import java.net.URL;

/**
 * file LoadingConfig.java
 * author liumapp
 * github https://github.com/liumapp
 * email liumapp.com@gmail.com
 * homepage http://www.liumapp.com
 * date 2019/5/9
 */
public interface LoadingConfig {

    /**
     * read yml file URL from resource folder, can be application.yml or bootstrap.yml or workable-converter.yml
     */
    ConfigurationNode loadURL () throws Throwable;

    /**
     * loading config params from resource
     */
    ConverterConfig loadConfig (ConfigurationNode node) throws Throwable;

}
