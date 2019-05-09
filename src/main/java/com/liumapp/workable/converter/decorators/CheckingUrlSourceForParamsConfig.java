package com.liumapp.workable.converter.decorators;

import com.liumapp.qtools.property.core.ConfigurationNode;
import com.liumapp.qtools.property.core.loader.ConfigurationLoader;
import com.liumapp.qtools.property.yaml.YAMLConfigurationLoader;
import com.liumapp.workable.converter.core.LoadingConfig;
import com.liumapp.workable.converter.templates.NormalConverterConfigLoaderTemplate;

import java.io.IOException;
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

        ConfigurationNode node1 = buildingNode(url1);
        if (checkOfficeHome(node1))
            return node1;

        ConfigurationNode node2 = buildingNode(url2);
        if (checkOfficeHome(node2))
            return node2;

        return super.loadURL();
    }

    private boolean checkOfficeHome (ConfigurationNode node) throws IOException {
        if (node.getNode("com", "liumapp", "workable-converter", "libreofficePath").getValue() == null) {
            return false;
        }
        return true;
    }

    private ConfigurationNode buildingNode (URL url) throws IOException {
        ConfigurationLoader loader = YAMLConfigurationLoader.builder()
                .setURL(url).build();
        ConfigurationNode node = loader.load();
        return node;
    }

}
