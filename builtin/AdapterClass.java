package builtin;

public class AdapterClass {
    public static void main(String[] args) {
      show(new Cat());  // 毛
      show(new Dog());  // 浠� Dog 瀵硅薄璋冪敤 show 鏂规硶
                
      Animal a = new Cat();  // 鍚戜笂杞瀷  
      a.eat();               // 璋冪敤鐨勬槸 Cat 鐨� eat
      
      Cat c = (Cat)a;        // 鍚戜笅杞瀷  
      c.work();        // 璋冪敤鐨勬槸 Cat 鐨� work
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
        System.out.println("鍚冮奔");  
    }  
    public void work() {  
        System.out.println("鎶撹�侀紶");  
    }  
}  
  
class Dog extends Animal {  
    public void eat() {  
        System.out.println("鍚冮澶�");  
    }  
    public void work() {  
        System.out.println("鐪嬪");  
    }  
}