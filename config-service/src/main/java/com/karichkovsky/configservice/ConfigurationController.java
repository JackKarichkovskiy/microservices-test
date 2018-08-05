package com.karichkovsky.configservice;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
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

    private final Configuration configuration;

    @Autowired
    public ConfigurationController(Configuration configuration) {
        this.configuration = configuration;
    }

    @GetMapping("/appName")
    @HystrixCommand(fallbackMethod = "fallbackRetrieveAppName")
    public String retrieveConfiguration() {
        return configuration.getAppName();
    }

    public String fallbackRetrieveAppName() {
        return FALLBACK_APP_NAME;
    }
}
