package T;

import java.util.HashMap;

//泛型方法 T使用
class GenericMethods {
    public <T> void f(T x) {
        System.out.println(x.getClass().getName()+ x.getClass().getPackage());
    }

    //<T>声明这是泛型函数 ，T x 使用泛型类型
    public <T> void get(T x) {
        System.out.println(x);
    }
}

//测试使用泛型方法
public class FuncT {
    public static void main(String[] args) {
        GenericMethods gm = new GenericMethods();

        gm.f("");
        gm.f(1);
        gm.f(1.0);
        gm.f(1.0F);
        gm.f('c');
        gm.f(gm);

        gm.get(1);
        gm.get("abs");

        HashMap hm = new HashMap<String,String>();
        hm.put("name","zhangsan");
        gm.get(hm);
    }
}