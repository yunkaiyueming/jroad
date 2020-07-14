package reflect;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.*;

//java中使用字符串或者动态创建对象的三种方法(Class,Constructor,Proxy)
public class Demo5 {

    public static void main(String[] args) throws ClassNotFoundException,
            InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException,
            SecurityException {

        /*1.适用Class.newInstance创建类对象,该类必须包含一个默认构造器*/
        System.out.println(Class.forName("java.lang.String").newInstance());

        /*2.通过Constructor类创建类对象*/
        System.out.println(Class.forName("java.lang.String").getConstructors()[11].newInstance("reflect"));

        /*3.通过代理机制实现指定接口，并创建一个实例对象，实例对象中实现的所有接口方法将自动调用调用器对象的invoke方法*/
        System.out.println(Proxy.newProxyInstance(null, new Class[]
                        {Class.forName("java.lang.Comparable")},
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) {
                        System.out.println(method);
                        System.out.println("Proxy");
                        return "toString";
                    }
                }));
    }
}
