package com.learn.design.dependencyinversion;

public class Lys {

    ICourse iCourse;

    public Lys() {}

    public Lys(ICourse iCourse) {
            this.iCourse = iCourse;
    }

    public void studyCourse(){
        iCourse.studyCourse();
    }

    public void setiCourse(ICourse iCourse) {
        this.iCourse = iCourse;
    }

//    v2
//    public void studyCourse(ICourse iCourse){
//        iCourse.studyCourse();
//    }


//    v1
//    public void studyJavaCourse(){
//        System.out.println("Lys在学习java课程");
//    }
//
//    public void studyPSCourse(){
//        System.out.println("Lys在学习ps课程");
//    }
//
//    public void studyPythonCourse(){
//        System.out.println("Lys在学习Python课程");
//    }

}
