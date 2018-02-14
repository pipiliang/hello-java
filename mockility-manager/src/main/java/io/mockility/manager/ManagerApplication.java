package io.mockility.manager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.boot.web.support.SpringBootServletInitializer;

/**
 * Don't worry be happy
 * Created by liangwei on 11/24/17
 */
public class ManagerApplication extends SpringBootServletInitializer implements EmbeddedServletContainerCustomizer {
    private static final Logger logger = LoggerFactory.getLogger(ManagerApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(ManagerApplication.class, args);
    }

    @Override
    public void customize(ConfigurableEmbeddedServletContainer container) {
        container.setPort(14250);
        container.setContextPath("/api/mockility/v1/");
    }
}
