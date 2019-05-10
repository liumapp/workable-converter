package com.liumapp.workable.converter.factory;

import com.liumapp.workable.converter.config.BasicLoadingConfigService;
import com.liumapp.workable.converter.config.ConverterConfig;
import com.liumapp.workable.converter.core.LoadingConfig;
import com.liumapp.workable.converter.core.Manager;
import com.liumapp.workable.converter.decorators.BuildingDefaultParamsConfig;
import com.liumapp.workable.converter.decorators.CheckingUrlSourceForParamsConfig;

/**
 * file ConverterConfigManager.java
 * author liumapp
 * github https://github.com/liumapp
 * email liumapp.com@gmail.com
 * homepage http://www.liumapp.com
 * date 2019/5/9
 */
public class ConverterConfigManager implements Manager {

    private static ConverterConfigManager INSTANCE;

    /**
     * the params can not be changed , setting by config file
     */
    private ConverterConfig params;

    private ConverterConfigManager () {
    }

    public static ConverterConfigManager getInstance() throws Throwable {
        if (INSTANCE == null) {
            INSTANCE = new ConverterConfigManager();
            buildingConverterConfig(INSTANCE);
        }
        return INSTANCE;
    }

    public ConverterConfig getParams() {
        return params;
    }

    /**
     * building config params by decorator mode .
     */
    private static void buildingConverterConfig (ConverterConfigManager INSTANCE) throws Throwable {
        LoadingConfig service = new CheckingUrlSourceForParamsConfig(new BuildingDefaultParamsConfig(new BasicLoadingConfigService()));
        INSTANCE.params = service.loadConfig(service.loadURL());
    }
}
