package com.karichkovsky.logservice.app;

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
public class LogController {

    private final ConfigServiceProxy proxy;

    @GetMapping("/appName")
    public String convertCurrencyFeign() {
        String response = proxy.getAppName();

        log.info("{}", response);

        return "LOGGED: " + response;
    }
}
