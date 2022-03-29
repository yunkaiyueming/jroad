package Tai;

// 动物类
class Animal {
    int age;
    String name;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // 动物类里面有叫和吃两个方法
    public void cry() {
        System.out.println("我不知道叫什么");
    }

    public void eat() {
        System.out.println("我不知道吃什么");
    }

    public void say() {
    }
}

// 狗类继承于动物类
class Dog extends Animal {
    // 覆盖（重写）方法
    public void cry() {
        System.out.println("旺旺");
    }

    public void eat() {
        System.out.println("我是狗，我爱吃骨头");
    }
}

// 猫类继承于动物类
class Cat extends Animal {
    // 覆盖（重写）方法
    public void cry() {
        System.out.println("喵喵");
    }

    public void eat() {
        System.out.println("我是猫，我爱吃鱼");
    }
}

// 食物类 父类
class Food {

    String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // 食物类里面让它有一个方法
    public void showName() {

    }
}

// 鱼（食物的一种）继承于食物
class Fish extends Food {
    public void showName() {
        System.out.println("食物：鱼");
    }
}

// 骨头（食物的一种）继承于食物
class Bone extends Food {
    public void showName() {
        System.out.println("食物：骨头");
    }
}

// 主人类 存在一種餵食方法
class Master {
    // 给动物喂食物，如果没有多态，他要写给猫喂食和给狗喂食两个方法
    // 有了多态，以后即使再来好多动物，用这一个函数就可以了
    public void feed(Animal an, Food f) {//将子类对象赋值给父类，自动调用子类自己的方法
        an.eat();
        f.showName();
    }
}

//
//多态的实现方式
//        方式一：重写：
//        这个内容已经在上一章节详细讲过，就不再阐述，详细可访问：Java 重写(Override)与重载(Overload)。

//        方式二：接口
//        1. 生活中的接口最具代表性的就是插座，例如一个三接头的插头都能接在三孔插座中，因为这个是每个国家都有各自规定的接口规则，有可能到国外就不行，那是因为国外自己定义的接口类型。
//
//        2. java中的接口类似于生活中的接口，就是一些方法特征的集合，但没有方法的实现。具体可以看 java接口 这一章节的内容。
//
//        方式三：抽象类和抽象方法

//多态的实现
//所谓多态，就是指一个引用（类型）在不同的情况下的多种状态。也可以理解为，多态是指通过指向父类的指针，来调用在不同子类中实现的方法。。
public class TaiDemo {
    public static void main(String args[]) {

        Master master = new Master();
        master.feed(new Dog(), new Bone());

        // hin方便，可以再试试
        master.feed(new Cat(), new Fish());
    }
}