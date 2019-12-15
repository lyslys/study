package com.learn.netty;

import java.io.*;
import java.util.Date;

public class Test {


}

class TestFileInputStream{
    public static void main(String[] args) throws Throwable {
        int b = 0 ;
        FileInputStream in = new FileInputStream("D:/game/The Legend of Zelda - Breath of the Wild/游戏说明（必看）.txt");

        long num = 0;
        while ((b = in.read())!= -1){
            System.out.print((char)b);
            num++;
        }
        in.close();
        System.out.println();
        System.out.println("共读取了"+num+"个字节");
        // FileInputStream 共读取了3683个字节
        // Reader 共读取了3257个字节
    }
}


class TestFileOutputStream{
    public static void main(String[] args) throws Throwable {
        int b;
        FileInputStream in = new FileInputStream("D:/game/The Legend of Zelda - Breath of the Wild/游戏说明（必看）.txt");
        FileOutputStream out  = new FileOutputStream("D:/阿萨德.txt");
        while ((b = in.read())!= -1){
         out.write(b);
        }
        in.close();
        out.close();
        System.out.println("文件已复制");
    }
}

class TestFileReader{
    public static void main(String[] args) throws Throwable {
        int b = 0 ;
        FileReader in = new FileReader("C:\\work\\study\\src\\main\\java\\com\\learn\\io\\Test.java");

        long num = 0;
        while ((b = in.read())!= -1){
            System.out.print((char)b);
            num++;
        }
        in.close();
        System.out.println();
        System.out.println("共读取了"+num+"个字节");
        // FileInputStream 共读取了3683个字节
        // Reader 共读取了3257个字节
    }
}

class TestFileWriter{
    public static void main(String[] args) throws Throwable {
        FileWriter fw = new FileWriter("D:/yy.txt");
        for (int i = 0; i < 65535 ; i++) {
            fw.write(i);
        }
        fw.close();
    }
}


class TestBufferInputStream{
    public static void main(String[] args) throws Throwable {
        FileInputStream fis = new FileInputStream("D:/game/The Legend of Zelda - Breath of the Wild/游戏说明（必看）.txt");
        BufferedInputStream bis = new BufferedInputStream(fis);
        int c;
        System.out.println((char)bis.read());
        System.out.println((char)bis.read());
        bis.mark(100);

        for (int i = 0; i <= 10 && (c = bis.read()) != -1; i++) {
            System.out.print((char)c);
        }

        System.out.println();

        bis.reset();
        for (int i = 0; i <= 10 && (c = bis.read()) != -1; i++) {
            System.out.print((char)c);
        }

        bis.close();

    }
}

class TestBufferInputStream2{
    public static void main(String[] args) throws Throwable {

        BufferedWriter bw = new BufferedWriter(new FileWriter("D:/uu.txt"));
        BufferedReader br = new BufferedReader(new FileReader("D:/game/The Legend of Zelda - Breath of the Wild/游戏说明（必看）.txt"));


        String s;

        for (int i = 1; i <=100 ; i++) {
            s = String.valueOf(Math.random());
            bw.write(s);
            bw.newLine();
        }

        bw.flush();
        while (( s = br.readLine()) != null){
            System.out.println(s);
        }

        bw.close();
        br.close();

    }
}

/**
 * 转换流
 */
class TestTransForm{
    public static void main(String[] args) throws Throwable{
        OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream("d:/mm.txt"));
        osw.write("xjcklhvoiusoiu");
        System.out.println(osw.getEncoding());
        osw.close();

        osw = new OutputStreamWriter(new FileOutputStream("d:/mm.txt"),"GB2312");
        osw.write(6666+"kkkkkkk");
        System.out.println(osw.getEncoding());
        osw.close();
    }
}

class TestTransForm1{
    public static void main(String[] args) throws Throwable{

        InputStreamReader isr = new InputStreamReader(System.in);

        BufferedReader br = new BufferedReader(isr);
        String s = br.readLine();
        while (s != null){
            if("exit".equalsIgnoreCase(s)){
                break;
            }
            System.out.println(s.toUpperCase());
            s = br.readLine();
        }
        br.close();
    }
}

/**
 * 数据流
 */
class TestDataStream{
    public static void main(String[] args) throws Throwable {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        DataOutputStream dos = new DataOutputStream(baos);
        double a = Math.random();
        dos.writeDouble(a);
        dos.writeBoolean(true);
        ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
        System.out.println(bais.available());
        DataInputStream dis =new DataInputStream(bais);
        System.out.println(dis.readDouble());
        System.out.println(dis.readBoolean());
        dos.close();
        dis.close();
    }
}

/**
 * 打印流
 */
class TestPrintStream{
    public static void main(String[] args)throws Exception {
        FileOutputStream fos = new FileOutputStream("d:/pp.txt");
        PrintStream ps = new PrintStream(fos);

        if(ps != null){
            System.setOut(ps);
        }
        int ln = 0;
        for (char c = 0; c < 60000; c++) {
            System.out.print(c+"");
            if(ln++ >= 100){
                System.out.println();
                ln = 0;
            }
        }
    }
}

class TestPrintStream1{

    public static void main(String[] args)throws Exception {
        String filename = args[0];
        if(filename != null){
            list(filename, System.out);
        }
    }

    public static void list(String f,PrintStream fs)throws Exception{
        BufferedReader br = new BufferedReader(new FileReader(f));
        String s = null;
        while ((s = br.readLine()) != null){
            fs.println(s);
        }
        br.close();
    }

}

class TestPrintStream3 {
    public static void main(String[] args) {
        String s = null;
        BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in));
        try {
            FileWriter fw = new FileWriter
                    ("d:\\vv.log", true); //Log4J
            PrintWriter log = new PrintWriter(fw);
            while ((s = br.readLine())!=null) {
                if(s.equalsIgnoreCase("exit")) break;
                System.out.println(s.toUpperCase());
                log.println("-----");
                log.println(s.toUpperCase());
                log.flush();
            }
            log.println("==="+new Date()+"===");
            log.flush();
            log.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

/**
 * Object流
 */
class TestObject {

    public static void main(String[] args) throws Exception{
        TestUser testUser = new TestUser();
        testUser.k = 8;
        FileOutputStream fos = new FileOutputStream("d:/99.txt");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(testUser);
        oos.flush();
        oos.close();

        FileInputStream fis = new FileInputStream("d:/99.txt");
        ObjectInputStream ois = new ObjectInputStream(fis);
        TestUser tu = (TestUser)ois.readObject();
        System.out.println(tu);

    }


}

class TestUser implements Serializable{

    transient int i = 20;
    int j = 30;
    double d = 3.99;
    int k = 15;
    transient String h = "哈哈哈哈是的";

    @Override
    public String toString() {
        return "TestUser{" +
                "i=" + i +
                ", j=" + j +
                ", d=" + d +
                ", k=" + k +
                ", h='" + h + '\'' +
                '}';
    }
}
