package com.liumapp.workable.converter.config;

import com.liumapp.qtools.property.core.ConfigurationNode;
import com.liumapp.qtools.property.core.loader.ConfigurationLoader;
import com.liumapp.qtools.property.yaml.YAMLConfigurationLoader;
import com.liumapp.workable.converter.core.LoadingConfig;
import com.liumapp.workable.converter.exceptions.NotFoundConfigFileException;
import com.liumapp.workable.converter.exceptions.NotFoundLibreofficeHome;
import org.checkerframework.checker.nullness.qual.Nullable;

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
    public ConfigurationNode loadURL() throws Throwable {
        URL url = getClass().getResource("/workable-converter.yml");
        if (url == null) {
            throw new NotFoundConfigFileException("workable-converter.yml file not found in your resource folder");
        }
        ConfigurationLoader loader = YAMLConfigurationLoader.builder()
                .setURL(url).build();
        ConfigurationNode node = loader.load();
        if (node.getNode("com", "liumapp", "workable-converter", "libreofficePath").getValue() == null) {
            throw new NotFoundLibreofficeHome("libreoffice home path must need");
        }
        return node;
    }

    @Nullable
    @Override
    public ConverterConfig loadConfig(ConfigurationNode node) throws NullPointerException {
        ConverterConfig converterConfig = new ConverterConfig(
                node.getNode("com", "liumapp", "workable-converter", "pdfSavePath").getValue().toString(),
                node.getNode("com", "liumapp", "workable-converter", "picSavePath").getValue().toString(),
                node.getNode("com", "liumapp", "workable-converter", "waitedSavePath").getValue().toString(),
                node.getNode("com", "liumapp", "workable-converter", "libreofficePath").getValue().toString(),
                node.getNode("com", "liumapp", "workable-converter", "libreofficePort").getInt()
        );
        return converterConfig;
    }


}
