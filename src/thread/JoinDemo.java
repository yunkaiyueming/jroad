package thread;

public class JoinDemo implements Runnable{

    @Override
    public void run(){
        for(int i=0;i<50;i++){
            System.out.println(Thread.currentThread().getName()+i+" vip run");

//            if(i==30){
//                Thread.yield(); //线程礼让，重新进入cpu竞争，不一定礼让成功
//                System.out.println(Thread.currentThread().getName()+i+" 开始礼让");
//            }
        }
        System.out.println(Thread.currentThread().getName()+"vip end");
    }

    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(new JoinDemo());
        t.start();

        for(int i=0;i<20;i++){
            if(i==10){
                t.join();//让JoinDemo优先执行
            }
            System.out.println(Thread.currentThread().getName()+i+" run ");
        }
    }
}
