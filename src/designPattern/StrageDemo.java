package designPattern;



interface fight{
    void exec();
}

class Tfight implements fight{
    public void exec(){
        System.out.println("use t");
    }
}

class Ffight implements fight{
    public void exec(){
        System.out.println("use f");
    }
}

class PeopleWithWeapen{
    public static void attack(fight f){//用接口 实现 传递不同实现接口的类，走不同接口的方法
        f.exec();
    }
}

public class StrageDemo {
    //策略模式：定义了算法族，分别封装起来，让它们之间可相互替换，此模式让算法的变化独立于使用算法的客户
    public static void main(String[] args){
        PeopleWithWeapen.attack(new Tfight());
        PeopleWithWeapen.attack(new Ffight());
    }
}
