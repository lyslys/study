package com.learn.tuling.spring.beanlifecycle;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PersonConfig {

    @Bean(initMethod = "myInit")
    public Person myInit(){
        System.out.println("执行配置文件类的person的initPerson方法了");
        return new Person();
    }

    @Bean
    public MyBeanPostProcessor getMyBeanPostProcessor(){
        System.out.println("getMyBeanPostProcessor");
        return new MyBeanPostProcessor();
    }

}
