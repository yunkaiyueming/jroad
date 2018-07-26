public class NumberClass{

	public void useNumer(){
		Integer x = 5;
		double t = java.lang.Math.abs(-2.36);
		System.out.println(t);
		System.out.println(Math.abs(-6.98));
	}

	public void useMath(){
		System.out.println(Math.PI);
		System.out.println(Math.sin(56.69));
		System.out.println(Math.sqrt(9));
		System.out.println(Math.ceil(5.96));
		System.out.println(Math.floor(5.96));
		System.out.println(Math.max(5.96,10));
		System.out.println(Math.min(5.96,10));
		System.out.println(Math.random());
		System.out.println(Math.round(2.6));
	}

	public void useString(){
		String name = "zhanghang";
		System.out.println(name);
		System.out.println("name.length()="+name.length());

		char[] key = {'i','t','s','o','o'};
		String keyStr = new String(key);
		System.out.println(keyStr);
	}

	public void formateString(){
		System.out.printf("%f,%d,%s",123.26,123,"helooworld");
		String name = "zhanghang";
		System.out.println(name.concat(" lisi "));
		System.out.println(name.hashCode());
		System.out.println(name.indexOf('g'));
		System.out.println(name.toUpperCase());

		//StringBuilder 的方法不是线程安全的, StringBuffer线程安全
		StringBuffer sBuffer = new StringBuffer("菜鸟教程官网：");
	    sBuffer.append("www");
	    sBuffer.append(".runoob");
	    sBuffer.append(".com");
	    System.out.println(sBuffer);  
	}

	public void getArray(){
		double[] myList = new double[10];
 		myList[0] = 5.6;
		myList[1] = 4.5;
		myList[2] = 3.3;
		myList[3] = 13.2;
		myList[4] = 4.0;
		myList[5] = 34.33;
		double total = 0;
	      for (int i = 0; i < 5; i++) {
	         System.out.println(i);
	      }	

	       // 打印所有数组元素
	      for (double element: myList) {
	         System.out.println(element);
	      }
	}

	public static void main(String[] args){
		System.out.println("start main......");

		NumberClass nc = new NumberClass();
		nc.useNumer();
		nc.useMath();
		nc.useString();
		nc.formateString();
		nc.getArray();
	}
}