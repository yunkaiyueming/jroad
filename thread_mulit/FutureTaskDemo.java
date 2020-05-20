import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

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
    public static void main(String[] args) throws InterruptedException {
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


}
