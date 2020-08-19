package designPattern;

import java.util.ArrayList;
import java.util.List;

interface Com{
    void see(String a);
}

class Observer1 implements Com{
    public void see(String a){
        System.out.println("ob1 see"+a);
    }
}

class Observer2 implements Com{
    public void see(String a){
        System.out.println("ob2 see"+a);
    }
}

class Role{
    public String talk = "";
    List<Com> observers = new ArrayList<>();
    List<String> ss = new ArrayList<>();

    public void doSomeThing(){
        for(Com i:observers){
            i.see(this.talk);
        }
    }

    public void addObserve(Com c){
        observers.add(c);
    }
}

public class ObserverDemo {

    //定义了对象之间的一对多的依赖，这样一来，当一个对象改变时，它的所有的依赖者都会收到通知并自动更新。
    public static void main(String[] args){
        Observer1 o1 = new Observer1();
        Observer2 o2 = new Observer2();

        Role role = new Role();
        role.talk = "hot weather";
        role.addObserve(o1);
        role.addObserve(o2);
        role.doSomeThing();
    }

}
