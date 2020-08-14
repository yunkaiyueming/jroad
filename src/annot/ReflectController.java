package annot;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Method;

/**
 * 这是自定义注解的类
 */
@Target({ ElementType.TYPE, ElementType.METHOD })
@Retention(RetentionPolicy.RUNTIME)
@Documented
@interface MyRequestMapping {
    String say(); // 这是注解的一个属性字段，也就是在使用注解时填写在括号里的参数
    String route();
}

//自定义的注解类
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD) //次注解只能作用于方法上
@interface MethodAnnotation {
    String desc() default "method1";
}

@MyRequestMapping(route = "/test", say = "/some")
 class TestController {
    public void get() {
        System.out.println("进入get方法");
    }

    @MethodAnnotation(desc="methodget")
    public void post() {
        System.out.println("进入post方法");
    }
}

//使用反射获取注解信息 经常用在减少配置中
public class ReflectController {
    public static void main(String[] args) {
//        Class<?> c = TestController.class;
//        MyRequestMapping baseRequestMapping = c.getAnnotation(MyRequestMapping.class);
//        System.out.println(baseRequestMapping.value()); // 输出value的值

        System.out.println(MyRequestMapping.class.getName());
        Method[] all = MyRequestMapping.class.getMethods();
        for(Method a :all){
            System.out.println("meth==>"+a.getName());
        }


        System.out.println(TestController.class.getAnnotation(MyRequestMapping.class).route());
        System.out.println(TestController.class.getAnnotation(MyRequestMapping.class).say());
        System.out.println(TestController.class.getAnnotation(MyRequestMapping.class).getClass());
    }
}