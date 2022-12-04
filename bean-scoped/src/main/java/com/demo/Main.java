package com.demo;

import com.demo.beans.SpringBean2;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ProjectConfig.class);
        context.registerShutdownHook();

        /*SpringBean2 obj1 = context.getBean(SpringBean2.class);
        SpringBean2 obj2 = context.getBean(SpringBean2.class);

        boolean test = obj1 == obj2;
        System.out.println(obj1);
        System.out.println(obj2);*/
    }


}
