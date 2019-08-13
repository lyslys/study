package com.learn.thread.mmall.annoations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 课程里用来标记【推荐】的类或者写法
 */
@Target(ElementType.TYPE)  //作用目标
@Retention(RetentionPolicy.SOURCE) //注解存在范围
public @interface Recommend {

    String value() default "";

}
