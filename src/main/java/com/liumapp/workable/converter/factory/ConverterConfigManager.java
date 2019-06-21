package com.liumapp.workable.converter.factory;

import com.liumapp.qtools.property.core.ConfigurationNode;
import com.liumapp.workable.converter.config.BasicLoadingConfigService;
import com.liumapp.workable.converter.config.ConverterConfig;
import com.liumapp.workable.converter.core.LoadingConfig;
import com.liumapp.workable.converter.core.Manager;
import com.liumapp.workable.converter.decorators.BuildingDefaultParamsDecorator;
import com.liumapp.workable.converter.decorators.CheckingUrlSourceForParamsDecorator;
import com.liumapp.workable.converter.decorators.CreatingFoldersForParamsDecorator;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

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

    public static synchronized ConverterConfigManager getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new ConverterConfigManager();
            try {
                buildingConverterConfig(INSTANCE);
            } catch (Throwable throwable) {
                throwable.printStackTrace();
            }
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
        LoadingConfig service = new CreatingFoldersForParamsDecorator(new CheckingUrlSourceForParamsDecorator(new BuildingDefaultParamsDecorator(new BasicLoadingConfigService())));
        ConfigurationNode configurationNode = service.loadURL();
        INSTANCE.params = service.loadConfig(configurationNode);
    }
}
