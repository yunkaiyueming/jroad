package db;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class TestPubMain {
    public static final String CHANNEL = "mychannel";
    public static final String HOST = "127.0.0.1";
    public static final int PORT = 6379;

    private final static JedisPoolConfig POOL_CONFIG = new JedisPoolConfig();
    private final static JedisPool JEDIS_POOL = new JedisPool(POOL_CONFIG, HOST, PORT, 0);

    public static void main(String[] args) {
        final Jedis subscriberJedis = JEDIS_POOL.getResource();
        final Jedis publisherJedis = JEDIS_POOL.getResource();
        final Subscriber subscriber = new Subscriber();
//        new Thread(new Runnable() {
//            public void run() {
//                try {
//                    System.out.println("Subscribing to mychannel,this thread will be block");
//                    subscriberJedis.subscribe(subscriber, CHANNEL);
//                    System.out.println("subscription ended");
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//            }
//        }).start();

        new Publisher(publisherJedis, CHANNEL).startPublish();
        publisherJedis.close();

        subscriber.unsubscribe();
        subscriberJedis.close();
    }
}