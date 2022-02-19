package annot;

import java.awt.Dialog.ModalityType;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.net.Authenticator.RequestorType;

@Documented
@Inherited
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.FIELD})
//此注解作用于类和字段上
@interface FieldTypeAnnotationTest {
    String type() default "ignore";

    int age() default 27;

    String[] hobby(); //没有指定defalut的，需要在注解的时候显式指明
}


//自定义注解
@Documented
@Inherited
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
        //次注解只能作用于方法上
@interface MethodAnnotationTest {
    String desc() default "method1";
}


@FieldTypeAnnotationTest(type = "class", hobby = {"smoke"})
public class ReflectAnnotation {

    @FieldTypeAnnotationTest(hobby = {"sleep", "play"})
    private String maomao;

    @FieldTypeAnnotationTest(hobby = {"phone", "buy"}, age = 27, type = "normal")
    private String zhangwenping;

    @MethodAnnotationTest()
    public void method1() {
    }

    @MethodAnnotationTest(desc = "method2")
    public void method2() {
    }


    //通过反射获取类上 被注解的信息，可以减少配置
    public static void main(String[] args) {
        // 此处要用反射将字段中的注解解析出来
        Class<ReflectAnnotation> clz = ReflectAnnotation.class;
        // 判断类上是否有次注解
        boolean clzHasAnno = clz.isAnnotationPresent(FieldTypeAnnotationTest.class);
        if (clzHasAnno) {
            // 获取类上的注解
            FieldTypeAnnotationTest annotation = clz.getAnnotation(FieldTypeAnnotationTest.class);
            // 输出注解上的属性
            int age = annotation.age();
            String[] hobby = annotation.hobby();
            String type = annotation.type();
            System.out.println(clz.getName() + " age = " + age + ", hobby = " + Arrays.asList(hobby).toString() + " type = " + type);
        }


        // 解析字段上是否有注解
        // ps：getDeclaredFields会返回类所有声明的字段，包括private、protected、public，但是不包括父类的
        // getFields:则会返回包括父类的所有的public字段，和getMethods()一样
        Field[] fields = clz.getDeclaredFields();
        for (Field field : fields) {
            boolean fieldHasAnno = field.isAnnotationPresent(FieldTypeAnnotationTest.class);
            if (fieldHasAnno) {
                FieldTypeAnnotationTest fieldAnno = field.getAnnotation(FieldTypeAnnotationTest.class);
                //输出注解属性
                int age = fieldAnno.age();
                String[] hobby = fieldAnno.hobby();
                String type = fieldAnno.type();
                System.out.println(field.getName() + " age = " + age + ", hobby = " + Arrays.asList(hobby).toString() + " type = " + type);
            }
        }

        //解析方法上的注解 被注解类
        Method[] methods = clz.getDeclaredMethods();
        for (Method method : methods) {
            boolean methodHasAnno = method.isAnnotationPresent(MethodAnnotationTest.class);
            if (methodHasAnno) {
                //得到注解
                MethodAnnotationTest methodAnno = method.getAnnotation(MethodAnnotationTest.class);
                //输出注解属性
                String desc = methodAnno.desc();
                System.out.println(method.getName() + " desc = " + desc);
            }
        }
    }
}
