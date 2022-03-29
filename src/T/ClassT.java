package T;

import java.util.HashMap;
import java.util.Map;


//Java泛型这个特性是从JDK 1.5才开始加入的，因此为了兼容之前的版本，Java泛型的实现采取了“伪泛型”的策略，即Java在语法上支持泛型，但是在编译阶段会进行所谓的“类型擦除”（Type Erasure），将所有的泛型表示（尖括号中的内容）都替换为具体的类型（其对应的原生态类型），就像完全没有泛型一样

class IntTest {
    private Integer x;       // 表示X坐标
    private Integer y;       // 表示Y坐标

    public void setX(Integer x) {
        this.x = x;
    }

    public void setY(Integer y) {
        this.y = y;
    }

    public Integer getX() {
        return this.x;
    }

    public Integer getY() {
        return this.y;
    }
}

class FloatTest {
    private Float x;       // 表示X坐标
    private Float y;       // 表示Y坐标

    public void setX(Float x) {
        this.x = x;
    }

    public void setY(Float y) {
        this.y = y;
    }

    public Float getX() {
        return this.x;
    }

    public Float getY() {
        return this.y;
    }
}

class ObjectPoint {
    private Object x;
    private Object y;

    public void setX(Object x) {
        this.x = x;
    }

    public void setY(Object y) {
        this.y = y;
    }

    public Object getX() {
        return this.x;
    }

    public Object getY() {
        return this.y;
    }
}

//泛型的使用
//T其实这个字母可以是任何大写字母，大家这里先记着，可以是任何大写字母，意义是相同的。
//泛型类 的示例 在实例化该类时，必须指明泛型T的具体类型
class Point<T> {
    private T x;
    private T y;

    public void setX(T t) {
        this.x = x;
    }

    public void setY(T t) {
        this.y = y;
    }

    public T getX() {
        return this.x;
    } //返回值的类型有外部决定

    public T getY() {
        return y;
    }

}

//简单 泛型类的使用
public class ClassT {
    public static void main(String[] args) {
        IntTest i = new IntTest();
        i.setX(1);
        i.setY(1);

        FloatTest f = new FloatTest();
        f.setX((float) 1.1);
        f.setX((float) 2.2);

        ObjectPoint integerPoint = new ObjectPoint();
        integerPoint.setX(100);
        Integer integerX = (Integer) integerPoint.getX();
        System.out.println(integerX);

        //IntegerPoint使用 //TODO没有输出 在实例化该类时，必须指明泛型T的具体类型
        Point<Integer> p = new Point<Integer>();
        p.setX(1000);
        System.out.println(p.getX());

        //FloatPoint使用 在实例化该类时，必须指明泛型T的具体类型
        Point<Float> p2 = new Point<Float>();
        p2.setX(100.12f);
        System.out.println(p2.getX());

        Map<String,String> data = new HashMap<String,String>();
    }
}