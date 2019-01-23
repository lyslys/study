package com.learn.thread.batch;

import java.util.ArrayList;
import java.util.List;

class UserSendTread implements Runnable{

    private List<UserEntity>listUser;

    public UserSendTread( List<UserEntity> listUser){
        this.listUser = listUser;
    }

    @Override
    public void run() {
        for (UserEntity userEntity:listUser) {
            System.out.println(Thread.currentThread().getName()+","+userEntity.toString());
        }
        System.out.println();
    }
}

public class BatchSms {
    public static void main(String[] args) {
        //1.初始化数据
        List<UserEntity> initUser = initUser();
        //2.定义每个线程分批发送大小
        int userCount = 2;
        //3.计算每个线需要分配跑的数据
        List<List<UserEntity>> splitList = ListUtils.splitList(initUser,2);
        for (int i = 0; i < splitList.size(); i++) {
            List<UserEntity> list = splitList.get(i);
           /* for (UserEntity userEntity:list) {
                System.out.println(userEntity.toString());
            }*/
            UserSendTread userSendTread = new UserSendTread(list);
            //4.分配发送
            Thread thread  = new Thread(userSendTread,"线程"+i);
            thread.start();
        }

    }

    private static List<UserEntity> initUser(){
        List<UserEntity> list = new ArrayList<>();
        for (int i = 1; i <= 11; i++) {
            list.add(new UserEntity("userId:"+i,"userName:"+i));
        }
        return list;
    }

}
