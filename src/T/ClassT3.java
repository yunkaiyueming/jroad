package T;

import java.util.ArrayList;
import java.util.List;

class animal{}

class dog extends animal{
}

public class ClassT3 {

    public static void main(String[] args) {
        List<dog> doglist = new ArrayList<dog>();
        doglist.add(new dog());
        doglist.add(new dog());
        doglist.add(new dog());

        Show(doglist);
    }

    //<? extends A>表示该类型参数可以是A(上边界)或者A的子类类型
    //编译时擦除到类型A，即用A类型代替类型参数。这种方法可以解决开始遇到的问题，编译器知道类型参数的范围，如果传入的实例类型B是在这个范围内的话允许转换，这时只要一次类型转换就可以了，运行时会把对象当做A的实例看待
    public static void Show(List<? extends animal> t){
        System.out.println(t);
    }

    public static void Show2(List<? super dog> t){
        System.out.println(t);
    }

    // 如下funD方法会报错
    public static void funC(List<? extends animal> listA) {
        // ...
    }
    public static void funD(List<dog> listB) {
        funC(listB); // Unresolved compilation problem: The method doPrint(List<A>) in the type test is not applicable for the arguments (List<B>)
        // ...
    }
}
