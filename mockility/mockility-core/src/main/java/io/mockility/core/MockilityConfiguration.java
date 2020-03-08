package io.mockility.core;

import io.mockility.core.interceptor.MockedInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Don't worry be happy
 * Created by liangwei on 12/11/17
 */

@Configuration
public class MockilityConfiguration extends WebMvcConfigurerAdapter {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new MockedInterceptor());
    }
}
