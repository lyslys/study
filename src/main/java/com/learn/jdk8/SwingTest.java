package com.learn.jdk8;


public class SwingTest {

    public static void main(String[] args) {
    /*    JFrame jFrame = new JFrame("My JFrame");
        JButton jButton = new JButton("My JButton");
        jButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Button Pressed!");
            }
        });
        jFrame.add(jButton);
        jFrame.pack();
        jFrame.setVisible(true);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);*/

//        System.out.println(new Short("1.66"));

//        Character  a = 'a';

//        byte 字节  -128 127   1byte = 8bit  2的八次方
//short 短整形
  //int 整形
    //    long 长整形



    /*    Integer i = new Integer(127);
        Integer b = 133;
        Integer a = 133;
        Integer c = 133;
        System.out.println(i == b);
        System.out.println(a == b);
        System.out.println(c == b);*/
//        System.out.println(i.equals(b));
/*
        int i = 6%2;
        int m =1;
        int n = 2;

        int sum = m++ + ++n - n--;
        System.out.println("sum:"+sum);

        System.out.println(i);


        int aaa = 1 ;
        for (int j = 0; j < 100; j++) {
            aaa = aaa++;
        }

        System.out.println(aaa);*/



        int x=1;

        int y = ++x;
        System.out.println("x:"+x);
        System.out.println("y:"+y);


        int a = 1 ;
        a= a++;
        System.out.println(a);

        byte xx =-1;
//        xx+=2;
//        xx=(byte)(xx+2);
        System.out.println(xx);


        if(a >0 && xx >0){
            System.out.println("进来了");
        }

        a();
        b();

    }


    public static void a(){
        int a = 1;
        int b = 2;
        a = a^b;
        b = a^b;
        a = a^b;

        System.out.println("a:"+a);
        System.out.println("b:"+b);
    }

    public static void b(){

        int [] [] [] array  = {{{1,2}}};
        System.out.println(array[0][0][1]);
    }





}
