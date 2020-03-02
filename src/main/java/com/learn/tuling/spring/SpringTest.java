package com.learn.tuling.spring;

import com.common.config.Appconfig;
import com.service.FarmService;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringTest {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext();
        annotationConfigApplicationContext.register(Appconfig.class);
        annotationConfigApplicationContext.refresh();
        System.out.println(annotationConfigApplicationContext.getBean(FarmService.class).getClass().getName());
        BeanFactory bf = new ClassPathXmlApplicationContext("/application.yml");
        System.out.println(bf.getBean("redisService"));
    }

}
