package T;

//泛型方法 T使用
class GenericMethods {
    public <T> void f(T x) {
        System.out.println(x.getClass().getName());
    }
    public void testInt(){
        f(1);
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
        gm.testInt();
    }
}