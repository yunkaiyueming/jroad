
//synchornized的使用

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Counter {
    public static final Object lock = new Object();
    public static int count = 0;
}

class AddThread extends Thread {
    public void run() {
        for (int i = 0; i < 100000; i++) {
            Counter.count += 2;
            System.out.println("+1==>" + Counter.count);
        }
    }
}

class DecThread extends Thread {
    public void run() {
        for (int i = 0; i < 100000; i++) {
            Counter.count -= 2;
            System.out.println("-1==>" + Counter.count);
        }
    }
}

class AddThread1 extends Thread {
    public void run() {
        for (int i = 0; i < 100000; i++) {
            synchronized (Counter.lock) {
                Counter.count += 2;
                System.out.println("+1==>" + Counter.count);
            }
        }
    }
}

class DecThread1 extends Thread {
    public void run() {
        for (int i = 0; i < 100000; i++) {
            synchronized (Counter.lock) {
                Counter.count -= 2;
                System.out.println("-1==>" + Counter.count);
            }
        }
    }
}


//获取锁的顺序要一致，不然会产生死锁
class Counter2 {
    private int value = 0;
    private int another = 0;
    private final Object lockA = new Object();
    private final Object lockB = new Object();

    public void add(int m) {
        synchronized (lockA) { // 获得lockA的锁
            this.value += m;
            synchronized (lockB) { // 获得lockB的锁
                this.another += m;
            } // 释放lockB的锁
        } // 释放lockA的锁
    }

    public void dec(int m) {
        synchronized (lockA) { // 获得lockA的锁
            this.value -= m;
            synchronized (lockB) { // 获得lockB的锁
                this.another -= m;
            } // 释放lockB的锁
        } // 释放lockA的锁
    }
}


class Counter3 extends Thread {
    private final Lock lock = new ReentrantLock();
    private int count;

    public void run() {
        lock.lock();
        try {
            count += 1;
        } finally {
            lock.unlock();
        }
    }

    public void get() {
        System.out.println(count);
    }
}

public class SynchorizedDemo {
    //非并发安全操作，
    public static void main2(String[] args) throws Exception {
        var add = new AddThread();
        var dec = new DecThread();
        add.start();
        dec.start();
        add.join();
        dec.join();
        System.out.println(Counter.count);//结果并不一致，并不一定安全
    }

    //并发安全操作
//    找出修改共享变量的线程代码块；
//    选择一个共享实例作为锁；
//    使用synchronized(lockObject) { ... } 锁的对象必须一致
    //对static方法添加synchronized，锁住的是该类的Class实例。
    //用synchronized修饰的方法就是同步方法，它表示整个方法用的是this实例加锁。
    //一个类没有特殊说明，默认不是thread-safe；
    //Java的synchronized锁是可重入锁；
    public static void main3(String[] args) throws Exception {
        var add = new AddThread1();
        var dec = new DecThread1();
        add.start();
        dec.start();
        add.join();
        dec.join();
        System.out.println(Counter.count);//并发安全
    }


    //可重入锁
    //ReentrantLock是可重入锁，它和synchronized一样，一个线程可以多次获取同一个锁。
//    ReentrantLock可以替代synchronized进行同步；
//    ReentrantLock获取锁更安全；
//    必须先获取到锁，再进入try {...}代码块，最后使用finally保证释放锁；
//    可以使用tryLock()尝试获取锁。
    public static void main(String[] args) throws InterruptedException {
        var add = new Counter3();
        var dec = new Counter3();
        add.start();
        dec.start();
        add.join();
        dec.join();

        add.get();
        dec.get();

    }
}
