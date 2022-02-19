package proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

//中介类
class DynamicProxy implements InvocationHandler {
    private Object obj; //obj为委托类对象；

    public DynamicProxy(Object obj) {
        this.obj = obj;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("before");
        Object result = method.invoke(obj, args);
        System.out.println("after");
        return result;
    }
}

//第2个委托类
class Compose implements Sell {
    public void sell() {
        System.out.println("Compose In sell method");
    }

    public void ad() {
        System.out.println("Compose ad method");
    }
}

public class Demo2 {
    public static void main(String[] args) {
        //创建中介类实例
        DynamicProxy inter = new DynamicProxy(new Vendor());
        //加上这句将会产生一个$Proxy0.class文件，这个文件即为动态生成的代理类文件
        System.getProperties().put("saveGeneratedFiles", "true");
        //获取代理类实例sell
        Sell sell = (Sell) (Proxy.newProxyInstance(Sell.class.getClassLoader(), new Class[]{Sell.class}, inter));
        //通过代理类对象调用代理类方法，实际上会转到invoke方法调用
        sell.sell();
        sell.ad();

        //使用compose委托类 委托DynamicProxy动态调用类，调用sell和ad方法
        inter = new DynamicProxy(new Compose());
        sell = (Sell) (Proxy.newProxyInstance(Sell.class.getClassLoader(), new Class[]{Sell.class}, inter));
        //通过代理类对象调用代理类方法，实际上会转到invoke方法调用
        sell.sell();
        sell.ad();

    }
}
