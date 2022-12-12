package com.demo;

import com.demo.beans.SpringBean6;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan
@PropertySource("classpath:/application.properties")
public class ProjectConfig {

    @Bean
    public SpringBean6 springBean6(){
        return new SpringBean6();
    }
}
