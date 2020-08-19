package designPattern;

interface People{
    public void say();
    public void talk();
}

class Teacher implements People{
    public void say(){
        System.out.println("teacher say");
    }

    public void talk(){
        System.out.println("teacher talk");
    }
}

class Student implements People{
    public void say(){
        System.out.println("Student say");
    }

    public void talk(){
        System.out.println("Student talk");
    }
}

class Factory{
    public enum PEOPLETYPE{
        TEAC,STUD
    }

    public People createPeople(PEOPLETYPE type){
        switch (type){
            case STUD:
                return new Student();
            case TEAC:
                return new Teacher();
            default:
                throw new IllegalArgumentException("KingdomType not supported.");
        }
    }
}

class StrageTalk{
    static void talkStrage(People p){
        p.talk();
    }
}

public class AbstractFactory {
    public static void main(String[] args){
        Factory fac = new Factory();
        People p1 = fac.createPeople(Factory.PEOPLETYPE.TEAC);//抽象工厂模式，
        p1.say();
        p1.talk();

        People p2 = fac.createPeople(Factory.PEOPLETYPE.STUD);
        p2.say();
        p2.talk();

        StrageTalk.talkStrage(p1);//策略模式
        StrageTalk.talkStrage(p2);
    }

}
