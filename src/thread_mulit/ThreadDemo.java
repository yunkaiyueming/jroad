import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

//继承Thread类实现现成类，在自己类中实现run方法
class BThread extends Thread {
    public BThread() {
        super("[BThread] Thread");
    }

    ;

    public void run() {
        String threadName = Thread.currentThread().getName();
        System.out.println(threadName + " start.");
        try {
            for (int i = 0; i < 5; i++) {
                System.out.println(threadName + " loop at " + i);
                Thread.sleep(1000);
            }
            System.out.println(threadName + " end.");
        } catch (Exception e) {
            System.out.println("Exception from " + threadName + ".run");
        }
    }
}

class AThread extends Thread {
    BThread bt;

    public AThread(BThread bt) {
        super("[AThread] Thread");
        this.bt = bt;
    }

    public void run() {
        String threadName = Thread.currentThread().getName();
        System.out.println(threadName + " start.");
        try {
            bt.join();
            System.out.println(threadName + " end.");
        } catch (Exception e) {
            System.out.println("Exception from " + threadName + ".run");
        }
    }
}

//实现Runable接口，将类对象作为Thread的执行对象
class MyRunable implements Runnable {
    @Override
    public void run() {
        System.out.println("start new thread with MyRunable!");
    }
}

public class ThreadDemo {
    //调用join方法 即等待 join的调用线程执行完成
    public static void main1(String[] args) {
        String threadName = Thread.currentThread().getName();
        System.out.println(threadName + " start.");
        BThread bt = new BThread();
        AThread at = new AThread(bt);
        try {
            bt.start();//b线程开始启动
            Thread.sleep(2000);
            at.start();//a线程开始启动，里面 b.join会等待 b完成，
            at.join();//等待a完成
        } catch (Exception e) {
            System.out.println("Exception from main");
        }
        System.out.println(threadName + " end!");
    }

    //启动1个线程的多种写法
//    New：新创建的线程，尚未执行；
//    Runnable：运行中的线程，正在执行run()方法的Java代码；
//    Blocked：运行中的线程，因为某些操作被阻塞而挂起；
//    Waiting：运行中的线程，因为某些操作在等待中；
//    Timed Waiting：运行中的线程，因为执行sleep()方法正在计时等待；
//    Terminated：线程已终止，因为run()方法执行完毕。

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        Thread t1 = new BThread();//启动1个线程，调用start方法 即可执行thread中的run方法
        t1.start();

        Thread t2 = new Thread(new MyRunable()); //实现Runnable接口,调用start执行方法run
        t2.start();

        //使用lambda语法
        Thread t3 = new Thread(() -> {
            System.out.println("start new thread in lambdas");
        });
        t3.start();

        //匿名Runable接口
        Thread t4 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("start new thread in no name runable");
            }
        });
        t4.run();
        System.out.println("main end");

        //通过Callable和Future创建线程
        class MyCallable implements Callable<String> {
            String v = "";

            public MyCallable(String v) {
                this.v = v;
            }

            @Override
            public String call() throws Exception {
                return this.v;
            }
        }

        FutureTask<String> futureTask = new FutureTask<>(new MyCallable("zhangsan"));
        FutureTask<String> futureTask2 = new FutureTask<>(new MyCallable("lisi"));
        /***
         * futureTask 实现了 Runnable接口
         * 所以新建线程的时候可以传入futureTask
         * FutureTask重写的run方法中实际是调用了Callable接口在call()方法
         * 所以执行线程的时候回执行call方法的内容
         */
        Thread thread = new Thread(futureTask);
        thread.start();
        String value = futureTask.get();
        System.out.println(value);

        Thread thread2 = new Thread(futureTask2);
        thread2.start();
        String value2 = futureTask2.get();
        System.out.println(value2);
    }

}
