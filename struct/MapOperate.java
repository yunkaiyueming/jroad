package struct;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class MapOperate {

	public static void main(String[] args){
		MapOperate.allTest();
	}
	
	public static void allTest(){
		Map map = new HashMap();
		map.put("name", "zhangsan");
		map.put("age", 10);
		map.put("school", "junxiao");
		System.out.println(map.get("name"));
		
		Demo1(map);
		map.remove("name");

		System.out.println(map.isEmpty());
		System.out.println(map.size());
		
		System.out.println("========遍历方法==========");
		Demo1(map);
		Demo2(map);
		Demo3(map);
		Demo4(map);
		
		System.out.println("========清除后==========");
		map.clear();
		Demo2(map);
	}
	
	//获取所有key
	public static void Demo1(Map map){
		for(Object k : map.keySet()){
	          Object v = map.get(k);
	          System.out.println(k+":"+v);
	    }
	}
	
	//根据entrySet遍历：常用
	public static void Demo2(Map<Integer, Integer> map){
		for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
		    System.out.println(entry.getKey() + "：" + entry.getValue());
		}  
	}
	
	//获取所有values
	public static void Demo3(Map<String, Object> map){
		for (Object value : map.values()) {
		    System.out.println("v => " + value);
		}
	}
	
	//使用Iterator遍历
	public static void Demo4(Map<String, Object> map){
		//用泛型
		Iterator<Map.Entry<String, Object>> entries = map.entrySet().iterator();
		while (entries.hasNext()) {
		    Map.Entry<String, Object> entry = entries.next();
		    System.out.println(entry.getKey() +":"+entry.getValue());
		}
		
		//不是用泛型
		Iterator entries2 = map.entrySet().iterator();
		while (entries2.hasNext()) {
		    Map.Entry entry = (Map.Entry) entries2.next();
		    System.out.println(entry.getKey()+":" + entry.getValue());
		}
	}
}
