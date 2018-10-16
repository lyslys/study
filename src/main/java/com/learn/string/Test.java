package com.learn.string;

public class Test {

    public static void main(String[] args) {

        // 最后结果：1479805098158.jpg
        String imgUrl = "http://127.0.0.1:8080/cms/ReadAddress/1479805098158.jpg";

        String image = imgUrl.substring(imgUrl.lastIndexOf("/")+1);
        System.out.println(image);
    }

}
