package thread;

//wait方法依赖于同步，而sleep方法可以直接调用。而更深层次的区别在于sleep方法只是暂时让出CPU的执行权，并不释放锁。而wait方法则需要释放锁。
public class WaitDemo3 {
    public synchronized void testWait() {
        System.out.println(Thread.currentThread().getName() + " Start-----");
        try {
            wait(0); //调用wait方法后，线程是会释放对monitor对象的所有权的。
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " End-------");
    }

    public static void main(String[] args) throws InterruptedException {
        final WaitDemo3 test = new WaitDemo3();
        for (int i = 0; i < 5; i++) { //启动5个线程
            new Thread(new Runnable() {
                @Override
                public void run() {
                    test.testWait();//执行wait
                }
            }).start();
        }

        synchronized (test) {
            test.notify();//唤醒1个
        }
        Thread.sleep(3000);
        System.out.println("-----------分割线-------------");

        synchronized (test) {
            test.notifyAll();//唤醒剩下所有
        }
    }
}