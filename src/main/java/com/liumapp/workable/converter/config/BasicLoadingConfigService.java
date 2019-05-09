package com.liumapp.workable.converter.config;

import com.liumapp.workable.converter.core.LoadingConfig;

import java.net.URL;

/**
 * file BasicLoadingConfigService.java
 * author liumapp
 * github https://github.com/liumapp
 * email liumapp.com@gmail.com
 * homepage http://www.liumapp.com
 * date 2019/5/9
 */
public class BasicLoadingConfigService implements LoadingConfig {

    @Override
    public URL loadURL() {

        return null;
    }

    @Override
    public ConverterConfig loadConfig(URL url) {
        return null;
    }


}
