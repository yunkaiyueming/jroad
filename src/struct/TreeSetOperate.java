package struct;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

//TreeSet是一个封装了一个HashSet的成员变量来实现的，底层运用了红黑树的数据结构

//类继承关系图:  TreeSet ==> AbstractSet ==> AbstractCollection ==> Collection ==> Iterable
//接口继承关系图： TreeSet ==> NavigableSet ==> SortedSet ==> Set ==> Collection ==> Iterable
public class TreeSetOperate {

    public static void main1(String[] args) {
        TreeSet<String> set = new TreeSet<String>();
        set.add("aaa");
        set.add("bbb");
        System.out.println(set);

        TreeSet<String> set2 = new TreeSet<String>();
        set.add("ccc");
        set.add("ddd");
        set.addAll(set2);
        System.out.println(set);

        Iterator itSet = set.iterator();
        while (itSet.hasNext())
            System.out.println(itSet.next() + "\n");
    }

    public static void main(String[] args) {
        Set<Teacher> treeSet = new TreeSet<Teacher>();
        Teacher a = new Teacher("aaa", 1);
        treeSet.add(new Teacher("zhangsan", 2));
        treeSet.add(new Teacher("lisi", 1));
        treeSet.add(new Teacher("wangwu", 3));
        treeSet.add(new Teacher("mazi", 3));

        System.out.println(treeSet);//直接输出

        Iterator itTSet = treeSet.iterator();//遍历输出
        while (itTSet.hasNext())
            System.out.print(itTSet.next() + "\t");
        System.out.println();
    }
}

//自定义数据类型，并在自定义的数据类型中实现CompareTo方法
class Teacher implements Comparable {
    int num;
    String name;

    Teacher(String name, int num) {
        this.num = num;
        this.name = name;
    }

    @Override
    public String toString() {
        return "学号:" + num + " 姓名:" + name;
    }

    @Override
    public int compareTo(Object o) {
        Teacher ss = (Teacher) o;
        int result = num > ss.num ? 1 : (num == ss.num ? 0 : -1);
        if (result == 0) {
            result = name.compareTo(ss.name);
        }
        return result;
    }
}
