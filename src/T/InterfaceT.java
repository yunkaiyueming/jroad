package T;

//泛型接口
interface Info<T> {       // 在接口上定义泛型
    public T getVar(); // 定义抽象方法，抽象方法的返回值就是泛型类型

    public void setVar(T x);
}

//InterfaceT1实现泛型接口
class InterfaceT1 implements Info<String> {
    private String var; // 定义属性

    public InterfaceT1(String var) {        // 通过构造方法设置属性内容
        this.setVar(var);
    }

    @Override
    public String getVar() {
        return this.var;
    }

    @Override
    public void setVar(String x) {
        this.var = x;
    }
}

public class InterfaceT {
    public static void main(String arsg[]) {
        InterfaceT1 i = new InterfaceT1("harvic");
        System.out.println(i.getVar());
    }
}
