package builtin;

public class AdapterClass {
    public static void main(String[] args) {
        show(new Cat());  // 猫
        show(new Dog());  // 狗
        show(new LangDog()); //狼狗

        Animal a = new Cat();  // 猫 向上转型
        a.eat();               // 猫吃鱼

        Cat c = (Cat) a;        // 猫
        c.work();

        Animal d = new LangDog();
        d.work();
    }

    public static void show(Animal a) {
        a.eat();

        //是否是cat对象
        if (a instanceof Cat) {  //是否是Cat对象
            Cat c = (Cat) a;
            c.work();
        } else if (a instanceof Dog) { // 是否是dog对象
            Dog c = (Dog) a;
            c.work();
        }
    }
}

abstract class Animal {
    abstract void eat();

    abstract void work();
}

class Cat extends Animal {
    @Override
    public void eat() {
        System.out.println("吃鱼");
    }

    public void work() {
        System.out.println("捉老鼠");
    }
}

class Dog extends Animal {
    @Override
    public void eat() {
        System.out.println("吃骨头");
    }

    public void work() {
        System.out.println("看门");
    }
}

class LangDog extends Dog {

    @Override
    public void eat() {
        System.out.println("langdog 吃骨头");
    }

    @Override
    public void work() {
        System.out.println("langdog看门");
    }
}