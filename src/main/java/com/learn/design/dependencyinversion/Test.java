package com.learn.design.dependencyinversion;

public class Test {
    public static void main(String[] args) {
//        v1
//        Lys lys = new Lys();
//        lys.studyJavaCourse();
//        lys.studyPSCourse();
//        lys.studyPythonCourse();

//        v2
//        Lys lys = new Lys();
//        lys.studyCourse(new JavaCourse());
//        lys.studyCourse(new PsCourse());

//        v3
//        Lys lys = new Lys(new PythonCourse());
//        lys.studyCourse();

        Lys lys = new Lys();
        lys.setiCourse(new JavaCourse());
        lys.studyCourse();
        lys.setiCourse(new PsCourse());
        lys.studyCourse();
        lys.setiCourse(new PythonCourse());
        lys.studyCourse();


    }
}
