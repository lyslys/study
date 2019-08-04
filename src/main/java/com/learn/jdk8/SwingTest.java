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

        Integer i = new Integer(127);
        Integer b = 133;
        Integer a = 133;
        Integer c = 133;
        System.out.println(i == b);
        System.out.println(a == b);
        System.out.println(c == b);
//        System.out.println(i.equals(b));
    }
}
