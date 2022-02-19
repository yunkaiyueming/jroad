package thread;

public class SynchronizedDemo {
    public static Object object = new Object();

    public static void main(String[] args) {
        Thread1 thread1 = new Thread1();
        Thread2 thread2 = new Thread2();
        thread1.start();
        thread2.start();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    static class Thread1 extends Thread {
        @Override
        public void run() {
            System.out.println("Thread-0....");

            synchronized (object) {
                try {
                    System.out.println("线程" + Thread.currentThread().getName() + "调用了wait(),释放monitor，等待中。。。");
                    object.wait();//　调用某个对象的wait()方法，相当于让当前线程交出此对象的monitor，然后进入等待状态，等待后续再次获得此对象的锁
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("线程" + Thread.currentThread().getName() + "获取到通知，运行完成。");
            }
        }
    }

    static class Thread2 extends Thread {
        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName() + "....");

            synchronized (object) {
                object.notify();//调用某个对象的notify()方法能够唤醒一个正在等待这个对象的monitor的线程
                System.out.println("线程" + Thread.currentThread().getName() + "调用了object.notify()，通知其他等待。。");
            }
            //只有等调用完notify()或者notifyAll()并退出synchronized块，释放对象锁后,其余线程才可获得锁执行。
            System.out.println("线程" + Thread.currentThread().getName() + "释放了锁");
        }
    }
}