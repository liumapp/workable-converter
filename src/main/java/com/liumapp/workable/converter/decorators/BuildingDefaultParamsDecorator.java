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
public class BuildingDefaultParamsDecorator extends NormalConverterConfigLoaderTemplate {

    public BuildingDefaultParamsDecorator(LoadingConfig loadingConfig) {
        super(loadingConfig);
    }

    @Override
    public ConverterConfig loadConfig(ConfigurationNode node) throws Throwable {
        if (node.getNode("com", "liumapp", "workable-converter", "libreofficePath").getValue() == null) {
            throw new NotFoundLibreofficeHome("libreoffice home path must be setted");
        }

        buildingDefaultValueIfEmpty(node.getNode("com", "liumapp", "workable-converter", "libreofficePort"), 2002);
        buildingDefaultValueIfEmpty(node.getNode("com", "liumapp", "workable-converter", "tmpPath"), "./data/");
        return super.loadConfig(node);
    }

    private void buildingDefaultValueIfEmpty (ConfigurationNode node, Object defaultValue) {
        if (node.getValue() == null) {
            node.setValue(defaultValue);
        }
    }
}
