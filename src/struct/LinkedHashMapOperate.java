package struct;


// LinkedHashMap是Map接口的哈希表和链接列表实现，具有可预知的迭代顺序。此实现提供所有可选的映射操作，并允许使用null值和null键。
// 此类不保证映射的顺序，特别是它不保证该顺序恒久不变， LinkedHashMap实现与HashMap的不同之处在于，后者维护着一个运行于所有条目的双重链接列表。
// 此链接列表定义了迭代顺序，该迭代顺序可以是插入顺序或者是访问顺序。根据链表中元素的顺序可以分为：按插入顺序的链表，和按访问顺序(调用get方法)的链表。
// 默认是按插入顺序排序，如果指定按访问顺序排序，那么调用get方法后，会将这次访问的元素移至链表尾部，不断访问可以形成按访问顺序排序的链表。
// 可以重写removeEldestEntry方法返回true值指定插入元素时移除最老的元素

//通过维护一个运行于所有条目的双向链表，LinkedHashMap保证了元素迭代的顺序。

//类继承关系树：LinkedHashMap ==> HashMap ==> AbstractMap ==> Map
//接口继承关系图: LinkedHashMap ==> Map

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

public class LinkedHashMapOperate {

    public static void main1(String[] args){
        int initialCapacity = 10;//初始化容量
        float loadFactor = 0.75f;//加载因子，一般是 0.75f
        boolean accessOrder = true;//排序方式 false 基于插入顺序  true  基于访问顺序
        Map<String, Integer> map = new LinkedHashMap<>(initialCapacity, loadFactor, accessOrder);

        for (int i = 0; i < 10; i++) {
            map.put(String.valueOf(i), i);
        }
        //访问前顺序
        for (Iterator<Map.Entry<String, Integer>> it = map.entrySet().iterator(); it.hasNext(); ) {
            Map.Entry<String, Integer> next = it.next();
            System.out.println("linkedMap--before-->" + next.getKey());
        }

        //模拟访问
        map.get("5");

        //访问后数据
        for (Iterator<Map.Entry<String, Integer>> it = map.entrySet().iterator(); it.hasNext(); ) {
            Map.Entry<String, Integer> next = it.next();
            System.out.println("linkedMap--after-->" + next.getKey());
        }
    }

    public static void main(String[] args){
        final int initialCapacity = 10;//初始化容量
        float loadFactor = 0.75f;//加载因子，一般是 0.75f
        boolean accessOrder = true;//排序方式 false 基于插入顺序  true  基于访问顺序
        //Map<String, Integer> map = new LinkedHashMap<>(initialCapacity, loadFactor, accessOrder);

        Map<String, Integer> map = new LinkedHashMap(initialCapacity, loadFactor, accessOrder)
        {
            @Override
            protected boolean removeEldestEntry(Entry eldest) {
                return size() > initialCapacity;
            }
        };

        for (int i = 0; i < 15; i++) {
            map.put(String.valueOf(i), i);
        }
        //访问前顺序
        for (Iterator<Map.Entry<String, Integer>> it = map.entrySet().iterator(); it.hasNext(); ) {
            Map.Entry<String, Integer> next = it.next();
            System.out.println("linkedMap--before-->" + next.getKey());
        }
    }
}

//LRU即Least Recently Used，最近最少使用 也就是说，当缓存满了，会优先淘汰那些最近最不常访问的数据
class LRUCache extends LinkedHashMap
{
    public LRUCache(int maxSize)
    {
        super(maxSize, 0.75F, true);
        maxElements = maxSize;
    }

    @Override
    protected boolean removeEldestEntry(java.util.Map.Entry eldest)
    {
        return size() > maxElements;
    }

    private static final long serialVersionUID = 1L;
    protected int maxElements;
}