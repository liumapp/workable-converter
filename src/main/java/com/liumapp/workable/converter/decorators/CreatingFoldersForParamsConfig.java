package com.liumapp.workable.converter.decorators;

import com.liumapp.qtools.file.basic.FileTool;
import com.liumapp.qtools.property.core.ConfigurationNode;
import com.liumapp.workable.converter.config.ConverterConfig;
import com.liumapp.workable.converter.core.LoadingConfig;
import com.liumapp.workable.converter.exceptions.NotFoundLibreofficeHome;
import com.liumapp.workable.converter.templates.NormalConverterConfigLoaderTemplate;

import java.io.File;
import java.io.IOException;

/**
 * file CreatingFoldersForParamsConfig.java
 * author liumapp
 * github https://github.com/liumapp
 * email liumapp.com@gmail.com
 * homepage http://www.liumapp.com
 * date 2019/5/11
 */
public class CreatingFoldersForParamsConfig extends NormalConverterConfigLoaderTemplate {
    public CreatingFoldersForParamsConfig(LoadingConfig loadingConfig) {
        super(loadingConfig);
    }

    @Override
    public ConverterConfig loadConfig(ConfigurationNode node) throws Throwable {
        //get all config params
        ConverterConfig config = super.loadConfig(node);
        //check config and init necessary folder files
        if (!checkingFolderIsExist(config.getLibreofficePath()))
            throw new NotFoundLibreofficeHome("your libreoffice home can not be found : " + config.getLibreofficePath());
        if (!checkingFolderIsExist(config.getPdfSavePath())) createNecessaryFolder(config.getPdfSavePath());
        if (!checkingFolderIsExist(config.getPicSavePath())) createNecessaryFolder(config.getPicSavePath());
        if (!checkingFolderIsExist(config.getWaitedSavePath())) createNecessaryFolder(config.getWaitedSavePath());
        return config;
    }

    private boolean checkingFolderIsExist (String folderPath) {
        return FileTool.isDirectory(folderPath);
    }

    private void createNecessaryFolder (String folderPath) throws IOException {
        FileTool.createDir(new File(folderPath));
    }

}
