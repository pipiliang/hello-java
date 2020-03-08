package io.mockility.manager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

/**
 * Don't worry be happy
 * Created by liangwei on 11/24/17
 */
@SpringBootApplication
@ComponentScan(basePackages = {"io.mockility.manager", "io.mockility.persistence"})
public class ManagerApplication extends SpringBootServletInitializer implements EmbeddedServletContainerCustomizer {
    private static final Logger logger = LoggerFactory.getLogger(ManagerApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(ManagerApplication.class, args);
    }

    @Bean
    public DatabaseRunner startupRunner() {
        return new DatabaseRunner();
    }


    @Override
    public void customize(ConfigurableEmbeddedServletContainer container) {
        container.setPort(14251);
//        container.setContextPath("/api/mockility/v1");
    }
}
