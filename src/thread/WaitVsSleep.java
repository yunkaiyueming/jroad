package thread;

public class WaitVsSleep {
    public synchronized void sleepMethod(){
        System.out.println("Sleep start-----");
        try {
            Thread.sleep(1000);//sleep并不会释放锁
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Sleep end-----");
    }

    public synchronized void waitMethod(){
        System.out.println("Wait start-----");
        synchronized (this){
            try {
                wait(1000);////wait会释放锁 wait依靠取得对象锁
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Wait end-----");
    }

    //这个结果的区别很明显，通过sleep方法实现的暂停，程序是顺序进入同步块的，只有当上一个线程执行完成的时候，下一个线程才能进入同步方法，sleep暂停期间一直持有monitor对象锁，其他线程是不能进入的。而wait方法则不同，当调用wait方法后，当前线程会释放持有的monitor对象锁，因此，其他线程还可以进入到同步方法，线程被唤醒后，需要竞争锁，获取到锁之后再继续执行
    //wait方法依赖于同步，而sleep方法可以直接调用。而更深层次的区别在于sleep方法只是暂时让出CPU的执行权，并不释放锁。而wait方法则需要释放锁。
    public static void main(String[] args) {
        final WaitVsSleep test1 = new WaitVsSleep();
        for(int i = 0;i<3;i++){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    test1.sleepMethod();
                }
            }).start();
        }


        try {
            Thread.sleep(5000);//暂停十秒，等上面程序执行完成
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("----------分割线----------");


        final WaitVsSleep test2 = new WaitVsSleep();
        for(int i = 0;i<3;i++){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    test2.waitMethod();
                }
            }).start();
        }
    }
}