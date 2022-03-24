package builtin;

import java.util.*;

public class HelloTest {
    int i=0;
    String s = "aa";
    String[] ss = {"1","2","3"};
//    float t = f2.5;
    double j = 2.39;
//    const String PK="jisss";
    Boolean flag=true;
    char c = 'x';
    byte b = 1;


    public static void main(String[] args) {
        //testArrayList();
        //testHashMap();
        typeChange();
    }

    public static void testArrayList(){
//        List操作
        List<String> demo = new ArrayList<String>();
        demo.add("zhangsan");
        demo.add("lisi");
        demo.add("wangwu");

        demo.set(1,"wg");
        demo.get(1);

        for(int i=0;i<demo.size();i++){
            System.out.println(i+":"+demo.get(i));
        }

        demo.remove(1);//lisi
        demo.remove("zs");

        for(String v:demo){
            System.out.println(v);
        }

        if(!demo.contains("sjio")){
            System.out.println("sijo 不存在");
        }

        System.out.println(demo.isEmpty());
        System.out.println(demo.lastIndexOf("wangwu"));
    }

    public static void testHashMap(){
        Map<String,String> demo = new HashMap<String,String>();

        demo.put("name","zs");
        demo.put("age","10");
        demo.get("name");

        System.out.println(demo.size());

        //只返回v
        for(String v:demo.values()){
            System.out.println(v);
        }

        //返回kv
        for(String k:demo.keySet()){
            System.out.println(k+":"+demo.get(k));
        }
        demo.remove("age");

        for(Map.Entry<String, String> entry:demo.entrySet()){
            System.out.println(entry.getKey()+entry.getValue());
        }

//       demo.clear();
        //返回kv
        for(String k:demo.keySet()){
            System.out.println(k+":"+demo.get(k));
        }

    }

    public static void typeChange(){
        int i  = 10;
        String istr = String.valueOf(i);
        System.out.println(istr);
        System.out.println(istr instanceof String);

        String j = "10";
        Integer jint = Integer.parseInt(j);
        System.out.println(jint);
        System.out.println(jint instanceof Integer);
    }
}
