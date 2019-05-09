package com.liumapp.workable.converter.decorators;

import com.liumapp.qtools.property.core.ConfigurationNode;
import com.liumapp.workable.converter.config.ConverterConfig;
import com.liumapp.workable.converter.core.LoadingConfig;
import com.liumapp.workable.converter.exceptions.NotFoundLibreofficeHome;
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
    public ConverterConfig loadConfig(ConfigurationNode node) throws Throwable {

        if (node.getNode("com", "liumapp", "workable-converter", "libreofficePath").getValue() == null) {
            throw new NotFoundLibreofficeHome("libreoffice home path must be setted");
        }

        buildingDefaultValueIfEmpty(node.getNode("com", "liumapp", "workable-converter", "pdfSavePath"), "./data/pdf/");
        buildingDefaultValueIfEmpty(node.getNode("com", "liumapp", "workable-converter", "picSavePath"), "./data/pic/");
        buildingDefaultValueIfEmpty(node.getNode("com", "liumapp", "workable-converter", "waitedSavePath"), "./data/waiting");

        return super.loadConfig(node);
    }

    private void buildingDefaultValueIfEmpty (ConfigurationNode node, String defaultValue) {
        if (node.getValue() != null) {
            node.setValue(defaultValue);
        }
    }
}
