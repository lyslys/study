package com.service.ipks;

import java.util.Date;

public interface ITblVideoService {

    Date tt = new Date();

    static void aa (){
        System.out.println("66666666666666");
    }

    default void aacc (){
        System.out.println("7777777777777777default");
    }

    void aac ();

    public static void main(String[] args) {
        ITblVideoService.aa();
        System.out.println(ITblVideoService.tt);
    }

}
