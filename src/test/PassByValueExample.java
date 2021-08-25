package test;

public class PassByValueExample {
    public static void main(String[] args) {
        Dog dog = new Dog("A");
        System.out.println(dog.getObjectAddress()); // Dog@4554617c
        func(dog);

        System.out.println("===== main ====");
        System.out.println(dog.getObjectAddress()); // Dog@4554617c
        System.out.println(dog.getName());          // func2a

        func2(dog); //传递的参数本质上 对象的地址，如果直接修改对象地址的数据，则修改了原对象的信息；，如果是换了引用地址，则原对象不变
        System.out.println("===== main ====");
        System.out.println(dog.getObjectAddress()); // Dog@4554617c
        System.out.println(dog.getName());          // A
    }

    private static void func(Dog dog) {
        System.out.println("===== func ====");
        System.out.println(dog.getObjectAddress()); // Dog@4554617c
        dog = new Dog("B");
        System.out.println(dog.getObjectAddress()); // Dog@74a14482
        System.out.println(dog.getName());          // B
    }

    private static void func2(Dog dog) {
        System.out.println("===== func2 ====");
        System.out.println(dog.getObjectAddress()); // Dog@4554617c
        dog.setName("func2a");
        System.out.println(dog.getObjectAddress()); // Dog@74a14482
        System.out.println(dog.getName());          // func2a
    }
}
