package db;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class RedisClass{
	private Jedis jedis;

	public RedisClass(String host,int port,String pwd){
		this.jedis = new Jedis(host,port);
		//this.jedis.auth("admin");
	}

	public void testCmd(){
		System.out.println(this.jedis.ping());

		this.jedis.set("name","xinwen");
		System.out.println(this.jedis.get("name"));

		this.jedis.append("name", " is ok");
		System.out.println(this.jedis.get("name"));

		this.jedis.del("name");
		System.out.println(this.jedis.get("name"));

		jedis.mset("msetname","liuling","age","23","qq","476777XXX");
		jedis.incr("age"); //进行加1操作
		System.out.println(jedis.get("msetname") + "-" + jedis.get("age") + "-" + jedis.get("qq"));
	}

	public void testList(){
		System.out.println("==================list lrange ====================");
		 //存储数据到列表中
        jedis.lpush("site-list", "Runoob");
        jedis.lpush("site-list", "Google");
        jedis.lpush("site-list", "Taobao");
        // 获取存储的数据并输出
        List<String> list = jedis.lrange("site-list", 0 ,2);
        for(int i=0; i<list.size(); i++) {
            System.out.println("列表项为: "+list.get(i));
        }
	}

	public void testKeys(){
		 // 获取数据并输出
		System.out.println("==================keys *====================");
        Set<String> keys = jedis.keys("*");
        Iterator<String> it=keys.iterator() ;
        while(it.hasNext()){
            String key = it.next();
            System.out.println(key);
        }
	}


	public void testHash() {
		System.out.println("=============hash================");
        //-----添加数据----------
        Map<String, String> map = new HashMap<String, String>();
        map.put("name", "xinxin");
        map.put("age", "22");
        map.put("qq", "123456");
        jedis.hmset("user",map);
        System.out.println(jedis.type("user"));
        System.out.println(jedis.hget("user", "age"));


        //取出user中的name，执行结果:[minxr]-->注意结果是一个泛型的List
        //第一个参数是存入redis中map对象的key，后面跟的是放入map中的对象的key，后面的key可以跟多个，是可变参数
        List<String> rsmap = jedis.hmget("user", "name", "age", "qq");
        System.out.println(rsmap);

        //删除map中的某个键值
        jedis.hdel("user","age");
        System.out.println(jedis.hmget("user", "age")); //因为删除了，所以返回的是null
        System.out.println(jedis.hlen("user")); //返回key为user的键中存放的值的个数2
        System.out.println(jedis.exists("user"));//是否存在key为user的记录 返回true
        System.out.println(jedis.hkeys("user"));//返回map对象中的所有key
        System.out.println(jedis.hvals("user"));//返回map对象中的所有value

        Iterator<String> iter=jedis.hkeys("user").iterator();
        while (iter.hasNext()){
            String key = iter.next();
            System.out.println(key+":"+jedis.hmget("user",key));
        }
	}

	 public void testSet(){
        //添加
		 System.out.println("=============set================");
        jedis.sadd("user","liuling");
        jedis.sadd("user","xinxin");
        jedis.sadd("user","ling");
        jedis.sadd("user","zhangxinxin");
        jedis.sadd("user","who");
        //移除noname
        jedis.srem("user","who");
        System.out.println(jedis.smembers("user"));//获取所有加入的value
        System.out.println(jedis.sismember("user", "who"));//判断 who 是否是user集合的元素
        System.out.println(jedis.srandmember("user"));
        System.out.println(jedis.scard("user"));//返回集合的元素个数
    }

	public JedisPool getRedisPool(){
		 int MAX_ACTIVE = 1024;
		 int MAX_IDLE = 200;
		 long MAX_WAIT = 10000;
		 int TIMEOUT = 10000;
		 boolean TEST_ON_BORROW = true;
		 String ADDR = "127.0.0.1";
		 int PORT = 6379;
		 String AUTH = "";

		 JedisPoolConfig config = new JedisPoolConfig();
         config.setMaxActive(MAX_ACTIVE);
         config.setMaxIdle(MAX_IDLE);
         config.setMaxWait(MAX_WAIT);
         config.setTestOnBorrow(TEST_ON_BORROW);
         JedisPool jedisPool = new JedisPool(config, ADDR, PORT, TIMEOUT, AUTH);
         return jedisPool;
	}


	public static void main(String[] args){
		RedisClass rc = new RedisClass("127.0.0.1",6379,"");
		rc.testCmd();
		rc.testList();
		rc.testKeys();
		rc.testHash();
	}
}