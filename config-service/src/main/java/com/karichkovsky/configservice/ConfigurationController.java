package com.karichkovsky.configservice;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
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
public class ConfigurationController {

    private static final String FALLBACK_APP_NAME = "Fallback Name";

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    private final Configuration configuration;

    @Autowired
    public ConfigurationController(Configuration configuration) {
        this.configuration = configuration;
    }

    @GetMapping("/appName")
    @HystrixCommand(fallbackMethod = "fallbackRetrieveAppName")
    public String retrieveConfiguration() {
        logger.info("ConfigurationController.retrieveConfiguration");
        return configuration.getAppName();
    }

    public String fallbackRetrieveAppName() {
        return FALLBACK_APP_NAME;
    }
}
