package thread;

public class ThreadStateDemo implements Runnable{

    @Override
    public void run(){
        for(int i=0;i<5;i++) {
            try {
                Thread.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + i + " vip run");
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(new ThreadStateDemo());
        t.setPriority(10);//设置优先级

        Thread.State st = t.getState(); //New
        System.out.println(t.getState());

        t.start();
        System.out.println(t.getState());//Runabble

        while (st!= Thread.State.TERMINATED){
            System.out.println("listen : "+t.getState());//TIMED_WAITING BLOCKED
            st = t.getState();
        }

        System.out.println(t.getState());//TERMINATED
    }
}
