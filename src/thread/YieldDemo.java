package thread;

public class YieldDemo implements Runnable{

    @Override
    public void run(){
        System.out.println(Thread.currentThread().getName()+" run");
        Thread.yield(); //线程礼让，重新进入cpu竞争，不一定礼让成功
        System.out.println(Thread.currentThread().getName()+" end");
    }

    public static void main(String[] args){
        new Thread(new YieldDemo()).start();
        new Thread(new YieldDemo()).start();
    }
}
