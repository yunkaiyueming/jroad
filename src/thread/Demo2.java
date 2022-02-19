package thread;

//继承Thread类，重写run方法，调用start开启线程
public class Demo2 extends Thread {
    private Thread t;
    private String threadName;

    Demo2(String name) {
        threadName = name;
        System.out.println("Creating " + threadName);
    }

    @Override
    public void run() {
        try {
            for (int i = 4; i > 0; i--) {
                System.out.println("Running Thread: " + threadName + ", " + i);
                // 让线程睡眠一会
                Thread.sleep(50);
            }
        } catch (InterruptedException e) {
            System.out.println("Thread " + threadName + " interrupted.");
        }
        System.out.println("Thread " + threadName + " exiting.");
    }

    @Override
    public void start() {
        System.out.println("Starting " + threadName);
        if (t == null) {
            t = new Thread(this, threadName);
            t.start();
        }
    }

    //两个线程交替运行
    public static void main(String args[]) {
    //创建对象，调用start方法
        Demo2 T1 = new Demo2("Thread1");
        T1.start(); //异步

        Demo2 T2 = new Demo2("Thread2");
        T2.start();//异步

        System.out.println("end over");

    }
}
