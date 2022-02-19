package builtin;
// javac -encoding utf-8 HelloWorld.java && java HelloWorld

public class HelloWorld {
    int a, b, c;         // 声明三个int型整数：a、 b、c
    int d = 3, e = 4, f = 5; // 声明三个整数并赋予初值
    byte z = 22;         // 声明并初始化 z
    String s = "runoob";  // 声明并初始化字符串 s
    double pi = 3.14159; // 声明了双精度浮点型变量 pi
    char x = 'x';        // 声明变量 x 的值是字符 'x'。

    static int allClicks = 0;    // 类变量
    String str = "hello world";  // 实例变量

    //salary是静态的私有变量
    private static double salary;

    // DEPARTMENT是一个常量 在 Java 中使用 final 关键字来修饰常量
    public static final String DEPARTMENT = "开发人员";

    boolean isOk = false;
    boolean isFlag = true;

    public int[] intArrs = {1, 2, 3};

    public void testSomeThing() {
        int i = 0;  // 局部变量
        i += 5;
        System.out.println("i的值：" + i);
    }

    //获取类变量
    public void getSomething() {
        System.out.println(d + e + f);
        System.out.println(str);
    }

    public synchronized void showDetails() {
        System.out.println("synchronized关键字声明的方法同一时间只能被一个线程访问");
    }

    public void showWhilePrint() {
        int i = 0;
        while (i < 10) {
            if (i < 5) {
                System.out.println("转到i了");
            }
            i++;
            System.out.print(i);
        }
        for (i = 0; i < 10; i++) {
            System.out.print(i);
        }
        System.out.print("\n");
        String[] names = {"James", "Larry", "Tom", "Lacy"};
        for (String name : names) {
            System.out.print(name + ";");
        }
    }

    //入口方法
    public static void main(String[] args) {
        HelloWorld hw = new HelloWorld();
        hw.testSomeThing();
        hw.getSomething();
        hw.showDetails();
        hw.showWhilePrint();
        if (hw instanceof HelloWorld) {
            System.out.println("hw是HelloWorld的实例");
        }
    }
}