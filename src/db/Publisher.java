package db;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import redis.clients.jedis.Jedis;

public class Publisher {
    private Jedis publisherJedis;
    private String channel;

    public Publisher(Jedis publishJedis, String channel) {
        this.publisherJedis = publishJedis;
        this.channel = channel;
    }

    public void startPublish() {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            while (true) {
                System.out.println("请输入message:");
                String line = reader.readLine();
                if (!"quit".equals(line)) {
                    publisherJedis.publish(channel, line);
                } else {
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}