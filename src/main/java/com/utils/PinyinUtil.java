package com.utils;

import net.sourceforge.pinyin4j.PinyinHelper;

public class PinyinUtil {

    // 返回中文的首字母
    public static String getPinYinHeadChar(String str){
        String convert = "";
        int len = str.length();
        for(int j = 0;j < len; j++){
            char word = str.charAt(j);
            String[] pinyinArray = PinyinHelper.toHanyuPinyinStringArray(word);
            if (pinyinArray != null) {
                convert += pinyinArray[0].charAt(0);
            } else {
                convert += word;
            }
            break;
        }
        return convert.toUpperCase();
    }

    public static void main(String[] args) {
        System.out.println(getPinYinHeadChar("大伦"));

    }

}
