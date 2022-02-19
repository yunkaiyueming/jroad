package struct;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

//Map 是一种把键对象和值对象映射的集合，它的每一个元素都包含一对键对象和值对象
//HashMap 底层是数组+链表(jdk1.8是数组+链表/红黑树)，HashMap可能也是应用最多的数据结构了。
//初始容量

//类的继承树： HashMap ==> AbstractMap ==> Map
//接口的实现： HashMap ==> Map

public class HashMapOperate {

    public static void main(String[] args) {
        // 创建 HashMap 对象 Sites
        HashMap<Integer, String> Sites = new HashMap<Integer, String>();
        // 添加键值对
        Sites.put(1, "Google");
        Sites.put(2, "Runoob");
        Sites.put(3, "Taobao");
        Sites.put(4, "Zhihu");
        System.out.println(Sites);

        HashMapOperate.PrintAllKv1(Sites);
    }

    public static void PrintAllKv1(HashMap<Integer, String> data) {
        for (Integer i : data.keySet()) {
            System.out.println("key: " + i + " value: " + data.get(i));
        }
    }

    public static void PrintAllKv(HashMap<String, String> data) {
        for (String i : data.keySet()) {
            System.out.println("key: " + i + " value: " + data.get(i));
        }
    }

    public static void main2(String[] args) {
        // 创建 HashMap 对象 Sites
        HashMap<String, String> Sites = new HashMap<String, String>();
        // 添加键值对
        Sites.put("one", "Google");
        Sites.put("two", "Runoob");
        Sites.put("three", "Taobao");
        Sites.put("four", "Zhihu");
        System.out.println(Sites.size());

        HashMapOperate.PrintAllKv(Sites);

        System.out.println(Sites.get("one"));

        Sites.clear();

        // 输出 key 和 value
        for (String i : Sites.keySet()) {
            System.out.println("key: " + i + " value: " + Sites.get(i));
        }
        // 返回所有 value 值
        for (String value : Sites.values()) {
            // 输出每一个value
            System.out.print(value + ", ");
        }
    }

    public static void main3(String[] args) {
        HashMapOperate.allTest();
    }

    public static void allTest() {
        Map map = new HashMap();
        map.put("name", "zhangsan");
        map.put("age", 10);
        map.put("school", "junxiao");
        System.out.println(map.get("name"));

        Demo1(map);
        map.remove("name");

        System.out.println(map.isEmpty());
        System.out.println(map.size());

        System.out.println("========遍历方法==========");
        Demo1(map);
        Demo2(map);
        Demo3(map);
        Demo4(map);

        System.out.println("========清除后==========");
        map.clear();
        Demo2(map);
    }

    //获取所有key
    public static void Demo1(Map map) {
        for (Object k : map.keySet()) {
            Object v = map.get(k);
            System.out.println(k + ":" + v);
        }
    }

    //根据entrySet遍历：常用
    public static void Demo2(Map<Integer, Integer> map) {
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey() + "：" + entry.getValue());
        }
    }

    //获取所有values
    public static void Demo3(Map<String, Object> map) {
        for (Object value : map.values()) {
            System.out.println("v => " + value);
        }
    }

    //使用Iterator遍历
    public static void Demo4(Map<String, Object> map) {
        //用泛型
        Iterator<Map.Entry<String, Object>> entries = map.entrySet().iterator();
        while (entries.hasNext()) {
            Map.Entry<String, Object> entry = entries.next();
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }

        //不是用泛型
        Iterator entries2 = map.entrySet().iterator();
        while (entries2.hasNext()) {
            Map.Entry entry = (Map.Entry) entries2.next();
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }
    }
}


