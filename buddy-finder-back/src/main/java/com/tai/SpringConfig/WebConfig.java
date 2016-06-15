package com.tai.SpringConfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import javax.annotation.PostConstruct;

/**
 * Created by izabella on 01.06.16.
 */
@Configuration
@EnableWebMvc
public class WebConfig extends WebMvcConfigurerAdapter {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**");
    }

    @Configuration
    public class ProcessonConfiguration {
        @Autowired
        private RequestMappingHandlerMapping requestMappingHandlerMapping;

        @Autowired
        private CommonsCorsProcessor corsProcessor;

        @PostConstruct
        public void init(){
            requestMappingHandlerMapping.setCorsProcessor(corsProcessor);
        }

    }
}