package com.learn.spring;

import com.common.config.Appconfig;
import com.service.FarmService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SpringTest {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext();
        annotationConfigApplicationContext.register(Appconfig.class);
        annotationConfigApplicationContext.refresh();
        System.out.println(annotationConfigApplicationContext.getBean(FarmService.class).getClass().getName());
    }

}
