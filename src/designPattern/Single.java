package designPattern;

class Car {
    private static final Car car = new Car();

    private Car(){} //构造方法为私有方法，禁止调用，只能通过getInstance方法得到

    public static Car getInstance(){
        return car;
    }
}

public class Single {//只会获得到1个单个实例
    public static void main(String[] args){
        Car car = Car.getInstance();
        System.out.println("调用静态方法："+ car.hashCode() );

        Car car2 = Car.getInstance();
        System.out.println("调用静态方法："+ car2.hashCode() );

        Car car3 = Car.getInstance();
        System.out.println("调用静态方法："+ car3.hashCode()+car3.equals(car2) );
    }
}
