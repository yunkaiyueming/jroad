package reflect;

import reflect2.User;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 反射就是把Java类中的各种成分映射成相应的java类。例如，一个Java类中用一个Class类的对象来表示，一个类中的组成部分：成员变量，方法，构造方法，包等等信息也用一个个的Java类来表示，就像汽车是一个类，汽车中的发动机，变速箱等等也是一个个的类。
 * 表示Java类的Class类显示要提供一系列的方法，来获得其中的变量，方法，构造方法，修饰符，包等信息，这些信息就是用相应类的实例对象来表示，它们是Field、Method、Contructor、Package等等。
 * ————————————————
 */
public class Demo4 {

    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Demo4 de = new Demo4();
        de.testNoneReflect();//测试没有使用反射
        de.testNotAccess(); //使用
        de.testUseAccess();
    }

    public void testNoneReflect() {
        User user = new User();

        long start = System.currentTimeMillis();
        for (long i = 0; i < 10000; ++i) {
            user.getName();
        }
        long count = System.currentTimeMillis() - start;
        System.out.println("没有反射, 共消耗 <" + count + "> 毫秒");
    }

    public void testNotAccess() throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        User user = new User();
        Method method = Class.forName("reflect2.User").getMethod("getName");

        long start = System.currentTimeMillis();
        for (long i = 0; i < 10000; ++i) {
            method.invoke(user, null);
        }
        long count = System.currentTimeMillis() - start;
        System.out.println("没有访问权限, 共消耗 <" + count + "> 毫秒");
    }

    public void testUseAccess() throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException, InvocationTargetException {
        User user = new User();
        Method method = Class.forName("reflect2.User").getMethod("getName");
        method.setAccessible(true);//值为true,则指示反射的对象在使用时取消Java语言访问检查 禁用访问权限检查,也会有性能的提升。

        long start = System.currentTimeMillis();
        for (long i = 0; i < 10000; ++i) {
            method.invoke(user, null);
        }
        long count = System.currentTimeMillis() - start;
        System.out.println("有访问权限, 共消耗 <" + count + "> 毫秒");
    }
}