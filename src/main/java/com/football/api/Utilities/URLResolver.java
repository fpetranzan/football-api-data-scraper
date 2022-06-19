package com.football.api.Utilities;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

@Component
public class URLResolver {

    private static final Logger LOG = LogManager.getLogger(URLResolver.class);

    public String resolver(String baseURL, String nation, int year, String championship, String suffix){
        String url = baseURL + "/" + nation + "/" + year + "/" + championship + "/" + suffix;
        LOG.info("URL generated: {}", url);
        return url;
    }
}
