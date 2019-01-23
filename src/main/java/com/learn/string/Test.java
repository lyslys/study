package com.learn.string;


import java.io.Serializable;

public class Test implements Serializable {

    public static void main(String[] args) {

        // 最后结果：1479805098158.jpg
        String imgUrl = "http://127.0.0.1:8080/cms/ReadAddress/1479805098158.jpg";

        String image = imgUrl.substring(imgUrl.lastIndexOf("/")+1);
        System.out.println(image);


        String [] urlArray = imgUrl.split("/");

        System.out.println(urlArray[urlArray.length-2]);

        Object id = 66666;
        Long idL = (Long)id;
        System.out.println(idL);


    }

}
