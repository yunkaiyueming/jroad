package thread;

//口红
class LipStick{
}

//镜子
class Glass{

}

public class DeadLockDemo implements Runnable {
    public int choice;

    static LipStick lip = new LipStick();
    static Glass gla = new Glass();

    public DeadLockDemo(int choice){
        this.choice = choice;
    }

//    @Override
    //会产生死锁，相互等待
    public void run1() {
        if(choice==1){
            synchronized (lip){
                System.out.println("先获得lip");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                synchronized (gla){
                    System.out.println("在获得gla");
                }
            }
        }else{
            synchronized (gla){
                System.out.println("先获得gal");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                synchronized (lip){
                    System.out.println("在获得lip");
                }
            }
        }
    }

    @Override
    public void run() {
        if(choice==1){
            synchronized (lip){
                System.out.println("先获得lip");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            synchronized (gla){
                System.out.println("在获得gla");
            }
        }else{
            synchronized (gla){
                System.out.println("先获得gal");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            synchronized (lip){
                System.out.println("在获得lip");
            }
        }
    }


    public static void main(String[] args){
        DeadLockDemo d1=  new DeadLockDemo(1);
        DeadLockDemo d2 =  new DeadLockDemo(2);
        new Thread(d1).start();
        new Thread(d2).start();
    }
}
