package com.learn.tuling.spring.beanlifecycle;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class PersonTest {

    public static void main(String[] args) {

       new AnnotationConfigApplicationContext(PersonConfig.class);

    }


}
