import com.sun.tools.javac.Main;
import org.w3c.dom.html.HTMLImageElement;

import java.rmi.server.ExportException;
import java.util.Map;
import java.util.concurrent.*;

//获取线程返回值的几种方式
public class FutureTaskDemo {

    //使用Callable接口和FutureTask
    public static void main2(String[] args) throws ExecutionException, InterruptedException {
        class MyCallable implements Callable<String>{
            String v = "";

            public MyCallable(String v){
                this.v = v;
            }
            @Override
            public String call() throws Exception {
                return this.v;
            }
        }

        FutureTask<String> futureTask = new FutureTask<>(new MyCallable("zhangsan"));
        FutureTask<String> futureTask2= new FutureTask<>(new MyCallable("lisi"));
        /***
         * futureTask 实现了 Runnable接口
         * 所以新建线程的时候可以传入futureTask
         * FutureTask重写的run方法中实际是调用了Callable接口在call()方法
         * 所以执行线程的时候回执行call方法的内容
         */
        Thread thread = new Thread(futureTask);
        thread.start();
        String value = futureTask.get();
        System.out.println(value);

        Thread thread2 = new Thread(futureTask2);
        thread2.start();
        String value2 = futureTask2.get();
        System.out.println(value2);
    }

    //使用thread join方式 获取线程返回值
    public static void main3(String[] args) throws InterruptedException {
         class MyThreadReturn implements Runnable {
            /** 模拟线程执行完毕后主程序要获取的值*/
            private String returnValue;
            @Override
            public void run() {
                System.out.println("线程执行......");
                /** 模拟IO*/
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("线程执行完毕......");
                returnValue = "hello world!!!";
            }
            public String getReturnValue(){
                return returnValue;
            }
        }

        MyThreadReturn myThreadReturn = new MyThreadReturn();
        Thread thread = new Thread(myThreadReturn);//
        thread.start();
        /** 使用join 使用join方法可以让子线程执行完毕后再执行主线程 会阻塞主线程 */
        thread.join();
        System.out.println(myThreadReturn.getReturnValue());
    }

    //使用Callable接口和FutureTask
    public static void main4(String[] args) throws ExecutionException, InterruptedException, TimeoutException {
        class Task implements Callable<String>{
            public String call() throws Exception {
                Thread.sleep(3000);
                return "hello";
            }
        }

        //固定线程池
        ExecutorService executor = Executors.newFixedThreadPool(4);
        // 定义任务:
        Callable<String> task = new Task();
        // 提交任务并获得Future:
        Future<String> future = executor.submit(task);
        // 从Future获取异步执行返回的结果:
        //String result = future.get(); // 会阻塞，直到任务完成后才返回结果。

        try{
            String result = future.get(2, TimeUnit.SECONDS); // 会阻塞，但只等待2s 直到任务完成后才返回结果。
            System.out.println("获取返回结果"+result);
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("超时了");
        }

        executor.shutdownNow();
    }

    //CompletableFuture，它针对Future做了改进，可以传入回调对象，当异步任务完成或者发生异常时，自动调用回调对象的回调方法。
//    CompletableFuture的优点是：
//    异步任务结束时，会自动回调某个对象的方法；
//    异步任务出错时，会自动回调某个对象的方法；
//    主线程设置好回调后，不再关心异步任务的执行。

    public static String getV(){
        return "hello ";
    }

    public static String getV2(){
        return "world ";
    }

    public static void main5(String[] args) throws InterruptedException {
        CompletableFuture comFut = CompletableFuture.supplyAsync(FutureTaskDemo::getV); //异步提交任务
        comFut.thenAccept((result) -> {
            System.out.println("price: " + result);
        });
        // 如果执行异常:
        comFut.exceptionally((e) -> {
            //e.printStackTrace();
            return null;
        });
        // 主线程不要立刻结束，否则CompletableFuture默认使用的线程池会立刻关闭:
        Thread.sleep(200);
    }

    //使用 多个 CompleteFuture 串行执行
    public static void main6(String[] args) throws Exception {
        // 第一个任务:
        CompletableFuture<String> cfQuery = CompletableFuture.supplyAsync(() -> {
            return queryCode("中国石油");
        });
        // cfQuery成功后继续执行下一个任务:
        CompletableFuture<Double> cfFetch = cfQuery.thenApplyAsync((code) -> {
            return fetchPrice(code);
        });
        // cfFetch成功后打印结果:
        cfFetch.thenAccept((result) -> {
            System.out.println("price: " + result);
        });
        // 主线程不要立刻结束，否则CompletableFuture默认使用的线程池会立刻关闭:
        Thread.sleep(2000);
    }

    static String queryCode(String name) {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
        }
        return "601857";
    }

    static Double fetchPrice(String code) {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
        }
        return 5 + Math.random() * 20;
    }

    //CompletableFuture的anyOf执行的，只要任意一个返回结果，就完成操作
    public static void main7(String[] args) throws Exception {
        // 两个CompletableFuture执行异步查询:
        CompletableFuture<String> cfQueryFromSina = CompletableFuture.supplyAsync(() -> {
            return queryCode("中国石油", "https://finance.sina.com.cn/code/");
        });
        CompletableFuture<String> cfQueryFrom163 = CompletableFuture.supplyAsync(() -> {
            return queryCode("中国石油", "https://money.163.com/code/");
        });

        // 用anyOf合并为一个新的CompletableFuture:
        CompletableFuture<Object> cfQuery = CompletableFuture.anyOf(cfQueryFromSina, cfQueryFrom163);

        // 两个CompletableFuture执行异步查询:
        CompletableFuture<Double> cfFetchFromSina = cfQuery.thenApplyAsync((code) -> {
            return fetchPrice((String) code, "https://finance.sina.com.cn/price/");
        });
        CompletableFuture<Double> cfFetchFrom163 = cfQuery.thenApplyAsync((code) -> {
            return fetchPrice((String) code, "https://money.163.com/price/");
        });

        // 用anyOf合并为一个新的CompletableFuture:
        CompletableFuture<Object> cfFetch = CompletableFuture.anyOf(cfFetchFromSina, cfFetchFrom163);

        // 最终结果:
        cfFetch.thenAccept((result) -> {
            System.out.println("price: " + result);
        });
        // 主线程不要立刻结束，否则CompletableFuture默认使用的线程池会立刻关闭:
        Thread.sleep(200);
    }

    static String queryCode(String name, String url) {
        System.out.println("query code from " + url + "...");
        try {
            Thread.sleep((long) (Math.random() * 100));
        } catch (InterruptedException e) {
        }
        return "601857";
    }

    static Double fetchPrice(String code, String url) {
        System.out.println("query price from " + url + "...");
        try {
            Thread.sleep((long) (Math.random() * 100));
        } catch (InterruptedException e) {
        }
        return 5 + Math.random() * 20;
    }

    //join applyToEither CompleteableFuture applyToEither 二者中使用1个
    public static void main(String[] args) {
        //运行一个异步任务并且返回结果
        String result = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "Hi 真月";
        }).applyToEither(CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "Hi 雷尚";
        }), (s) -> {
            return s;
        }).join();
        System.out.println(result);
    }

    //CompletableFuture和thenCombine,join使用
    //thenCombine()被用来当两个独立的Future都完成的时候，用来做一些事情。
    public static void main9(String[] args) {
        String result = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "Hello ";
        }).thenCombine(CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "真月";
        }), (s1, s2) -> {
            return s1 + " " + s2;
        }).join();
        System.out.println(result);
    }


}
