import javax.xml.namespace.QName;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.*;

//多线程协作组件：信号量（Semaphore）、倒计数器：CountDownLatch、循环栅栏：CyclicBarrier、交换器：Exchanger
//Semaphore 控制资源同时的访问数量
//CountDownLatch 任务倒计数器，等待其他n个任务完成后才能执行
//CyclicBarrier 让一组现成到达某个状态后再全部同时执行，且可以重复使用

public class ThreadCommunicate {
    //控制资源同时的并发访问的数量 Semaphore
    public static void main3(String[] args) {
        Semaphore semaphore = new Semaphore(3);
        for (int i = 0; i < 5; i++) {
            String thread_name = "线程"+i;
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        semaphore.acquire();//申请资源
                        System.out.println(Thread.currentThread().getName() + "抢到车位");
                        Thread.sleep(2000);
                        System.out.println(Thread.currentThread().getName() + "归还车位");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } finally {
                        //释放资源
                        semaphore.release();
                    }

                }
            }, thread_name).start();
        }
    }

    //任务倒计数器，等待其他n个任务完成后才能执行 CountDownLatch
    public static void main4(String[] args) {
        final CountDownLatch latch = new CountDownLatch(2);
        new Thread(){
            public void run() {
                try {
                    System.out.println("子线程"+Thread.currentThread().getName()+"正在执行");
                    Thread.sleep(3000);
                    System.out.println("子线程"+Thread.currentThread().getName()+"执行完毕");
                    latch.countDown();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            };
        }.start();

        new Thread(){
            public void run() {
                try {
                    System.out.println("子线程"+Thread.currentThread().getName()+"正在执行");
                    Thread.sleep(3000);
                    System.out.println("子线程"+Thread.currentThread().getName()+"执行完毕");
                    latch.countDown();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            };
        }.start();

        try {
            System.out.println("等待2个子线程执行完毕...");
            latch.await();
            System.out.println("2个子线程已经执行完毕");
            System.out.println("继续执行主线程");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    //CyclicBarrier 让一组现成到达某个状态后再全部同时执行，且可以重复使用
    public static void main5(String[] args){
        int N = 5;
        //CyclicBarrier barrier  = new CyclicBarrier(N);
        CyclicBarrier barrier  = new CyclicBarrier(N, new Runnable(){
            public void run(){
                System.out.println("好朋友，开始一起干");
            }
        });

        for (int i = 1; i <= N; i++) {
            String thread_name = "线程"+i;
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        System.out.println(Thread.currentThread().getName() + "开始干活");
                        Thread.sleep(2000);
                        System.out.println(Thread.currentThread().getName() + "干活结束,等待一起走");
                        try {
                            barrier.await();
                        }catch(BrokenBarrierException e){
                            e.printStackTrace();
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } finally {
                    }

                    System.out.println(Thread.currentThread().getName()+" 干活结束");

                }
            }, thread_name).start();
        }
    }

    //ex
}
