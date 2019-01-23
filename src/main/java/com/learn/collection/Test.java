package com.learn.collection;


import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.*;

public class Test {

    public static void main(String[] args) {

        Collection collection = new LinkedList();

        collection.add("hello");
        int i = 6;
        collection.add(i);
        System.out.println(collection.size());
        System.out.println(collection);

        System.out.println(((LinkedList) collection).get(0));

        ArrayList collection2 = new ArrayList();
        collection2.add("ccc");
        System.out.println(collection2.size());
        System.out.println(collection2);

        System.out.println("--------------");

        List<Integer> integerList = new LinkedList<>();
        List<Integer> integerList2 = null;
//        for(Integer in:integerList2){
//            System.out.println(in);
//        }

       // aa();


        List<Integer> arrayList  =  Arrays.asList(1,2,3);

        List arrList = new ArrayList(arrayList);
        arrList.add(4);
        System.out.println(arrList.toString());


    }

    public static void aa(){
        try {

            File file = new File("D:/home/kyapp/uploadfile/20181022/cc.xls");
       //     file.createNewFile();
                Workbook wb = Workbook.getWorkbook(file);
               System.out.println(wb.getSheet(0));
            WritableWorkbook book = Workbook.createWorkbook(file);
            WritableSheet sheet = book.createSheet("sheet11", 0);
//                WritableWorkbook wwb = Workbook.createWorkbook(new FileOutputStream("E:\\b.xls"));
//                //创建第一个工作表对象,名为("Sheet 1)
//                WritableSheet ws = wwb.createSheet("Sheet 1", 0);

        } catch (IOException e) {
            e.printStackTrace();
        } catch (BiffException e) {
            e.printStackTrace();
        }
    }
}
