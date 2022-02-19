package cron;

public class CronStudy implements Runnable {

    public static void main(String[] args) {
        CronStudy cs = new CronStudy();
        cs.go();
        //cs.go1();
    }

    @Override
    public void run() {
        while (true) {
            System.out.println("start study.....");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

    }

    public void go() {
        Thread t = new Thread(this);
        t.start();//异步调用本对象的run方法
        System.out.println("run end...");
    }

    public void go1() {
        this.run();//同步调用
        System.out.println("run end...");
    }

}
