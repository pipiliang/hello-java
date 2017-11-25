package io.mockility.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.boot.web.support.SpringBootServletInitializer;

/**
 * Don't worry be happy
 * Created by liangwei on 11/24/17
 */

@SpringBootApplication
public class MockilityApplication extends SpringBootServletInitializer implements EmbeddedServletContainerCustomizer {
    private static final Logger logger = LoggerFactory.getLogger(MockilityApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(MockilityApplication.class, args);
    }

    @Override
    public void customize(ConfigurableEmbeddedServletContainer container) {
        container.setPort(14250);
        container.setContextPath("/mockility/api/v1");
    }
}
