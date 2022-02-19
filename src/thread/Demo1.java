package thread;

//通过实现 Runnable 接口: 实现Runnable接口，实现run方法，生成对象调用start方法
public class Demo1 implements Runnable {
    private Thread t;
    private String threadName;

    public Demo1(String name) {
        threadName = name;
        System.out.println("Creating " + threadName);
    }

    @Override
    public void run() {
        try {
            for (int i = 4; i > 0; i--) {
                System.out.println("Run Thread: " + threadName + ", " + i);
                // 让线程睡眠一会
                Thread.sleep(50);
            }
        } catch (InterruptedException e) {
            System.out.println("Thread " + threadName + " interrupted.");
        }
        System.out.println("Thread " + threadName + " exiting.");
    }

    public void start() {
        if (t == null) {
            t = new Thread(this, threadName);
            System.out.println("Starting1 " + threadName);
            t.start();
        }

        System.out.println("Starting2 " + threadName);
    }

    public void start2(){
        System.out.println("Starting2 " + threadName);
    }

    public static void main(String args[]) {
        Demo1 R1 = new Demo1("Thread1");
        R1.start();
        //R1.start();

        Demo1 R2 = new Demo1("Thread2");
        R2.start();
    }

    //
    public static void main1(String args[]){
        Demo1 d1 = new Demo1("t1");//同一个对象被多个线程使用
        new Thread(d1,"t1").start();
        new Thread(d1,"t2").start();
    }
}
