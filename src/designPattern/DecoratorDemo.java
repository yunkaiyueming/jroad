package designPattern;

interface iequp{
    void dps();
    void desc();
}

class WeaponA implements iequp{
    public void dps(){
        System.out.println("a dps"+20);
    }

    public void desc(){
        System.out.println("weapon a");
    }
}

class WeaponB implements iequp{
    public void dps(){
        System.out.println(30);
    }

    public void desc(){
        System.out.println("weapon a");
    }
}

interface iEquipDecorator extends iequp{
}

class blueEquipDecorator implements iEquipDecorator{
    private iequp equip;

    blueEquipDecorator(iequp e){
        this.equip=e;
    }

    @Override
    public void dps() {
        this.equip.dps();
        System.out.println("blue add 5");
    }

    @Override
    public void desc() {
        this.equip.dps();
        System.out.println("add blue");
    }
}

class redEquipDecorator implements iEquipDecorator{
    private iequp equip;

    redEquipDecorator(iequp e){
        this.equip=e;
    }

    @Override
    public void dps() {
        this.equip.dps();
        System.out.println("red add 10");
    }

    @Override
    public void desc() {
        this.equip.dps();
        System.out.println("add red");
    }
}

public class DecoratorDemo {
    //装饰者模式：若要扩展功能，装饰者提供了比集成更有弹性的替代方案，动态地将责任附加到对象上。
    //先简单描述下装饰者模式发挥作用的地方，当我们设计好了一个类，我们需要给这个类添加一些辅助的功能，并且不希望改变这个类的代码，这时候就是装饰者模式大展雄威的时候了。这里还体现了一个原则：类应该对扩展开放，对修改关闭。
    public static void main(String[] args) {
        iequp equip = new redEquipDecorator(new redEquipDecorator(new blueEquipDecorator(new WeaponA())));
        equip.dps();

        iequp equip2 = new blueEquipDecorator(new blueEquipDecorator(new redEquipDecorator(new WeaponB())));
        equip2.dps();
    }
}
