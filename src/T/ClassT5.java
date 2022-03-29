package T;

import java.util.ArrayList;

//泛型上下限的引入 上限，只能是Number类型 或其子类
class Infodemo<W extends Number>{    // 此处泛型只能是数字类型 此处T可以随便写为任意标识，常见的如T、E、K、V等形式的参数常用于表示泛型
    private W var ;        // 定义泛型变量
    public void setVar(W var){
        this.var = var ;
    }
    public W getVar(){
        return this.var ;
    }
    @Override
    public String toString(){    // 直接打印
        return this.var.toString() ;
    }
}

//擦除类定义中的类型参数 - 无限制类型擦除
//当类定义中的类型参数没有任何限制时，在类型擦除中直接被替换为Object，即形如<T>和<?>的类型参数都被替换为Object
//擦除类定义中的类型参数 - 有限制类型擦除
public class ClassT5{

    public static void main(String args[]) throws Exception {
        Infodemo<Integer> i1 = new Infodemo<Integer>() ;        // 声明Integer的泛型对象
        TypeerasureDemo();
        TypeerasureDem2();
    }

    public static void TypeerasureDemo() {
        ArrayList<String> list1 = new ArrayList<String>();
        list1.add("abc");

        ArrayList<Integer> list2 = new ArrayList<Integer>();
        list2.add(123);

        System.out.println(list1.getClass());
        System.out.println(list1.getClass() == list2.getClass()); // true
    }

    //java泛型只在编译阶段起效，编译后去掉泛型，讲泛型相关擦除
    //在编译之后程序会采取去泛型化的措施。也就是说Java中的泛型，只在编译阶段有效。在编译过程中，正确检验泛型结果后，会将泛型的相关信息擦出，并且在对象进入和离开方法的边界处添加类型检查和类型转换的方法。也就是说，泛型信息不会进入到运行时阶段。

    public static void TypeerasureDem2() throws Exception {
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(1);  //这样调用 add 方法只能存储整形，因为泛型类型的实例为 Integer
        list.getClass().getMethod("add", Object.class).invoke(list, "asd");

        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }
}
