package IO;

import java.io.*;
import java.nio.charset.Charset;

//java io 分为： 字节流，字符流， 字节是个计算机看的，字符才是给人看的
//著作权归https://pdai.tech所有。
//链接：https://pdai.tech/md/java/io/java-io-basic-category.html
//
//字节流读取单个字节，字符流读取单个字符(一个字符根据编码的不同，对应的字节也不同，如 UTF-8 编码是 3 个字节，中文编码是 2 个字节。) 字节流用来处理二进制文件(图片、MP3、视频文件)，字符流用来处理文本文件(可以看做是特殊的二进制文件，使用了某种编码，人可以阅读)。
//FileInputStream、FileOutputStream、FileReader、FileWriter

public class FileWriterDemo {
    public static final String filePath = "./demo.txt";

    public static void main(String[] args) throws IOException {
        //FileWriteDemo();
        //FileReadDemo();

        //FileInputDemo();
        FileOutputDemo();
    }

    //FileWriter 字符流
    public static void FileWriteDemo() {
        FileWriter fileWriter = null;
        try {
            try {
                fileWriter = new FileWriter(filePath, true);
                fileWriter.write("demo\n");
                fileWriter.write("demo");
                fileWriter.flush();
            } finally {
                fileWriter.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //字符流
    //FileRead的继承树关系：
    //类继承： FileReader==>InputStreamReader===>Reader ==> Object
    //接口继承： FileReader=>
    public static void FileReadDemo() throws IOException {
//        File fd = new File(filePath);
        FileReader fr = new FileReader(filePath);
//
//        char 类型占 16 位，也就是两个字节
//        int ch = fr.read(); //读取单个字符
////        System.out.println(ch);
//        System.out.println((char)ch);
//        int ch1 = fr.read();
//        System.out.println((char)ch1);
//        int ch2 = fr.read();
//        System.out.println((char)ch2);

        int ch;
        String str = "";
        while ((ch=fr.read())!=-1){ //一个一个字符的读，读出来是字符，字符的ascii
            str += (char)ch;
            System.out.print((char)ch);
        }
        System.out.println("====全部的内容是："+str);


        char[] chs = new char[1024];
        String str2 = "";
        int len;
        while ((len=fr.read(chs))!=-1){ //1024字符大小，最多读
            str += String.valueOf(chs);
            System.out.print(String.valueOf(chs)); //字符数值 转 字符串
        }

        System.out.println("====全部的内容是2："+str);
        fr.close();
    }

    //文件字节输入流
    //类关系继承图：FileInputStream ==>  InputStream
    //接口继承关系图： FileInputStream ==> Closeable ==> AutoCloseable
    public static void FileInputDemo() throws IOException {
        FileInputStream fin = new FileInputStream(filePath);
        byte[] rd =new byte[1024]; //字节 转 字符
//        byte rd2[] = new byte[1024]; // 第二种定义方式 也可以走通

        String content = "";
        do{
            int len = fin.read(rd); //实际读取的 字节长度
            byte[] newv = new byte[len];
            for(int i=0;i<len;i++){
                newv[i] = rd[i];
            }
            System.out.print(new String(newv)); //字节数组 转 字符串
            content += new String(newv);
        }while(fin.available()>0);
        fin.close();

        System.out.println("=====");
        System.out.println("最后全部内容："+content);
    }

    //文件 字节输出流
    public static void FileOutputDemo() throws IOException{
        FileOutputStream fout = new FileOutputStream(filePath,true);
        String msg = "abcs\n";
        fout.write(msg.getBytes());
    }

}