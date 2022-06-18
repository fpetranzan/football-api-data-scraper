package com.football.api.controller;

import com.football.api.configuration.ConfigurationService;
import com.football.api.constants.FootballApiConstants;
import com.scraper.webscraper.WebScraper;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.Arrays;

@RestController
@CrossOrigin
@RequestMapping(value = "/")
public class HomeController {

    @Autowired
    ConfigurationService configurationService;

    WebScraper webScraper;

    @GetMapping
    public String home() {
        String URLDati = configurationService.getProperty(FootballApiConstants.BASE_SITE.DATA);
        URLDati += "ITA/2021/Serie-A/calendario/";

        Elements elements = null;

        try {
            webScraper = new WebScraper();
            elements = webScraper.findElements(URLDati, Arrays.asList(".table","tr","td"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        return elements.text();
    }

}
