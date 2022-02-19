package struct;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;

//HashSet 基于HashMap实现，利用Map的key不能重复来实现Set的元素唯一性

//类继承关系： HashSet ==> AbstractSet ==> AbstractSet ==> AbstractCollection ==> Collection ==> Iterable
//接口继承关系：HashSet ==> Set ==> Collection ==> Iterable
public class HashSetOperate {
    public static void main(String[] args) {
        HashSet<String> sites = new HashSet<String>();
        sites.add("Google");
        sites.add("Runoob");
        sites.add("Taobao");
        sites.add("Zhihu");
        sites.add("Runoob");  // 重复的元素不会被添加
        System.out.println(sites);
    }

    public static void main2(String[] args) {
        HashSet<String> sites = new HashSet<String>();
        sites.add("Google");
        sites.add("Runoob");
        sites.add("Taobao");
        sites.add("Zhihu");
        sites.add("Runoob");  // 重复的元素不会被添加
        System.out.println(sites.contains("Taobao"));
    }

    public static void main3(String[] args) {
        HashSet<String> sites = new HashSet<String>();
        sites.add("Google");
        sites.add("Runoob");
        sites.add("Taobao");
        sites.add("Zhihu");
        sites.add("Runoob");     // 重复的元素不会被添加
        sites.remove("Taobao");  // 删除元素，删除成功返回 true，否则为 false
        System.out.println(sites);
    }

    public static void main4(String[] args) {
        HashSet<String> sites = new HashSet<String>();
        sites.add("Google");
        sites.add("Runoob");
        sites.add("Taobao");
        sites.add("Zhihu");
        sites.add("Runoob");     // 重复的元素不会被添加
        sites.clear();
        System.out.println(sites);
    }

    public static void main5(String[] args) {
        HashSet<String> sites = new HashSet<String>();
        sites.add("Google");
        sites.add("Runoob");
        sites.add("Taobao");
        sites.add("Zhihu");
        sites.add("Runoob");     // 重复的元素不会被添加
        System.out.println(sites.size());
    }

    public static void main6(String[] args) {
        HashSet<String> sites = new HashSet<String>();
        sites.add("Google");
        sites.add("Runoob");
        sites.add("Taobao");
        sites.add("Zhihu");
        sites.add("Runoob");     // 重复的元素不会被添加
        for (String i : sites) {
            System.out.println(i);
        }
    }

    public static void main7(String[] args) {
        Collection books = new HashSet();
        books.add("A书");
        books.add("B书");
        books.add("C书");
        // 获取books集合对应的迭代器
        Iterator it = books.iterator();
        while (it.hasNext()) {
            // it.next()返回的是一个对象类型，需要强制转换
            String book = (String) it.next();
            System.out.println(book);
            if (book.equals("B书")) {
                // 从集合中删除上一次next方法返回的元素
                it.remove();
            }
            // book变量赋值，不会改变集合元素本身
            book = "C书";
        }
        System.out.println(books);


        for (Object obj : books) {
            String book = (String) obj;
            System.out.println(book);
            if (book.equals("B书")) {
                books.remove(book);
            }
        }
        System.out.println(books);
    }



}