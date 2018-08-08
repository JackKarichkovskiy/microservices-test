package com.karichkovsky.logservice;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author karic
 */
//@FeignClient(name = "currency-exchange-service", url = "localhost:8000")
//@FeignClient(name = "currency-exchange-service")
@FeignClient(name = "gateway")
@RibbonClient(name = "config-service")
public interface ConfigServiceProxy {

    @GetMapping("/config-service/appName")
    String getAppName();
}
