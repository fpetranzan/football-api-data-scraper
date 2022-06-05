package com.football.api.configuration.impl;

import com.football.api.configuration.ConfigurationService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

@Service
public class DefaultConfigurationService implements ConfigurationService {

    private static final Logger LOG = LogManager.getLogger(DefaultConfigurationService.class);

    private InputStream inStream;
    private Properties prop;

    public DefaultConfigurationService() {
        inStream = getClass().getClassLoader().getResourceAsStream("project.properties");

        prop = new Properties();
        try {
            prop.load(inStream);
            inStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String getProperty(String property){
        if (StringUtils.isBlank(prop.getProperty(property))) {
            LOG.info("no property found with key: {}", property);
            return null;
        }

        LOG.info("property with key: '{}' was found", property);
        return prop.getProperty(property);
    }
}
