
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

/**
 * 在 Java 中遍历 HashMap 的5种最佳方法
 *
 * @author Ramesh Fadatare
 */
public class HashMapDemo {
    public static void main2(String[] args) {
        // 1. 使用 Iterator 遍历 HashMap EntrySet
        Map<Integer, String> coursesMap = new HashMap<Integer, String>();
        coursesMap.put(1, "C");
        coursesMap.put(2, "C++");
        coursesMap.put(3, "Java");
        coursesMap.put(4, "Spring Framework");
        coursesMap.put(5, "Hibernate ORM framework");
        System.out.println("Iterator:");

        Iterator<Entry<Integer, String>> iterator = coursesMap.entrySet().iterator();
        while (iterator.hasNext()) {
            Entry<Integer, String> entry = iterator.next();
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }
    }

    //试用Iterator遍历hashmap keyset
    public static void main3(String[] args) {
        Map<Integer, String> data = new HashMap<Integer, String>();
        data.put(1, "c");
        data.put(2, "c++");
        data.put(3, "java");
        data.put(4, "Spring frame");
        data.put(5, "Hibernate orm froms");

        System.out.println("Iterator keyset:");
        Iterator<Integer> iterator = data.keySet().iterator();
        while (iterator.hasNext()) {
            Integer k = iterator.next();
            System.out.println(k + ":" + data.get(k));
        }
    }

    //使用for-each遍历hashmap
    public static void main4(String[] args) {
        Map<Integer, String> data = new HashMap<Integer, String>();
        data.put(1, "c");
        data.put(2, "c++");
        data.put(3, "java");
        data.put(4, "Spring frame");
        data.put(5, "Hibernate orm froms");

        System.out.println("for-each");
        for (Map.Entry<Integer, String> entry : data.entrySet()) {
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }
    }

    public static void main5(String[] args) {
        Map<Integer, String> coursesMap = new HashMap<Integer, String>();
        coursesMap.put(1, "C");
        coursesMap.put(2, "C++");
        coursesMap.put(3, "Java");
        coursesMap.put(4, "Spring Framework");
        coursesMap.put(5, "Hibernate ORM framework");

        System.out.println("lambda foreach hashmap");
        // 4. 使用 Lambda 表达式遍历 HashMap
        coursesMap.forEach((key, value) -> {
            System.out.println(key + ":" + value);
        });
    }

    public static void main(String[] args) {
        Map<Integer, String> coursesMap = new HashMap<Integer, String>();
        coursesMap.put(1, "C");
        coursesMap.put(2, "C++");
        coursesMap.put(3, "Java");
        coursesMap.put(4, "Spring Framework");
        coursesMap.put(5, "Hibernate ORM framework");

        // 5. 使用 Stream API 遍历 HashMap
        System.out.println("Stream API 遍历 HashMap");
        coursesMap.entrySet().stream().forEach((entry) -> {
            System.out.println(entry.getKey() + ":" + entry.getValue());
        });
    }
}