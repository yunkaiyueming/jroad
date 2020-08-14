package struct;

import com.google.common.collect.ImmutableList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ArrayDemo {

    public static void main1(String[] args){
        String[] arr1 = new String[10];//字符串数组
        arr1[0] = "aa";
        arr1[1] = "bb";
        for(int i=0;i<arr1.length;i++){
            System.out.println(i+":"+arr1[i]);
        }
        for(String v:arr1){ //for循环输出
            System.out.println(v);
        }

        int[] arr2 = new int[10];
        float[] arr3 = new float[10];

        int[] arr4;
        arr4 = new int[]{1,3,4,5};
    }

    public static void main(String... args) {
        String[] strs = {"Hollis", "公众号：Hollis", "博客：www.hollischuang.com"};
        for (String s : strs) {
            System.out.println(s);
        }
        List<String> strList = ImmutableList.of("Hollis", "公众号：Hollis", "博客：www.hollischuang.com");
        for (String s : strList) {
            System.out.println(s);
        }
    }

    public static void main2(String[] args){
        String[] strArray = new String[2];
        strArray[0] = "aa";
        strArray[1] = "bb";

        List list = Arrays.asList(strArray);//数组转list,不能对List增删，只能查改，否则抛异常。
        //对转换后的list插入一条数据
        list.add("1");
        System.out.println(list);
    }

    public static void main3(String[] args){
        String[] strArray = new String[2];
        ArrayList<String> list = new ArrayList<String>(Arrays.asList(strArray)) ;
        list.add("1");
        System.out.println(list);
    }

    public static void main4(String[] args){
        String[] strArray = new String[2];
        ArrayList< String> arrayList = new ArrayList<String>(strArray.length);
        Collections.addAll(arrayList, strArray);
        arrayList.add("1");
        System.out.println(arrayList);
    }
}
