package proxy;

interface Sell {
    void sell();

    void ad();
}


class Vendor implements Sell {
    public void sell() {
        System.out.println("vendor In sell method");
    }

    public void ad() {
        System.out.println("vendor ad method");
    }
}

//代理类，通过组合Vendor方式，调用自己组合成员Vendor对应的方法来调用sell,add(),
class BusinessAgent implements Sell {
    private Vendor mVendor;

    public BusinessAgent(Vendor vendor) {
        mVendor = vendor;
    }

    //如果有一些逻辑处理，还可以放在这里，不用修改委托类的代码
    public void sell() {
        mVendor.sell();
    }

    public void ad() {
        mVendor.ad();
    }
}

public class Demo1 {
    public static void main(String[] args) {
        Vendor v1 = new Vendor();
        BusinessAgent b1 = new BusinessAgent(v1);
        b1.sell();
        b1.ad();
    }
}
