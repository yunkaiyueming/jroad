import java.util.Map;
import java.util.concurrent.*;


//newCachedThreadPool创建一个可缓存线程池，如果线程池长度超过处理需要，可灵活回收空闲线程，若无可回收，则新建线程。
//newFixedThreadPool 创建一个定长线程池，可控制线程最大并发数，超出的线程会在队列中等待。
//newScheduledThreadPool 创建一个定长线程池，支持定时及周期性任务执行。
//newSingleThreadExecutor 创建一个单线程化的线程池，它只会用唯一的工作线程来执行任务，保证所有任务按照指定顺序(FIFO, LIFO, 优先级

//线程池的使用
public class ThreadPoolDemo {
    //使用newFixedThreadPool
    public static void main6(String[] args) {
        ExecutorService newFixedThreadPool = Executors.newFixedThreadPool(3);
        for (int i = 0; i < 10; ++i) {
            newFixedThreadPool.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName());
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
    }

    //使用newCachedThreadPool
    public static void main7(String[] args) {
        ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
//        s
        for (int i = 0; i < 10; ++i) {
            cachedThreadPool.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName());
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
    }

    //newScheduledThreadPool 线程池实现定时&周期性执行任务
    public static void main8(String[] args) {
        ScheduledExecutorService scheduledThreadPool = Executors.newScheduledThreadPool(3);
        scheduledThreadPool.schedule(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName());
                System.out.println("delay 3 seconds");
            }
        },1, TimeUnit.SECONDS );

        //周期性执行任务
        scheduledThreadPool.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName());
                System.out.println("delay 1 seconds, and excute every 3 seconds");
            }
        }, 1, 3, TimeUnit.SECONDS);
    }

    //newSingleThreadExecutor 单一示例 只会用唯一的工作线程来执行任务，保证所有任务按照指定顺序(FIFO, LIFO, 优先级)执行
    public static void main(String[] args) {
        ConcurrentHashMap mapData = new ConcurrentHashMap();
        Map<String,String> mapData2 = new ConcurrentHashMap<String, String>();
        mapData2.put("school", "middle_school");
        mapData2.put("pwd", "111");
        for (Map.Entry<String, String> entry : mapData2.entrySet()) {
            String key = entry.getKey();
            String val = entry.getValue();
            System.out.println(key+"===>"+val);
        }

        ExecutorService singleThreadExecutor = Executors.newSingleThreadExecutor();

        singleThreadExecutor.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println("开始干活第1个:"+ Thread.currentThread().getName());
                mapData.put("age", 12);
            }
        });

        singleThreadExecutor.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println("开始干活第2个:"+ Thread.currentThread().getName());
                mapData.put("name", "zs");

                try {
                    Thread.sleep(1200);
                }catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        singleThreadExecutor.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println("开始干活第3个:"+ Thread.currentThread().getName());
                System.out.println(mapData.get("name"));
                System.out.println(mapData.keys());
            }
        });

        System.out.println("end over");
        singleThreadExecutor.shutdown();
    }

}
