package builtin;

public class AdapterClass {
    public static void main(String[] args) {
      show(new Cat());  // 猫
      show(new Dog());  // 狗
                
      Animal a = new Cat();  // 猫
      a.eat();               // 猫吃鱼
      
      Cat c = (Cat)a;        // 猫
      c.work();        // 
  }  
            
    public static void show(Animal a)  {
      a.eat();  
        // 绫诲瀷鍒ゆ柇
        if (a instanceof Cat)  {  // 鐚仛鐨勪簨鎯� 
            Cat c = (Cat)a;  
            c.work();  
        } else if (a instanceof Dog) { // 鐙楀仛鐨勪簨鎯� 
            Dog c = (Dog)a;  
            c.work();  
        }  
    }  
}
 
abstract class Animal {  
    abstract void eat();  
}  
  
class Cat extends Animal {  
    public void eat() {  
        System.out.println("吃鱼");  
    }  
    public void work() {  
        System.out.println("捉老鼠");  
    }  
}  
  
class Dog extends Animal {  
    public void eat() {  
        System.out.println("吃骨头");  
    }  
    public void work() {  
        System.out.println("看门");  
    }  
}