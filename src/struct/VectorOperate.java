package struct;

//Vector 类实现了一个动态数组。和 ArrayList 很相似，但是两者是不同的：
//
//Vector 是同步访问的。
//Vector 包含了许多传统的方法，这些方法不属于集合框架。Vector 主要用在事先不知道数组的大小，或者只是需要一个可以改变大小的数组的情况


import java.util.*;

//类关系图： Vector ==> AbstractList ==> AbstractCollection ==> Collection ==> Iterable
//接口继承关系图：Vector ==> List ==> Collection ==> Iterable

public class VectorOperate {

    public static void main(String args[]) {
        // initial size is 3, increment is 2
        Vector v = new Vector(3, 2);
        System.out.println("Initial size: " + v.size());
        System.out.println("Initial capacity: " + v.capacity());
        v.addElement(new Integer(1));
        v.addElement(new Integer(2));
        v.addElement(new Integer(3));
        v.addElement(new Integer(4));
        System.out.println("Capacity after four additions: " + v.capacity());

        v.addElement(new Double(5.45));
        System.out.println("Current capacity: " + v.capacity());
        v.addElement(new Double(6.08));
        v.addElement(new Integer(7));
        System.out.println("Current capacity: " + v.capacity());
        v.addElement(new Float(9.4));
        v.addElement(new Integer(10));
        System.out.println("Current capacity: " + v.capacity());
        v.addElement(new Integer(11));
        v.addElement(new Integer(12));
        System.out.println("First element: " +(Integer) v.firstElement());
        System.out.println("Last element: " +(Integer) v.lastElement());

        if (v.contains(new Integer(3)))
            System.out.println("Vector contains 3.");

        // enumerate the elements in the vector.
        Enumeration vEnum = v.elements();
        System.out.println("\nElements in vector:");

        while (vEnum.hasMoreElements())
            System.out.println(vEnum.nextElement() + " ");

        v.addElement("asbd");
        v.addElement(new String("cde"));
        System.out.println(v);

        v.setElementAt("000",0);
        System.out.println(v);//修改原来的值
    }
}