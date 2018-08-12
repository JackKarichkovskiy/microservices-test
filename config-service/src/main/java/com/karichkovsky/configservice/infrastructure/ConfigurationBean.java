package com.karichkovsky.configservice.infrastructure;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 *
 * @author karic
 */
@Configuration
@ConfigurationProperties("config-service")
public class ConfigurationBean {

    private String appName;

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }
}
