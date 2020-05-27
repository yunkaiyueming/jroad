package serialize;

import org.json.JSONObject;

public class JsonClass {
	
	public static void main(String[] args){
		JsonClass.encode();
		JsonClass.decode();
	}
	
	public static void encode(){
		//对象
		JSONObject js  = new JSONObject();
		js.put("name", "zhangsan");
		js.put("sex", "female");
		js.put("buyinfo",  new JSONArray("['橘子','苹果']")); //多层
		js.put("cityinfo",  new JSONObject("{'title':'zs','tw':'11'}")); //多层
	    System.out.println(js);    //输出为：{"sex":"female","name":"zhangsan"}
	    
	    //数组
	    JSONArray jsArr = new JSONArray();
	    jsArr.put("11");
	    jsArr.put("22");
	    jsArr.put("33");
	    jsArr.put(new JSONArray("['你好','xyz']")); //多层嵌套
	    System.out.println(jsArr.toString());    //输出为：["11","22","33"]
	}
	
	public static void decode(){
		JSONObject js = new JSONObject("{'Name':'Tom','age':'11','goods':[1,2]}");
		System.out.println(js);

		JSONArray jsArr = new JSONArray("['abc','xyz']");
		System.out.println(jsArr.toString());
		System.out.println(jsArr);
		System.out.print(jsArr.get(0));
		System.out.print(jsArr.get(1));
		
		Frites fi = new Frites();
		fi.Name = js.getString("Name");
		fi.Age = js.getString("age");
		System.out.print("===>"+fi.Name+fi.Age);
	}
	
}

class Frites{
	String Name;
	String Age;
}