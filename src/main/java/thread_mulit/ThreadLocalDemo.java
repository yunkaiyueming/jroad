import java.util.Map;
import java.util.concurrent.TimeUnit;


public class ThreadLocalDemo {
    static void log(String s) {
        System.out.println(Thread.currentThread().getName() + ": " + s);
    }

    public static  void main2(String[] args){
        new Thread(() -> {
            log("running");
        }
        ).start();

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                log("runing2");
            }
        });
        t2.start();
    }

    //ThreadLocal相当于给每个线程都开辟了一个独立的存储空间，各个线程的ThreadLocal关联的实例互不干扰。
    //特别注意ThreadLocal一定要在finally中清除
    public static void main(String[] args) throws InterruptedException {
        ThreadLocal ctx = new ThreadLocal();

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName()+ctx.get());
                ctx.set("aa");
                System.out.println(Thread.currentThread().getName()+ctx.get());
            }
        }).start();

        Thread.sleep(2000);

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName()+ctx.get());
                ctx.set("bb");
                System.out.println(Thread.currentThread().getName()+ctx.get());
            }
        }).start();

    }

    public static class MyRunnable implements Runnable {
        private ThreadLocal threadLocal = new ThreadLocal();

        @Override
        public void run() {
            threadLocal.set((int) (Math.random() * 100D));
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {

            }
            System.out.println(threadLocal.get());
        }
    }

    public static void main4(String[] args) {
        MyRunnable sharedRunnableInstance = new MyRunnable();
        Thread thread1 = new Thread(sharedRunnableInstance);
        Thread thread2 = new Thread(sharedRunnableInstance);
        thread1.start();
        thread2.start();
    }

}


