package exception;

import java.io.*;
import java.util.concurrent.locks.ReentrantLock;

public class Ex1 {
    public static void main(String[] args) throws IOException {
        //readFile("./demo3.txt");
        //readFile2("./demoxxx.txt");

        //method(1);

        try{
            method(0);
        }catch (ArithmeticException ae){
            System.out.println(ae);
        }

        method2("zhsang1");
        System.exit(1);
    }

    //即如果一个方法可能出现受可查异常，要么用try-catch语句捕获，要么用throws子句声明将它抛出，否则会导致编译错误
    private static void readFile(String filePath) throws IOException {
        File file = new File(filePath);
        String result;
        BufferedReader reader = new BufferedReader(new FileReader(file));
        while((result = reader.readLine())!=null) {
            System.out.println(result);
        }
        reader.close();
    }

    //即如果一个方法可能出现受可查异常，要么用try-catch语句捕获，要么用throws子句声明将它抛出，否则会导致编译错误
    private static void readFile2(String filePath){
        File file = new File(filePath);
        String result;
        BufferedReader reader = null;

        try {
            reader = new BufferedReader(new FileReader(file)); //抛出异常
            while((result = reader.readLine())!=null) { //这之后的不会被执行
                System.out.println(result);
            }
        }catch(FileNotFoundException fe){
            System.out.println("FilEx捕获了异常错误,处理:"+ fe);

        }catch (IOException ex){
            System.out.println("IO捕获了异常错误,处理:"+ex);

            if(reader!=null){
                try {
                    reader.close();
                }catch (IOException ex2){
                    System.out.println("关闭失败"+ex2);
                }
            }

        }finally {
            System.out.println("finally run...."); //catch执行后，会被执行
        }

        System.out.println("end run...."); //finally执行后，最后执行
    }

//执行的顺序
//当try没有捕获到异常时：try语句块中的语句逐一被执行，程序将跳过catch语句块，执行finally语句块和其后的语句； 当try捕获到异常，catch语句块里没有处理此异常的情况：当try语句块里的某条语句出现异常时，而没有处理此异常的catch语句块时，此异常将会抛给JVM处理，finally语句块里的语句还是会被执行，但finally语句块后的语句不会被执行； 当try捕获到异常，catch语句块里有处理此异常的情况：在try语句块中是按照顺序来执行的，当执行到某一条语句出现异常时，程序将跳到catch语句块，并与catch语句块逐一匹配，找到与之对应的处理程序，其他的catch语句块将不会被执行，而try语句块中，出现异常之后的语句也不会被执行，catch语句块执行完后，执行finally语句块里的语句，最后执行finally语句块后的语句；
    public static void method(int value) {
        if(value == 0) {
            throw new ArithmeticException("参数不能为0"); //抛出一个运行时异常
        }
        System.out.println(5.0 / value);
    }

    public static void method2(String a) {
        try {
            int av = Integer.valueOf(a);
        }catch (NumberFormatException ne){
            System.out.println(a+"捕获异常"+ne);
        }
    }

    public static void tryfinally(int value) {
        //以Lock加锁为例，演示try-finally
        ReentrantLock lock = new ReentrantLock();
        try {
            //需要加锁的代码
            System.out.println(value);
        } finally {
            lock.unlock(); //保证锁一定被释放
        }
    }
}
