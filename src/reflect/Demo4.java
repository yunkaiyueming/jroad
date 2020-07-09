package reflect;

import reflect2.User;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author w
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