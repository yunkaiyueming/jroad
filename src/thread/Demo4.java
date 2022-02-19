package thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

//3.实现CallAble接口: 实现CallAble方法，重写call方法，创建执行服务，提高执行，获取执行结果，关闭服务
public class Demo4 implements Callable<Integer> {

    @Override
    public Integer call() throws Exception {
        int i = 0;
        for (; i < 10; i++) {
            System.out.println(Thread.currentThread().getName() + " " + i);
        }
        Thread.sleep(5000);
        return i+1;
    }

    public static void main(String[] args) {
        Demo3 ctt = new Demo3();

        FutureTask<Integer> ft = new FutureTask<>(ctt);
        for (int i = 0; i < 10000; i++) {
            System.out.println(Thread.currentThread().getName() + " 的循环变量i的值" + i);
            if (i == 10000-1) {
                new Thread(ft, "有返回值的线程").start();
            }
        }

        try {
            System.out.println("子线程的返回值：" + ft.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        System.out.println("end over");
    }


}
