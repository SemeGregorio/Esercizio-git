package com.example.demo_interceptor;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    private final APILoggingInterceptor apiLoggingInterceptor;
    private final LegacyInterceptor legacyInterceptor;

    public WebConfig(
            APILoggingInterceptor apiLoggingInterceptor,
            LegacyInterceptor legacyInterceptor) {

        this.apiLoggingInterceptor = apiLoggingInterceptor;
        this.legacyInterceptor = legacyInterceptor;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        registry.addInterceptor(apiLoggingInterceptor);

        registry.addInterceptor(legacyInterceptor)
                .addPathPatterns("/legacy");
    }
}