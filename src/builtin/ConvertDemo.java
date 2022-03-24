package builtin;

import java.nio.charset.Charset;

public class ConvertDemo {

    public static void main(String[] args){
        IntVsString();
        byteVsString();
        charVsString();
    }

    //int 和 string相互转换
    public static void IntVsString(){
        int i = 10;
        String j = String.valueOf(i);
        System.out.println(j);
        System.out.println(Integer.valueOf(j));
    }

    //byte[] 和 String相互转换
    public static void byteVsString(){
        byte[] by = new byte[2];
        by[0]= 'a';
        by[1]='b';

        String j = new String(by);
        System.out.println(j);
        System.out.println(j.getBytes()[0]+":"+ j.getBytes()[1]);
//        Charset cr = new Character();
    }

    //char 和 String 相互转换
    public static void charVsString(){
        char[] by = new char[5];
        by[0]= 'h';
        by[1]='e';
        by[2]='l';
        by[3]='l';
        by[4]='o';

        String j = String.valueOf(by);
        System.out.println(j);
        System.out.println(j.toCharArray());
    }
}
