package easywrong;

import java.util.ArrayList;
import java.util.List;

//集合循环过程中不能修改删除
public class Wrong2 {
    public static void main(String[] args)
    {
        List<Person> list = new ArrayList<Person>();
        Person p1 = new Person("张三", 23);
        Person p2 = new Person("李四", 26);
        Person p3 = new Person("王五", 34);
        Person p4 = new Person("刘二", 15);
        Person p5 = new Person("朱六", 40);

        list.add(p1);
        list.add(p2);
        list.add(p3);
        list.add(p4);
        list.add(p5);
        for(Person p : list) //Exception in thread "main" java.util.ConcurrentModificationException
        {
            if("王五".equals(p.getName()))
            {
                list.remove(p); // 不能在此时删除对象。
            }
            else if("李四".equals(p.getName()))
            {
                list.remove(p); // 不能在此时删除对象。
            }
        }
        System.out.println(list.size());
    }
}

class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}