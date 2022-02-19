package struct;

import java.util.LinkedList;

//基于链表的集合
//基于链表的集合，是一个双向链表，没有初始化大小，也没有扩容的机制，会一直在前面或者后面新增Node。
//        优点：便于存取，只要改变头尾节点指向 (O(1))。缺点：索引慢，极端情况会出现从头结点遍历到最后一个节点的情况 (O(n))。
//        单向链表：每个节点只会指向下一个节点

//类关系继承图： LinkedList ==> AbstractSequentialList ==> AbstractList ==> AbstractCollection ==> Collection ==> Iterable
//接口继承图： LinkedList ==> List ==> Collection ==> Iterable

public class LinkedListOperate {
    public static void main(String[] args) {
        LinkedList<String> sites = new LinkedList<String>();
        sites.add("Google");
        sites.add("Runoob");
        sites.add("Taobao");
        sites.add("Weibo");
        System.out.println(sites);

        sites.addFirst("Wiki");//
        System.out.println(sites);

        sites.addLast("lastone");
        System.out.println(sites);

        // 使用 getFirst() 获取头部元素
        System.out.println(sites.getFirst());

        // 使用 getFirst() 获取头部元素
        System.out.println(sites.getLast());

        // 使用 removeFirst() 移除头部元素
        sites.removeLast();
        sites.removeFirst();
        System.out.println(sites);

        //使用for配合size来迭代
        for (int size = sites.size(), i = 0; i < size; i++) {
            System.out.println(sites.get(i));
        }

        //使用for-each来迭代
        for (String i : sites) {
            System.out.println(i);
        }
    }


}