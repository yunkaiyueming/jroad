package thread;

import java.util.concurrent.*;

//3.实现CallAble接口: 实现CallAble方法，重写call方法，创建执行服务，提高执行，获取执行结果，关闭服务
public class Demo3 implements Callable<Integer> {

    @Override
    public Integer call() throws Exception {
        System.out.println("demo3 call run");
        return 1;
    }

    //可以执行异常
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Demo3 d1 = new Demo3();
        Demo3 d2 = new Demo3();
        Demo3 d3 = new Demo3();

        ExecutorService ser = Executors.newFixedThreadPool(3);
        Future<Integer> r1 = ser.submit(d1);
        Future<Integer> r2 = ser.submit(d2);
        Future<Integer> r3 = ser.submit(d3);

        Integer res1 = r1.get();
        System.out.println(res1);

        Integer res2 = r2.get();
        System.out.println(res1);

        Integer res3 = r3.get();
        System.out.println(res1);

        ser.shutdown();
    }


}
