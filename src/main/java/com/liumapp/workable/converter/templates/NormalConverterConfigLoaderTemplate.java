package com.liumapp.workable.converter.templates;

import com.liumapp.qtools.property.core.ConfigurationNode;
import com.liumapp.workable.converter.config.ConverterConfig;
import com.liumapp.workable.converter.core.LoadingConfig;
import com.liumapp.workable.converter.core.Templates;

import java.net.URL;

/**
 * file NormalConverterConfigLoaderTemplate.java
 * author liumapp
 * github https://github.com/liumapp
 * email liumapp.com@gmail.com
 * homepage http://www.liumapp.com
 * date 2019/5/9
 */
public abstract class NormalConverterConfigLoaderTemplate implements LoadingConfig, Templates {

    private LoadingConfig loadingConfig;

    public NormalConverterConfigLoaderTemplate(LoadingConfig loadingConfig) {
        this.loadingConfig = loadingConfig;
    }

    @Override
    public ConfigurationNode loadURL() throws Throwable {
        return loadingConfig.loadURL();
    }

    @Override
    public ConverterConfig loadConfig(ConfigurationNode node) throws Throwable {
        return loadingConfig.loadConfig(node);
    }


}
