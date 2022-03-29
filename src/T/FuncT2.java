package T;

import java.util.ArrayList;
import java.util.Date;

public class FuncT2 {
    public static void main(String[] args) {

        /**不指定泛型的时候*/
        int i = FuncT2.add(1, 2); //这两个参数都是Integer，所以T为Integer类型
        Number f = FuncT2.add(1, 1.2); //这两个参数一个是Integer，以风格是Float，所以取同一父类的最小级，为Number
        Object o = FuncT2.add(1, "asd"); //这两个参数一个是Integer，以风格是Float，所以取同一父类的最小级，为Object

        /**指定泛型的时候*/
        int a = FuncT2.<Integer>add(1, 2); //指定了Integer，所以只能为Integer类型或者其子类
        //int b = FuncT2.<Integer>add(1, 2.2); //编译错误，指定了Integer，不能为Float
        Number c = FuncT2.<Number>add(1, 2.2); //指定为Number，所以可以为Integer和Float

        System.out.println(c);

        //泛型类 不指定任何类型
        ArrayList list = new ArrayList();
        list.add(1);
        list.add("121");
        list.add(new Date());
    }

    //这是一个简单的泛型方法
    public static <T> T add(T x,T y){
        return y;
    }
}