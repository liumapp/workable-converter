package com.liumapp.workable.converter.decorators;

import com.liumapp.workable.converter.config.ConverterConfig;
import com.liumapp.workable.converter.core.LoadingConfig;
import com.liumapp.workable.converter.templates.NormalConverterConfigLoaderTemplate;

import java.net.URL;

/**
 * file BuildingDefaultParamsConfig.java
 * author liumapp
 * github https://github.com/liumapp
 * email liumapp.com@gmail.com
 * homepage http://www.liumapp.com
 * date 2019/5/9
 */
public class BuildingDefaultParamsConfig extends NormalConverterConfigLoaderTemplate {

    public BuildingDefaultParamsConfig(LoadingConfig loadingConfig) {
        super(loadingConfig);
    }

    @Override
    public ConverterConfig loadConfig(URL url) throws Throwable {
        return super.loadConfig(url);
    }
}
