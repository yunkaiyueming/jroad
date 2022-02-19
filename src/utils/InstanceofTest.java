package utils;

class Animal {

}

class Dog extends Animal {

}

/**
 * 使用instanceof判断对象类型
 *
 * @author pan_junbiao
 */
public class InstanceofTest {
    public static void main(String[] args) {
        Animal a = new Dog();
        if (a instanceof Dog) {
            // 向下转型操作
            Dog d = (Dog) a;
            System.out.println("向下转型操作成功1！");
        }

        Dog a2 = new Dog();
        if (a2 instanceof Dog) {
            // 向下转型操作
            Dog d = (Dog) a;
            System.out.println("向下转型操作成功2！");
        }

        Animal a3 = new Animal();
        if (a3 instanceof Dog) {
            // 向下转型操作
            Dog d = (Dog) a;
            System.out.println("向下转型操作成功3！");
        }

        Animal a4 = new Dog();
        if (a4 instanceof Animal) {
            // 向下转型操作
            Dog d = (Dog) a;
            System.out.println("向下转型操作成功4！");
        }
    }
}
