package com.sang.topic;

import com.sang.topic.controller.web.interceptor.RequestInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class TopicWebAppConfigurer extends WebMvcConfigurerAdapter{
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(requestInterceptor())
                .addPathPatterns("/**")
                .excludePathPatterns("/rest/**")
                .excludePathPatterns("/module/**");
        super.addInterceptors(registry);
    }

    @Bean
    RequestInterceptor requestInterceptor(){
        return new RequestInterceptor();
    }
}
