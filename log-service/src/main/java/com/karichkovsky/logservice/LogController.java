package com.karichkovsky.logservice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author karic
 */
@RestController
public class LogController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    private final ConfigServiceProxy proxy;

    @Autowired
    public LogController(ConfigServiceProxy proxy) {
        this.proxy = proxy;
    }

    @GetMapping("/appName")
    public String convertCurrencyFeign() {
        String response = proxy.getAppName();

        logger.info("{}", response);

        return "LOGGED: " + response;
    }
}
