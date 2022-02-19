package designPattern;

import java.awt.desktop.SystemSleepEvent;

interface Power {
    String output();
}

class V5Power implements Power {
    static String pv = "5";

    public String output() {
        return V5Power.pv;
    }
}

class V220Power {
    static String pv = "220";
}

public class Adapter {
    public Power p;

    public static V220Power changeToV220(Power p) {
        return new V220Power();
    }
}

class Adapter2 {
    public static V220Power changeToV220(V5Power v) {
        return new V220Power();
    }
}


class Mobile {
    public static void input(V220Power P) {
        System.out.println("success");
    }

    public static void main(String[] args) {
        Mobile.input(new V220Power());
        //2中实现方式，适配器的思想是，将一个类通过适配转换，变成另一个可以使用的类，说适配器的功能就是把一个接口转成另一个接口
        Mobile.input(Adapter.changeToV220(new V5Power()));
        Mobile.input(Adapter2.changeToV220(new V5Power()));
    }
}

