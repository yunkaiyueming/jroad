package math;

import java.math.BigDecimal;


public class Demo1 {
	
	public static void main(String[] args){
		System.out.println(BigDecimal.TEN);
		
		System.out.println(java.lang.Math.PI);
		System.out.println(java.lang.Math.abs(-232.232));
		System.out.println(java.lang.Math.ceil(12.25));//进一法
		System.out.println(java.lang.Math.floor(12.25));//去一法
		System.out.println(java.lang.Math.max(96, 2342.6));
		System.out.println(java.lang.Math.min(89.63, 7893));
		System.out.println(java.lang.Math.round(89.63));//四舍五入
		
		System.out.println(java.lang.Long.bitCount(1));
		System.out.println(Math.pow(3,2));
	}
}
