package other;

class A {
    public int age = 10;
    public int name = 11;
}

class B {
    public int age = 10;
    public int name = 11;
}

public class hashCodeDemo {
    public static void main(String[] args) {

        //对于字符串对象是根据字符内容得出hashCode的，因为这里s1和s2最终指向的都是“hello”，因为字符内容是一样的，所以得出的哈希码也是相同的。
        String s1 = "hello";
        String s2 = new String("hello");
        String s3 = new String(s1);
        System.out.println(s1.hashCode());
        System.out.println(s2.hashCode());
        System.out.println(s3.hashCode());
        System.out.println(s3.equals(s2));

        //两个对象的哈希码相同，他们则不一定相同，但是如果两个对象是一样的，那他们的hashCode则一定相同
        A a = new A();
        A a2 = new A();
        B b = new B();
        System.out.println(a.hashCode());
        System.out.println(a2.hashCode());
        System.out.println(b.hashCode());
        System.out.println(a.equals(b));
        System.out.println(a.equals(a2));
    }

}
