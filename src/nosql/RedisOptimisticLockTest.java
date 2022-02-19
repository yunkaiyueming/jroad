package nosql;

import org.springframework.util.CollectionUtils;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.Transaction;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class RedisOptimisticLockTest {

    private static final String redisIp = "127.0.0.1";
    private static final int reidsPort = 6379;

    public static void main(String[] args) {
        String optimisticLockKey = "OptimisticLock";
        ExecutorService executorService = Executors.newFixedThreadPool(20);
        try (Jedis jedis = new Jedis(redisIp, reidsPort)) {
            jedis.set(optimisticLockKey, "0");//设置初始值
        } catch (Exception e) {
            e.printStackTrace();
        }

        for (int i = 0; i < 200; i++) {
            //System.out.println("===第 "+i+" 个循环运行....");

            int userVar = i;
            executorService.execute(() -> {
                try (Jedis sigkillJedi = new Jedis(redisIp, reidsPort)) {
                    sigkillJedi.watch(optimisticLockKey);//监听锁的值

                    String optimisticLockStrValue = sigkillJedi.get(optimisticLockKey);
                    int optimisticLockIntValue = Integer.valueOf(optimisticLockStrValue);

                    String user = "用户" + (userVar + 1);
                    if (optimisticLockIntValue < 10) {
                        Transaction ts = sigkillJedi.multi();
                        ts.incr(optimisticLockKey);//值加1
                        ts.get(optimisticLockKey);

                        //执行事务，如果其他线程对watch keys中的value进行修改，则该事务将不会执行
                        List<Object> execResult = ts.exec();
                        //被别人抢到
                        if (CollectionUtils.isEmpty(execResult)) {
                            System.out.println(user + ",秒杀失败");
                        } else {
                            //秒杀成功
                            var mugetv = execResult.get(1).toString();
                            System.out.println(user + ",秒杀成功！当前成功人数：" + (optimisticLockIntValue + 1) + "成功人数：" + mugetv);
                        }

                    } else {
                        System.out.println("已经有10人秒杀成功,秒杀结束");
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
        }
        executorService.shutdown();
    }
}