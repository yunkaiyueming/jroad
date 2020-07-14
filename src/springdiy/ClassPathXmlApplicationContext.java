package springdiy;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

public class ClassPathXmlApplicationContext implements BeanFactory
{
    private Map<String, Object> beans = new HashMap<String, Object>();
    public ClassPathXmlApplicationContext() throws JDOMException, IOException,
            InstantiationException, IllegalAccessException,
            ClassNotFoundException, SecurityException, NoSuchMethodException,
            IllegalArgumentException, InvocationTargetException
    {
        SAXBuilder sb = new SAXBuilder();
        // 构造文档对象
        Document doc = sb.build(ClassPathXmlApplicationContext.class
                .getClassLoader().getResourceAsStream("beans.xml"));
        // 获取根元素
        Element root = doc.getRootElement();
        // 取到根元素所有元素
        List list = root.getChildren();

        for (int i = 0; i < list.size(); i++)
        {
            Element element = (Element) list.get(i);
            // 取id子元素
            String beanid = element.getAttributeValue("id");
            // 取class子元素
            String clzss = element.getAttributeValue("class");
            // 实例化
            Object o = Class.forName(clzss).newInstance();
            // 将所有bean放入map中
            beans.put(beanid, o);
            // 获取property 进行依赖注入
            for (Element propertyElement : (List<Element>) element
                    .getChildren("property"))
            {
                String name = propertyElement.getAttributeValue("name");
                System.out.println(name);//userDAO
                String bean = propertyElement.getAttributeValue("bean");
                System.out.println(bean);//userDAO
                // 从beans.xml中根据id取到类的对象
                //Object beanObj = this.getBean(name);
                // 从beans.xml中根据id取到类的对象
                Object beanObj = this.getBean(bean);
                System.out.println(beanObj);//com.yyb.dao.impl.UserDAOImpl@a09ee92
                // 形成setXXX方法名
                String methodName = "set" + name.substring(0, 1).toUpperCase()
                        + name.substring(1);
                System.out.println(name.substring(0, 1).toUpperCase());//U
                System.out.println(name.substring(1));//serDAO
                System.out.println(methodName);//setUserDAO

                // 反射机制对方法进行调用，将对象在加载bean时就注入到环境上下文中
                Method m = o.getClass().getMethod(methodName,
                        beanObj.getClass().getInterfaces()[0]);
                System.out.println(o.getClass());//class com.yyb.service.UserService
                System.out.println(beanObj.getClass().getInterfaces()[0]);//interface com.yyb.dao.UserDAO
                System.out.println(m);//public void com.yyb.service.UserService.setUserDAO(com.yyb.dao.UserDAO)
                // 执行注入,相当于执行了一个setXXX(args..)的方法
                m.invoke(o, beanObj);
            }
        }
    }
    @Override
    public Object getBean(String name)
    {
        return beans.get(name);
    }
}