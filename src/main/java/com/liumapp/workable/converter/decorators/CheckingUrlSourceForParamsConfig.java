package com.liumapp.workable.converter.decorators;

import com.liumapp.workable.converter.core.LoadingConfig;
import com.liumapp.workable.converter.templates.NormalConverterConfigLoaderTemplate;

import java.net.URL;

/**
 * file CheckingUrlSourceForParamsConfig.java
 * author liumapp
 * github https://github.com/liumapp
 * email liumapp.com@gmail.com
 * homepage http://www.liumapp.com
 * date 2019/5/9
 */
public class CheckingUrlSourceForParamsConfig extends NormalConverterConfigLoaderTemplate {

    public CheckingUrlSourceForParamsConfig(LoadingConfig loadingConfig) {
        super(loadingConfig);
    }

    @Override
    public URL loadURL() {
        return super.loadURL();
    }
}
