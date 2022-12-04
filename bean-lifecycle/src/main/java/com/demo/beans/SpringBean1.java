package com.demo.beans;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class SpringBean1 implements InitializingBean, DisposableBean {

    private SpringBean2 springBean2;

    @Autowired
    public void setSpringBean2(SpringBean2 springBean2){
        System.out.println(
                String.format("%s injected to %s", springBean2.getClass().getSimpleName(), this.getClass().getSimpleName())
        );
        this.springBean2 = springBean2;
    }

    @PostConstruct
    public void postConstruct(){
        System.out.println(this.getClass().getSimpleName()+ "::PostConstruct.");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println(this.getClass().getSimpleName()+ "::afterPropertiesSet()");
    }

    public void customInit(){
        System.out.println(this.getClass().getSimpleName()+ "::customInit()");
    }

    public String sayHello(){
        return "Hello!";
    }

    @PreDestroy
    public void preDestroy(){
        System.out.println(this.getClass().getSimpleName() + "::preDestroy()");
    }
    @Override
    public void destroy() throws Exception {
        System.out.println(this.getClass().getSimpleName() + ":: DisposableBean::destroy");
    }

    public void customDestroy(){
        System.out.println("custom Destroy!");
    }
}
