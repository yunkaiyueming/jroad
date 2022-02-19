package thread;

//wait 和notify 来解决 线程通信
public class WaitDemo {
    public static void main(String[] args) {
        ThreadB b = new ThreadB();
        b.start();

//        try {
//            Thread.sleep(1000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

        synchronized (b) {
            try {
                System.out.println("Waiting for b to complete...");
                b.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("Total is: " + b.total);
        }
    }
}

class ThreadB extends Thread {
    int total;

    @Override
    public void run() {
        synchronized (this) {
            for (int i = 0; i < 100; i++) {
                total += i;
            }
            System.out.println("start to notify ");
            notify();
        }
    }
}