package com.karichkovsky.logservice.infrastructure;

import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;

/**
 *
 * @author karic
 */
@Configuration
@EnableFeignClients("com.karichkovsky.logservice.app")
public class FeignConfiguration {

}
