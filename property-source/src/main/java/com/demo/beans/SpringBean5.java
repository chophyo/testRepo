package com.demo.beans;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
public class SpringBean5 implements BeanInterface, Ordered {
    @Override
    public int getOrder() {
        return 7;
    }
}
