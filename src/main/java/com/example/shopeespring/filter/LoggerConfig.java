package com.example.shopeespring.filter;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LoggerConfig {
    @Bean
    public FilterRegistrationBean<DefaultFilter> loggingFilter(){
        FilterRegistrationBean<DefaultFilter> registrationBean
                = new FilterRegistrationBean<DefaultFilter>();
        registrationBean.setFilter(new DefaultFilter());
        registrationBean.setOrder(1);
        registrationBean.addUrlPatterns("/product/all");
        return registrationBean;
    }
}
