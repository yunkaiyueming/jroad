package easywrong;

public class Wrong4 {

    public static void main(String[] args) {
        Integer i1 = 10;
        Integer i2 = 10;

        Integer i3 = 201;
        Integer i4 = 201;

        //包装类型间的相等判断应该用equals，而不是'=='
        System.out.println(i1 == i2);//true
        System.out.println(i3.equals(i4));//false
        //　　装箱过程是通过调用包装器的valueOf方法实现的，而拆箱过程是通过调用包装器的 xxxValue方法实现的。（xxx代表对应的基本数据类型）。
    }
}