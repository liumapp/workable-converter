package com.liumapp.workable.converter.decorators;

import com.liumapp.qtools.property.core.ConfigurationNode;
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

    /**
     * check application.yml and bootstrap.yml, if it has the config that i need .
     * it no application.yml and no bootstrap.yml i need , check if there is a file named workable-converter.yml
     */
    @Override
    public ConfigurationNode loadURL() throws Throwable {
        URL url1 = getClass().getResource("application.yml");
        URL url2 = getClass().getResource("bootstrap.yml");
        if (url1 == null && url2 == null) {
            return super.loadURL();
        }
        return super.loadURL();
    }
}
