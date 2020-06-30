package thread;

//waitwait方法是一个本地方法，其底层是通过一个叫做监视器锁的对象来完成的
//所以上面之所以会抛出异常，是因为在调用wait方式时没有获取到monitor对象的所有权，那如何获取monitor对象所有权？Java中只能通过Synchronized关键字来完成
public class WaitDemo2 {
    public synchronized void testWait(){//增加Synchronized关键字
        System.out.println("Start-----");
        try {
            System.out.println("等待wait....");
            wait();
            System.out.println("wait完成....");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("End-------");
    }

    public synchronized void testWait2(){//增加Synchronized关键字
        System.out.println("Start-----");
        try {
            System.out.println("等待wait....");
            wait(1000);
            System.out.println("wait了1s后....");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("End-------");
    }

    public synchronized void callAll(){//增加Synchronized关键字
        System.out.println("notify -----");
        notifyAll();
    }

    public static void main(String[] args) throws InterruptedException {
        final WaitDemo2 test = new WaitDemo2();
        new Thread(new Runnable() {
            @Override
            public void run() {
                test.testWait();
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                test.testWait();
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                test.testWait2();
            }
        }).start();

        Thread.sleep(2000);
        test.callAll();
    }
}
