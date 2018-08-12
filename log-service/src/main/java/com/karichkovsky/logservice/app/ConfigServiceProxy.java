package com.karichkovsky.logservice.app;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author karic
 */
@FeignClient(name = "gateway")
@RibbonClient(name = "config-service")
public interface ConfigServiceProxy {

    @GetMapping("/config-service/appName")
    String getAppName();
}
