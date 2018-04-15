package com.el.dc.admin.properties;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class MyPropertyPlaceholderConfigurer extends PropertyPlaceholderConfigurer {
    private static Map<String, String> propertiesMap;

    @Override
    protected void processProperties(ConfigurableListableBeanFactory beanFactoryToProcess, Properties props) throws BeansException {
        super.processProperties(beanFactoryToProcess, props);
        if (propertiesMap == null || propertiesMap.size() == 0) {
            propertiesMap = new HashMap<>();
            for (Object key : props.keySet()) {
                String keyStr = key.toString();
                String value = String.valueOf(props.get(keyStr));
                propertiesMap.put(keyStr, value);
            }
        }
    }

    public static Map<String, String> getPropertiesMap() {
        return propertiesMap;
    }

    public static void setPropertiesMap(Map<String, String> propertiesMap) {
        MyPropertyPlaceholderConfigurer.propertiesMap = propertiesMap;
    }
}
