package struct;

import java.util.Hashtable;
import java.util.*;

//Hashtable 其实就是HashMap的一个线程安全版本，像Vector和ArrayList的关系一样，对内部的方法都加了synchronized关键字修饰。
//缺点：因为采用synchronized保证同步，每次都会锁住整个map，所以高并发线程在争夺同一把锁的时候性能急剧下降。

//类继承树关系：Hashtable ==> Dictionary
//接口继承关系：Hashtable ==> Map
public class HashTableOperate {

    public static void main(String args[]) {
        // Create a hash map
        Hashtable balance = new Hashtable();
        Enumeration names;
        String str;
        double bal;

        balance.put("Zara", new Double(3434.34));
        balance.put("Mahnaz", new Double(123.22));
        balance.put("Ayan", new Double(1378.00));
        balance.put("Daisy", new Double(99.22));
        balance.put("Qadir", new Double(-19.08));

        // Show all balances in hash table.
        names = balance.keys();
        while (names.hasMoreElements()) {
            str = (String) names.nextElement();
            System.out.println(str + ": " + balance.get(str));
        }

        System.out.println();
        // Deposit 1,000 into Zara's account
        bal = ((Double) balance.get("Zara")).doubleValue();
        balance.put("Zara", new Double(bal + 1000));
        System.out.println("Zara's new balance: " + balance.get("Zara"));
    }
}