package com.demo;

import com.demo.beans.SpringBean1;
import com.demo.beans.SpringBean2;
import com.demo.beans.SpringBean3;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*;

@Configuration
@ComponentScan @Lazy
public class ProjectConfig {

    @Bean @Autowired @Lazy(value = false)
    public SpringBean1 springBean1(SpringBean2 springBean2) {
        SpringBean1 springBean1 = new SpringBean1(springBean2);
        return springBean1;
    }
    @Bean @Scope("prototype")
    public SpringBean3 springBean3(){
        return new SpringBean3();
    }

    @Bean
    public SpringBean2 springBean2(){
        return new SpringBean2();
    }

}
