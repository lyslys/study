package com.learn.design.dependencyinversion;

public class JavaCourse implements ICourse {

    @Override
    public void studyCourse() {
        System.out.println("Lys在学习java课程");
    }

}
