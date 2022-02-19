package thread_mulit;

import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

//实践java的各种锁
public class LockDemo {
    private ReentrantLock lock = new ReentrantLock(true); //公平锁
    //private ReentrantLock lock = new ReentrantLock(false); //非公平锁
    private ReentrantReadWriteLock rwlock = new ReentrantReadWriteLock(); //读写锁

    public void testFail() {
        try {
            lock.lock();
            System.out.println(Thread.currentThread().getName() + "获取到了锁");
        } catch (Exception e) {

        } finally {
            System.out.println(Thread.currentThread().getName() + "释放到了锁");
            lock.unlock();
        }
    }

    public void TestRead() {
        try {
            rwlock.readLock();
            System.out.println(Thread.currentThread().getName() + "进行读..");
        } finally {
            System.out.println(Thread.currentThread().getName() + "读完毕..");
        }
    }

    public void TestWrite() {
        try {
            rwlock.writeLock();
            System.out.println(Thread.currentThread().getName() + "进行写..");
        } finally {
            System.out.println(Thread.currentThread().getName() + "写完毕..");
        }
    }

    //公平锁和非公平锁
    public static void main2(String[] args) {
        LockDemo lockDemo = new LockDemo();
        Runnable runable = () -> {
            System.out.println(Thread.currentThread().getName() + "开始启动.....");
            lockDemo.testFail();
        };

        Thread[] tarr = new Thread[10];
        for (int i = 0; i < 10; i++) {
            tarr[i] = new Thread(runable);
            tarr[i].start();
        }
    }

    //可重入锁
    public static void main3(String[] args) {
        for (int i = 0; i < 10; i++) {
            new Thread(() -> A()).start();
        }
    }

    public static void main(String[] args) {
        LockDemo lockDemo = new LockDemo();
        Runnable runable = () -> {
            System.out.println(Thread.currentThread().getName() + "开始启动.....");
            lockDemo.TestRead();
            lockDemo.TestWrite();
        };

        Thread[] tarr = new Thread[10];
        for (int i = 0; i < 10; i++) {
            tarr[i] = new Thread(runable);
            tarr[i].start();
        }
    }

    public static synchronized void A() {
        System.out.println(Thread.currentThread().getName() + " in a");
        B();
    }

    public static synchronized void B() {
        System.out.println(Thread.currentThread().getName() + " in b");
    }


}
