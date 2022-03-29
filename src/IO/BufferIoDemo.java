package IO;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;

//字符流 只能写文件； 字节流的数据源可以是磁盘，网络等其他
public class BufferIoDemo {

    public static final String filePath = "./demo.txt";

    public static void main(String[] args) throws IOException {
        //BufferedInputStreamDemo();
        //BufferedOutputStreamDemo();
        //copyFileDemo();
        //BufferReaderDemo();
        //BufferWriterDemo();

        StreamtoReaderDemo();
        StreamOuttoReaderDemo();
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

    //字符 输入 包装流
    public static void BufferReaderDemo() throws IOException{
        FileReader fr = new FileReader("./demo2.txt", Charset.forName("UTF-16LE"));
        BufferedReader bufferedReader = new BufferedReader(fr);

        String con = "",allCon = "";
        while( (con=bufferedReader.readLine()) != null ){
            System.out.println(con);
            allCon+=con;
        }
        bufferedReader.close();
        System.out.println("全部内容："+allCon);
    }

    //字符 输出 包装流
    public static void BufferWriterDemo() throws IOException{
        FileWriter fw = new FileWriter("./demo2.txt",Charset.forName("UTF-16LE"),true);
        BufferedWriter bufferedWriter = new BufferedWriter(fw);

        bufferedWriter.write("nihao类似====");
        bufferedWriter.newLine();
        bufferedWriter.close();
        System.out.println("写入成功");
    }

    //输入字节流 转换到 字符流
    public static void StreamtoReaderDemo() throws IOException{
        FileInputStream fin =  new FileInputStream("./demo2.txt");
        InputStreamReader in  = new InputStreamReader(fin,"UTF-16LE");
        //new BufferedReader(new InputStreamReader(new FileInputStream("./demo2.txt")));
        int len;
        char[] redaData = new char[1024];

        while( (len = in.read(redaData)) != -1){
            System.out.println(new String(redaData,0 ,len));
        }
        in.close();

    }

    //输出 字节流 转换到 字符流
    public static void StreamOuttoReaderDemo() throws IOException{
        FileOutputStream fout =  new FileOutputStream("./demo2.txt");
        BufferedWriter outw = new BufferedWriter(new OutputStreamWriter(fout,"UTF-16LE"));
        outw.write("张三技术是aaaa");
        outw.close();
    }
}
