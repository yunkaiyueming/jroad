package ioc;

interface IPrint {
    /**
     * onLine:  对象需要实现这个方法来实现打印对象的功能
     * void  返回类型
     */
    String printObject();
}

 class UserBean implements IPrint{
    @Override
    public String printObject() {
        // TODO Auto-generated method stub
        System.out.println("打印对象UserBean:");
        return "abc";
    }
}

 class MyBean implements IPrint{

    @Override
    public String printObject() {
        // TODO Auto-generated method stub
        System.out.println("打印对象MyBean:");
        return null;
    }
}

//Spring 的核心就是控制反转 ( IoC ) 和 依赖注入 （DI）及面向切面编程 (AOP) 。
//控制反转 依赖注入
//依赖注入
//        常用的注入方式有四种：
//        1. 属性注入
//        2. 构造方法注入
//        3. 工厂方法注入
//        4. 注解注入
public class Demo1 {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        //Spring中的ioc思想 根据配置文件动态创建类，调用方法
        //读取配置文件（将配置文件中的bean加载进内存）
        //ApplicationContext ctx = new ClassPathXmlApplicationContext("/testSpring/resources/applicationContext.xml");
        //IPrint bean=(IPrint)ctx.getBean("userBean"); //获取的实例
        //bean.printObject();        //调用方法

        //核心思想: 根据类名的字符串形式，创建对象 用接口的实现多态，自动调用对应实现类的方法
        String className = "ioc.UserBean";
        String idName = "userBean";

        Class abCal = Class.forName(className); //获得了Class类，可以用这个类得到各种对象信息
        IPrint obj = (IPrint)abCal.newInstance();
        obj.printObject();

        className = "ioc.MyBean";
        abCal = Class.forName(className);
        obj = (IPrint)abCal.newInstance();
        obj.printObject();
    }


}
