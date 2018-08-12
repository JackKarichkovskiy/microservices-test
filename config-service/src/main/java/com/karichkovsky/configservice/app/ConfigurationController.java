package com.karichkovsky.configservice.app;

import com.karichkovsky.configservice.infrastructure.ConfigurationBean;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author karic
 */
@RestController
@AllArgsConstructor
@Slf4j
public class ConfigurationController {

    private static final String FALLBACK_APP_NAME = "Fallback Name";

    private final ConfigurationBean configuration;

    @GetMapping("/appName")
    @HystrixCommand(fallbackMethod = "fallbackRetrieveAppName")
    public String retrieveConfiguration() {
        log.info("ConfigurationController.retrieveConfiguration");
        return configuration.getAppName();
    }

    public String fallbackRetrieveAppName() {
        return FALLBACK_APP_NAME;
    }
}
