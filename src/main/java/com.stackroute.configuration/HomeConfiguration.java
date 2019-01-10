package com.stackroute.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
//Spring @Configuration annotation allows us to use annotations for dependency injection.
// Spring Configuration annotation indicates that the class has @Bean definition methods.
@EnableWebMvc
@ComponentScan(basePackages = "com.stackroute")
// Using component scan is one method of asking Spring to detect Spring managed components.
// Spring needs the information to locate and register all the Spring components with
// the application context when the application starts.
public class HomeConfiguration {

    @Bean
    public ViewResolver viewResolver() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/WEB-INF/views/");
        viewResolver.setSuffix(".jsp");
        return viewResolver;
    }

}
