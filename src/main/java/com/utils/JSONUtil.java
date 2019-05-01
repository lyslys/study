package com.utils;

import com.alibaba.fastjson.JSON;

public class JSONUtil {
    public static void main(String[] args) {
//        List<VisitRecordCompetitor> list = new ArrayList<>();
//        VisitRecordCompetitor visitRecordCompetitor = new VisitRecordCompetitor();
//        visitRecordCompetitor.setMonthQuantity("6");
//        visitRecordCompetitor.setPreferentialPolicy("77");
//        VisitRecordCompetitor visitRecordCompetitor2 = new VisitRecordCompetitor();
//        visitRecordCompetitor2.setMonthQuantity("8");
//        visitRecordCompetitor2.setPreferentialPolicy("87");
//        list.add(visitRecordCompetitor2);
//        list.add(visitRecordCompetitor);

        String [] str = {"1","2"};
//        System.out.println(JSON.toJSONString(list));
        System.out.println(JSON.toJSONString(str));
    }
}