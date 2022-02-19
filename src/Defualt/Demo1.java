package Defualt;

//public class Demo1 implements Interface1 {
//
//    public static void main(String[] args){
//        Demo1 d1 = new Demo1();
//        d1.SayWords();//say in Interface1
//    }
//}

//
//public class Demo1 implements interface2 {
//
//    public static void main(String[] args){
//        Demo1 d1 = new Demo1();
//        d1.SayWords();//say in Interface2
//    }
//}

public class Demo1 implements Interface1, interface2 {

    public static void main(String[] args) {
        Demo1 d1 = new Demo1();
        d1.SayWords();//必须实现自己的，不然编译器发现有2个接口都有defalut，不知道用哪个，懵逼了
    }

    @Override
    public void SayWords() { //实现自己的SayWords
        System.out.println("say in Demo1");
    }
}


