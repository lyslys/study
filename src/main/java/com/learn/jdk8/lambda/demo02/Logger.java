package com.learn.jdk8.lambda.demo02;

public class Logger {
    public static void showLog(int level,String msg){
        if(level == 1){
            System.out.println(msg);
        }
    }

    public static void main(String[] args) {

        String msg1 = "hello";
        String msg2 = "world";
        String msg3 = "java";

        showLog(0, msg1+msg2+msg3);

    }

}

 class LoggerLambda {
    public static void showLog(int level,MessageBuilder mb){
        if(level == 1){
            System.out.println(mb.builderMessage());
        }
    }

    public static void main(String[] args) {

        String msg1 = "hello";
        String msg2 = "world";
        String msg3 = "java";

        showLog(0, ()->{
            System.out.println("6666666666666");
            return  msg1+msg2+msg3;
        });

    }

}

@FunctionalInterface
interface MessageBuilder{
    public abstract String builderMessage();

}
