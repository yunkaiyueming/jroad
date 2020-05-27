package reflect;

import java.lang.reflect.Array;

public class Demo2{
	
	public static void main(String[] args){
		Demo2.testArrayClass();
	}
	
	
	/**
     * 利用反射操作数组
     * 1 利用反射修改数组中的元素
     * 2 利用反射获取数组中的每个元素
     */
    public static void testArrayClass() {
        String[] strArray = new String[]{"5","7","暑期","美女","女生","女神"};
        Array.set(strArray,0,"帅哥");
        Class clazz = strArray.getClass();
        if (clazz.isArray()) {
            int length = Array.getLength(strArray);
            for (int i = 0; i < length; i++) {
                Object object = Array.get(strArray, i);
                String className=object.getClass().getName();
                System.out.println("----> object=" + object+",className="+className);
            }
        }
    }
}
