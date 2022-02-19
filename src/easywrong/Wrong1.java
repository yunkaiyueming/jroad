package easywrong;

//字符串对象 比较 字符内容是否相同时，使用equals

///对于非字符串变量来说，"=="和"equals"方法的作用是相同的都是用来比较其 对象在堆内存的首地址，即用来比较两个引用变量是否指向同一个对象。

//equals方法对于字符串来说是比较内容的，而对于非字符串来说是比较
//其指向的对象是否相同的。
//
//             == 比较符也是比较指向的对象是否相同的也就是对象在对内存中的的首地址。
//
//  
//String类中重新定义了equals这个方法，而且比较的是值，而不是地址。所以是true。
//————————————————
//版权声明：本文为CSDN博主「andevele」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
//原文链接：https://blog.csdn.net/zhu_apollo/java/article/details/1896391

public class Wrong1 {
    public static void main(String[] args) {
        String a = new String("a");
        String a2 = "a";
        String b2 = "a";
        if (a == a2)//
        {
            System.out.println("a == a2 return true.");
        } else {
            System.out.println("a == a2 return false.");
        }

        if (b2 == a2) {
            System.out.println("b2 == a2 return true.");
        } else {
            System.out.println("b2 == a2 return false.");
        }

        if (a.equals(a2))//两个字符串在比较内容是否相等的时候一定要使用“equals”方法
        {
            System.out.println("a.equals(a2) return true.");
        } else {
            System.out.println("a.equals(a2) return false.");
        }
    }
}
