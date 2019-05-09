package com.liumapp.workable.converter.templates;

import com.liumapp.workable.converter.config.ConverterConfig;
import com.liumapp.workable.converter.core.LoadingConfig;

import java.net.URL;

/**
 * file NormalConverterConfigLoaderTemplate.java
 * author liumapp
 * github https://github.com/liumapp
 * email liumapp.com@gmail.com
 * homepage http://www.liumapp.com
 * date 2019/5/9
 */
public class NormalConverterConfigLoaderTemplate implements LoadingConfig {

    private LoadingConfig loadingConfig;

    public NormalConverterConfigLoaderTemplate(LoadingConfig loadingConfig) {
        this.loadingConfig = loadingConfig;
    }

    @Override
    public URL loadURL() {
        return loadingConfig.loadURL();
    }

    @Override
    public ConverterConfig loadConfig(URL url) {
        return loadingConfig.loadConfig(url);
    }


}
