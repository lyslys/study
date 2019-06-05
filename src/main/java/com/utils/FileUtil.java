package com.utils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Pattern;

public class FileUtil {
    // 设置一个全局动态数组，来存放文件路径
    // 主要遍历文件夹，包含所有子文件夹、文件的情况时，用到递归，所以要这样设置
    public static ArrayList<String> dirAllStrArr = new ArrayList<String>();

    //要显示的文件类型（过滤掉不想显示的文件）
    public  static String fileType ="mp4|flv|avi|rm|rmvb|wmv|mkv";

    // 这里是仅仅查询当前路径下的所有文件夹、文件并且存放其路径到文件数组
    // 由于遇到文件夹不查询其包含所有子文件夹、文件，因此没必要用到递归
    public static ArrayList<String> Dir(File dirFile) throws Exception {
        ArrayList<String> dirStrArr = new ArrayList<String>();

        if (dirFile.exists()) {
            // 直接取出利用listFiles()把当前路径下的所有文件夹、文件存放到一个文件数组
            File files[] = dirFile.listFiles();
            for (File file : files) {
                // 如果传递过来的参数dirFile是以文件分隔符，也就是/或者\结尾，则如此构造
                if (dirFile.getPath().endsWith(File.separator)) {
                    dirStrArr.add(dirFile.getPath() + file.getName());
                } else {
                    // 否则，如果没有文件分隔符，则补上一个文件分隔符，再加上文件名，才是路径
                    dirStrArr.add(dirFile.getPath() + File.separator
                            + file.getName());
                }
            }
        }
        return dirStrArr;
    }

    public static ArrayList<String> DirAll(File dirFile,String filePath) throws Exception {

        if (dirFile.exists()) {
            File files[] = dirFile.listFiles();
            for (File file : files) {

//                System.out.println(getContentType(file.getPath()) + "---> " + file.getName());

                // 如果遇到文件夹则递归调用。
                if (file.isDirectory()) {
                    // 递归调用
                    DirAll(file,filePath);
                } else {

                    if (getContentType(file.getName())) {

                        // 如果遇到文件夹则放入数组
                        if (dirFile.getPath().endsWith(File.separator)) {
                            dirAllStrArr.add( file.getName());
                        } else {
                            String str = dirFile.getPath().replace(filePath, "") + File.separator + file.getName();
                            System.out.println(str);
                            dirAllStrArr.add(str);
                        }
                    }
                }
            }
        }

        return dirAllStrArr;
    }

    //要显示的文件类型（过滤掉不想显示的文件）
    public static boolean getContentType(String fileName) {
        String[] strArray = fileName.split("\\.");
        return fileType.contains(strArray[strArray.length -1]);
    }

    public static void imgLocation(File file) throws IOException {
        String reg = "(mp4|flv|avi|rm|rmvb|wmv)";
        Pattern p = Pattern.compile(reg);
        boolean boo = p.matcher(file.getName()).find();
    }

    public static void main(String[] args) throws Exception {
//        File dirFile = new File("D:\\Media");
//        DirAll(dirFile,dirFile.getPath());
//        System.out.print(JSONObject.toJSONString(dirAllStrArr));
//
//        System.out.println("------------------->");
//
//        String imgUrl = "http://127.0.0.1:8080/cms/ReadAddress/1479805098158.jpg";
//
//        String image = imgUrl.substring(imgUrl.lastIndexOf("/cms/ReadAddress")+1);
//        System.out.println(image);



        int n = 1;
        while (n-- != 0) {
            System.out.println(n);
        }

        System.out.println("------------>J");
//
        int j = 1;
        while (--j != 0) {
            System.out.println(j);
        }

    }



}


