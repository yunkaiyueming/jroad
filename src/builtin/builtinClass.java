package builtin;

class catDemo {
    public static void eat() {
        System.out.println("eat finish");
    }
}

//java Class类封装一个对象和接口运行时的状态，当装载类时，Class类型的对象自动创建。
//获取Class实例的三种方式：
//     (1)利用对象调用getClass()方法获取该对象的Class实例；
//     (2)使用Class类的静态方法forName()，用类的名字获取一个Class实例（staticClass forName(String className)  Returns the Classobject associated with the class or interface with the given stringname. ）；
//     (3)运用.class的方式来获取Class实例，对于基本数据类型的封装类，还可以采用.TYPE来获取相对应的基本数据类型的Class实例
//   在newInstance()调用类中缺省的构造方法 ObjectnewInstance()（可在不知该类的名字的时候，常见这个类的实例） Creates a new instance of the class represented by this Classobject.
//————————————————

public class builtinClass {
    public static void main(String[] args) throws ClassNotFoundException {
        String a = "aaa";
        Integer i = 20;

        Class claname = a.getClass();
        System.out.println(claname);//用对象的.getClass()方法获取
        System.out.println(i.getClass());

        System.out.println(String.class);//用类名.class方法获取
        System.out.println(Integer.class);
        System.out.println(catDemo.class);

        Class catCla = Class.forName("builtin.catDemo"); //Class.forName包名
        System.out.println(catCla);

        catDemo cat1 = new catDemo();
        System.out.println(cat1.getClass());

    }

    public static void main2(String[] args) throws Exception {
        String str1 = "abc";
        Class cls1 = str1.getClass();
        Class cls2 = String.class;
        Class cls3 = Class.forName("java.lang.String");
        System.out.println(cls1 == cls2);
        System.out.println(cls1 == cls3);
    }
}
