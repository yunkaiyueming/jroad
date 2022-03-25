package IO;

import java.io.*;

//字符流 只能写文件； 字节流的数据源可以是磁盘，网络等其他
public class BufferIoDemo {

    public static final String filePath = "./demo.txt";

    public static void main(String[] args) throws IOException {
        //BufferedInputStreamDemo();
        //BufferedOutputStreamDemo();

        copyFileDemo();
    }

    //类关系继承图：
//    java.lang.Object
//    java.io.InputStream
//    java.io.FilterInputStream
//    java.io.BufferedInputStream

    //字节 输入 包装流
    public static void BufferedInputStreamDemo() throws IOException {
        FileInputStream fin  = new FileInputStream(filePath);
        BufferedInputStream bufferIn = new BufferedInputStream(fin);
        byte[] fdData = new byte[1024];
        int fdlen;
        String allCont = "";
        while( (fdlen=bufferIn.read(fdData))!= -1){
            String content = new String(fdData,0 ,fdlen); //byte[]转字符串
            System.out.print(content);

            allCont += content;
        }
        //最后的全部内容
        System.out.println("最后的全部的内容："+allCont);
        bufferIn.close();
    }

    //字节 输出 包装流
    public static void BufferedOutputStreamDemo() throws IOException{
        FileOutputStream fout = new FileOutputStream(filePath,true);
        BufferedOutputStream bufferOut = new BufferedOutputStream(fout);
        byte[] msg = "abc".getBytes();

        bufferOut.write(msg);
        bufferOut.flush();
        bufferOut.close();

        System.out.println("写入成功");
    }

    //使用缓存 包装流 复制文件
    //BufferedInputStream的数据成员buf是一个位数组，默认为2048字节，BufferedOutputStream的数据成员buf 也是一个位数组，默认为512字节.
    //例2是对例1的改写，不用自行设定缓冲区，比较简单且有效率.
    public static void copyFileDemo() throws  IOException{
        FileInputStream fin = new FileInputStream(filePath);
        FileOutputStream fout = new FileOutputStream("./demo2.txt");

        BufferedOutputStream bufferOut = new BufferedOutputStream(fout);
        BufferedInputStream bufferIn = new BufferedInputStream(fin);
        int fdlen;
        byte[] byteData = new byte[1];
        while( (fdlen=bufferIn.read(byteData)) !=-1 ){
            bufferOut.write(byteData,0 ,fdlen);
        }

        bufferIn.close();
        bufferOut.flush();
        bufferOut.close();

        fin.close();
        fout.close();
    }
}
