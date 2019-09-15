package com.learn.annotation;

import java.lang.annotation.*;

import static java.lang.annotation.ElementType.*;

@Target({FIELD,METHOD,CONSTRUCTOR})
@Retention(RetentionPolicy.RUNTIME)
@Inherited  //描述当前这个注解是否能被子类对象继承
@Documented //是否能被文档所记录
public @interface TestAnnotation {

    String name = "lys";

    String [] value() default "梁焱升";


}
