package builtin;

//接口实现版本，类实现接口，
public class AdapterClass2 {
    public static void main(String[] args) {
        show(new Cat2());  // 猫
        show(new Dog2());  // 狗
        show(new LangDog2()); //狼狗

        Animal2 a = new Cat2();  // 猫 向上转型, a对象是父类对象的实例，父类中没有work方法，无法调用，但是可以转型，是安全的
        a.eat();            // 猫吃鱼，可以调用
        //a.work();  调用报错

        Cat2 c = (Cat2) a;// 猫
        c.work();//可以调用


//
//        Animal2 d = new LangDog2();
//        d.work();
    }

    public static void show(Animal2 a) {
        a.eat();

        //是否是cat对象
        if (a instanceof Cat2) {  //是否是Cat对象
            Cat2 c = (Cat2) a;
            c.work();
        } else if (a instanceof Dog2) { // 是否是dog对象
            Dog2 c = (Dog2) a;
            c.work();
        }
    }
}

interface Animal2 {
    void eat();
}

class Cat2 implements Animal2 {
    @Override
    public void eat() {
        System.out.println("吃鱼");
    }

    public void work() {
        System.out.println("捉老鼠");
    }
}

class Dog2 implements Animal2 {
    public int num;

    @Override
    public void eat() {
        System.out.println("吃骨头");
    }

    public void work() {
        System.out.println("看门");
    }
}

class LangDog2 extends Dog2 {

    @Override
    public void eat() {
        //this.parent();
        System.out.println("langdog 吃骨头");
    }

    @Override
    public void work() {
        System.out.println("langdog看门");
    }
}