package thread;

public class WaitVsJoin implements Runnable {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " start-----");
        int total = 0;
        for (int j = 1; j < 1000000000; j++) {
            total = total + j;
        }
        System.out.println(Thread.currentThread().getName() + " end------" + total);
    }

    //比两段代码的执行结果很容易发现，在没有使用join方法之间，线程是并发执行的，而使用join方法后，所有线程是顺序执行的。
    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 5; i++) {
            Thread test = new Thread(new WaitVsJoin());
            test.start();
            try {
                test.join(); //调用join方法,
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        for (int i = 0; i < 5; i++) {
            Thread test2 = new Thread(new WaitVsJoin());
            test2.start();
            try {
                test2.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }


        System.out.println("Finished~~~");
    }
}