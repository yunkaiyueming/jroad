package annot;

import java.lang.annotation.*;

@Target({ElementType.TYPE})
@Inherited
@Retention(RetentionPolicy.RUNTIME)
@interface MyInherited { //自定义注解
}

@Target({ElementType.TYPE})
@Inherited
@Retention(RetentionPolicy.RUNTIME)
@interface MytestsAnot { //自定义注解
}

@interface MyTag {
    // 定义了两个成员变量的注解
    // 使用default为两个成员变量指定初始值
    String name() default "C语言中文网";

    int age() default 7;
}

@MytestsAnot
@MyInherited
public class TestA {
    public static void main(String[] args) {
        System.out.println(TestA.class.getAnnotation(MyInherited.class));
        System.out.println(TestB.class.getAnnotation(MyInherited.class));
        System.out.println(TestC.class.getAnnotation(MyInherited.class));

        System.out.println("=================");
        for (Annotation a : TestA.class.getAnnotations()) {
            System.out.println(a.toString());
        }

        Tsfa a = new Tsfa();
        a.info();
    }
}

class TestB extends TestA {
}

class TestC extends TestB {
}

class Tsfa {
    // 使用带成员变量的注解时，需要为成员变量赋值
    @MyTag(name = "xx", age = 6)
    public void info() {
        String a = MyTag.class.getName();
        System.out.println(a);
    }
}