package com.learn.annotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

public class Test {
    public static void main(String[] args) {

        Class clazz = Person.class;

        try {
            Field field = clazz.getDeclaredField("name");
            Annotation annotation = field.getAnnotation(TestAnnotation.class);
            String[] values = (String[])annotation.getClass().getMethod("value").invoke(annotation);
            System.out.println(values[1]);


//            TestAnnotation annotation = field.getAnnotation(TestAnnotation.class);
//            System.out.println(annotation.value()[1]);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
