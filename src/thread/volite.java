package thread;

//当多个线程之间需要根据某个条件确定 哪个线程可以执行时，要确保这个条件在 线程 之间是可见的。因此，可以用volatile修饰。
//
//综上，volatile关键字的作用是：使变量在多个线程间可见（可见性）
class RunThread extends Thread {

    private boolean isRunning = true;//xianche
    private volatile boolean isRunning2 = true; //使用volatile修改的变量，保证在其他线程的可见性

    public void setRunning(boolean isRunning) {
        this.isRunning = isRunning;
    }

    public void setRunning2(boolean isRunning2) {
        System.out.println("修改isRunning2为false。。。。");
        this.isRunning2 = isRunning2;
    }

    @Override
    public void run() {
//        System.out.println("进入到run方法中了");
//        while (isRunning == true) { //使用自己线程的isRunning变量，不会修改值
//        }
//        System.out.println("线程执行完成了");

        System.out.println("进入到run方法中了");
        while (isRunning2 == true) { //volite是自己的值，会从主内存中重新读值
        }
        System.out.println("线程执行完成了");
    }
}

public class volite {
//    public static void main(String[] args) {
//        try {
//            RunThread thread = new RunThread();
//            thread.start();
//            Thread.sleep(1000);
//            thread.setRunning(false);//将线程中的isRunning设置为false时，
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//    }

    public static void main(String[] args) {
        try {
            RunThread thread = new RunThread();
            thread.start();
            Thread.sleep(1000);
            thread.setRunning2(false);//将线程中的isRunning2设置为false时，
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
