import javax.xml.namespace.QName;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.*;

//多线程协作组件：信号量（Semaphore）、倒计数器：CountDownLatch、循环栅栏：CyclicBarrier、交换器：Exchanger
//Semaphore 控制资源同时的访问数量
//CountDownLatch 任务倒计数器，等待其他n个任务完成后才能执行
//CyclicBarrier 让一组现成到达某个状态后再全部同时执行，且可以重复使用
//Exchanger Exchanger是适用在两个线程之间数据交换的并发工具类，

public class ThreadCommunicate {
    //控制资源同时的并发访问的数量 Semaphore
    public static void main3(String[] args) {
        Semaphore semaphore = new Semaphore(3);
        for (int i = 0; i < 5; i++) {
            String thread_name = "线程" + i;
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
        new Thread() {
            public void run() {
                try {
                    System.out.println("子线程" + Thread.currentThread().getName() + "正在执行");
                    Thread.sleep(3000);
                    System.out.println("子线程" + Thread.currentThread().getName() + "执行完毕");
                    latch.countDown();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            ;
        }.start();

        new Thread() {
            public void run() {
                try {
                    System.out.println("子线程" + Thread.currentThread().getName() + "正在执行");
                    Thread.sleep(3000);
                    System.out.println("子线程" + Thread.currentThread().getName() + "执行完毕");
                    latch.countDown();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            ;
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
    public static void main5(String[] args) {
        int N = 5;
        //CyclicBarrier barrier  = new CyclicBarrier(N);
        CyclicBarrier barrier = new CyclicBarrier(N, new Runnable() {
            public void run() {
                System.out.println("好朋友，开始一起干");
            }
        });

        for (int i = 1; i <= N; i++) {
            String thread_name = "线程" + i;
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        System.out.println(Thread.currentThread().getName() + "开始干活");
                        Thread.sleep(2000);
                        System.out.println(Thread.currentThread().getName() + "干活结束,等待一起走");
                        try {
                            barrier.await();
                        } catch (BrokenBarrierException e) {
                            e.printStackTrace();
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } finally {
                    }

                    System.out.println(Thread.currentThread().getName() + " 干活结束");

                }
            }, thread_name).start();
        }
    }

    //Exchanger Exchanger是适用在两个线程之间数据交换的并发工具类，
    // 它的作用是找到一个同步点，当两个线程都执行到了同步点(exchange方法)之后(有一个没有执行到就一直等待，也可以设置等待超时时间)，就将自身线程的数据与对方交换。
    public static void main6(String[] args) {
        Exchanger<String> changeV = new Exchanger<String>();
        class Task1 extends Thread {
            public String v;
            public Exchanger<String> ex;

            public Task1(Exchanger<String> ex, String v) {
                this.ex = ex;
                this.v = v;
            }

            public void run() {
                System.out.println(Thread.currentThread().getName() + "拥有：" + v);
                String getv = null;
                try {
                    getv = ex.exchange(v);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + "现在拥有：" + getv);
            }
        }

        Thread t1 = new Task1(changeV, "finish");
        Thread t2 = new Task1(changeV, "apple");
        t1.start();
        try {
            Thread.sleep(2000);
        } catch (Exception e) {
        }

        t2.start();
        try {
            Thread.sleep(3000);
        } catch (Exception e) {
        }
    }

    //交换器Exchanger 使用runable接口方式
    public static void main(String[] args) {
        // 新建一个Exchanger
        final Exchanger<String> exchanger = new Exchanger<String>();
        // 新建一个线程，该线程持有资源为白粉
        ExecutorService service = Executors.newFixedThreadPool(1);
        service.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println(Thread.currentThread().getName() + "我有白粉，准备交换钱……");
                    Thread.sleep(5000);
                    /*
                     *  在此处等待另外一个线程到来，并进行数据交换，如果没有另一个线程到来，那么当前这个线程会处于休眠状态，直到3件事情发生：
                     *  1、等待另一个线程到达交换点
                     *  2、被另一个线程中断(警察赶来了，打断了交易)
                     *  3、等待超时，当调用exchanger.exchange(x, timeout, unit)方法时有效(毒贩查觉到危险，没有来交易)
                     */
                    String result = exchanger.exchange("白粉");
                    System.out.println(Thread.currentThread().getName() + "换回来的为:" + " " + result + " 原来为白粉！");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        // 新建一个线程，该线程持有资源为钱
        ExecutorService service1 = Executors.newFixedThreadPool(1);
        service1.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println(Thread.currentThread().getName() + "我有钱，准备交换白粉");
                    Thread.sleep(2000);
                    String result = exchanger.exchange("钱");
                    System.out.println(Thread.currentThread().getName() + "换回来的为:" + " " + result + " 原来为钱！");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        // 释放线程资源
        service.shutdown();
        service1.shutdown();
    }
}
