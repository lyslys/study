package com.learn.design.dependencyinversion;

public class PythonCourse implements ICourse {
    @Override
    public void studyCourse() {
        System.out.println("Lys在学习Python课程");
    }
}
