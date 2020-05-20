import java.util.Objects;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.locks.ReentrantLock;

//多线程更新alliancelv
public class ThreadUpateAllianceLv {
    public static AtomicLong allianceExp = new AtomicLong(0);
    public static volatile AtomicInteger allianceLv = new AtomicInteger(0);

    public static final int maxLv = 2;
    public static int thread_num = Runtime.getRuntime().availableProcessors()*2;

    public static long st;

    public static void main(String[] args) {

        ExecutorService cachedThreadPool = Executors.newCachedThreadPool();

        int index = 0;

        st = System.currentTimeMillis();
        System.out.println("st==>"+st);

        while(true){
            index++;
            if(index>thread_num) break;

            int finalIndex = index;
            cachedThreadPool.execute(new Runnable() {
                @Override
                public void run() {
                    Thread.currentThread().setName("thread-"+ finalIndex);
                    while(true){
                        if(upAllianceExp()==-1){
                            System.out.println("当前线程退出"+Thread.currentThread().getName());
                            break;
                        }
                    }
                }
            });
        }

        while(true){
            System.out.println("not finish"+getAllianceLv());
            if(getAllianceLv() >= maxLv){
                long et = System.currentTimeMillis();
                System.out.println("cost time:"+ String.format("%.2f", (float)(et-st)/1000) +" s");
                cachedThreadPool.shutdownNow();
                break;
            }
        }
    }

    public static synchronized long getAllianceLv(){return allianceLv.get();}

    public static boolean updateAllianceLv2(int prev, int newlv){
        if(allianceLv.compareAndSet(prev, newlv)){
            System.out.println("更新lv成功:"+prev+" ==> "+ newlv);
            return true;
        }else {
            System.out.println("更新lv失败:" + prev + " =/=> " + newlv);
            return false;
        }
    }

    public  synchronized static  void updateAllianceLv(int newlv){
        allianceLv.set(newlv);
        System.out.println(Thread.currentThread().getName()+" 更新lv成功: ===>" + newlv);
    }

    public synchronized static long getAddExpNumByLv(){
        long nowlv = getAllianceLv();
        if(nowlv==0) return 1;
        return nowlv;
    }

    public synchronized static int upAllianceExp(){
            long oldV = allianceExp.get();
            long addnum = getAddExpNumByLv();
            long newV = oldV + addnum;
            if (getAllianceLv() >= maxLv) return -1;
            if (newV >= (long) Math.pow(11, maxLv) + maxLv) return -1;

            if (allianceExp.compareAndSet(oldV, newV)) {
                System.out.println("更新exp成功:" + oldV + " ==> " + newV);
                for (int lv = 1; lv <= maxLv; lv++) {
                    if (newV >= (long) Math.pow(11, lv) && newV < (long) Math.pow(11, lv + 1)) {
//                    updateAllianceLv2(lv-1, lv);
                        updateAllianceLv(lv);

                        if (lv >= maxLv) return -1;

                        return 1;
                    }
                }
                return 0;
            } else {
                //System.out.println("更新exp失败:"+ oldV+" =/=> "+ newV);
                return 0;
            }

    }
}
