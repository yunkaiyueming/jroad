package springdiy;

import org.jdom2.JDOMException;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

public class client {

    //spring diy 实现的 spring
    public static void main(String[] args) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SecurityException, NoSuchMethodException, IllegalArgumentException, InvocationTargetException, JDOMException, IOException, JDOMException, IOException, InvocationTargetException {
        BeanFactory factory = new ClassPathXmlApplicationContext();
        //通过工厂直接获取
        UserService userService = (UserService) factory.getBean("userService");
        //其实User也可以从工厂中获得
        User u = (User) factory.getBean("user");
        //User u = new User();
        u.setUserName("yyb");
        u.setPassword("1234");
        userService.addUser(u);//打印结果yyb1234
    }

}
