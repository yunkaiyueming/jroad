package struct;

//LinkedHashSet 基于LinkedHashMap实现，继承自HashSet，可以看出是一个有序的Set（可以像LinkedHashMap自定义排序）

import java.util.*;

//类关系继承图：LinkedHashSet ==> HashSet ==> AbstractSet ==> AbstractCollection ==> Collection ==> Iterable
//接口关系继承图： LinkedHashSet ==> Set ==> Collection ==> Iterable
class LinkedHashSetOperate{
    public static void main(String args[]){
        LinkedHashSet<String> animals=new LinkedHashSet();
        animals.add("Elephant");
        animals.add("Tiger");
        animals.add("Lion");

        Iterator<String> iterator=animals.iterator();
        while(iterator.hasNext())  {
            System.out.println(iterator.next());
        }

        LinkedHashSet<String> linkedHashSet = new LinkedHashSet<String>();
        for (int i = 0; i < linkedHashSet.size(); i++) {
            //System.out.println(linkedHashSet.get(i));
        }

        for (String temp : linkedHashSet) {
            System.out.println(temp);
        }

        int i = 0;
        while (i < linkedHashSet.size()) {
            //System.out.println(linkedHashSet.get(i));
            i++;
        }
    }
}