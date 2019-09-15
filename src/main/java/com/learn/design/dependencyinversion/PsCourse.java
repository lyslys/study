package com.learn.design.dependencyinversion;

public class PsCourse implements ICourse {

    @Override
    public void studyCourse() {
        System.out.println("Lys在学习ps课程");
    }

}
