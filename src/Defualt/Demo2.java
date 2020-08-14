package Defualt;

public class Demo2 extends Demo1 implements Interface1 {

    public static void main(String[] args) {
        Demo2 myTestDemo2 = new Demo2();
        myTestDemo2.SayWords();//类优先于接口，会使用类Demo1中的SayWords
    }
}