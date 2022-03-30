package reflect;

import java.io.File;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

//获取Class对象的三种方式: 类名.class, 对象实例.getClass(), Class.forName("全限定类名")
public class ClassUseDemo {

    public static void main(String[] args) throws InvocationTargetException, NoSuchMethodException, NoSuchFieldException, InstantiationException, IllegalAccessException, ClassNotFoundException {
        //获取Class对象的三种方式: 类名.class, 对象实例.getClass(), Class.forName("全限定类名")
        UseClass1(Student.class);

        UseClass1(new Student().getClass());

        UseClass1(Class.forName("reflect.Student"));
    }

    //显示Class对象信息 并通过Class对象获取代表类的信息
    public static void UseClass1(Class<?> studentClass) throws IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException, NoSuchFieldException {

        System.out.println("=========包名类名信息==========");
        System.out.println("全限定类名："+studentClass.getName());
        System.out.println("包名："+studentClass.getPackage());
        System.out.println("包名："+studentClass.getPackageName());
        System.out.println("类名："+studentClass.getSimpleName());

        //获取构造器信息
        System.out.println("=========构造器信息==========");
        Constructor<?>[] studentClassConstructors = studentClass.getDeclaredConstructors();
        for(Constructor<?> studentClassConstructor:studentClassConstructors){
            System.out.println("构造器方法名"+studentClassConstructor.getName());
            for(Class<?> constParmas :studentClassConstructor.getParameterTypes()){
                System.out.print("参数类型："+constParmas.getName()+",");
            }
        }

        //获取成员变量信息
        System.out.println("=========成员属性信息==========");
        Field[] studentFields = studentClass.getFields();
        for(Field field: studentFields){
            System.out.println("成员变量字段："+field.getName()+",成员变量类型："+field.getType().getName());
        }

        //获取成员方法信息，并调用
        System.out.println("=========成员方法信息==========");
        Method[] studentClassMethods = studentClass.getMethods();
        for(Method studentClassMethod: studentClassMethods){
            System.out.println("方法名："+studentClassMethod.getName());
            boolean newlineFlag = false;
            for(Class<?> methParamType : studentClassMethod.getParameterTypes()){
                System.out.print("  参数类型:"+ methParamType.getName());
                newlineFlag = true;
            }
            if(newlineFlag){System.out.println("");}
        }

        Student stObj = (Student)studentClass.newInstance();
        stObj.setAge(10);
        Method stNameMethod = studentClass.getMethod("setName", String.class);

        Field ageFiled = studentClass.getField("age");
        ageFiled.setAccessible(true);
        ageFiled.set(stObj,20);

        stNameMethod.invoke(stObj,"张三"); //通过反射调用方法
        System.out.println(stObj.toString());
    }
}

class Student{
    public int age;
    public String name;

    public void Student(){
    }

    public void Student(int age,String name){
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}
