package datetime;

import java.util.Calendar;
import java.util.Date;

public class Demo1 {
	
	public static void main(String[] args){
		Calendar c1 = Calendar.getInstance();
		System.out.println(Calendar.ALL_STYLES);
		System.out.println(Calendar.DATE);
		System.out.println(Calendar.PM);
		
		System.out.println(c1.get(1));
		
		getDateAll();
	}
	
	public static void getDateAll(){
      Date date = new Date();
      long dataL = date.getTime();
      System.out.printf("%1$ty-%1$tm-%1$td; %2$ty-%2$tm-%2$td%n", date, dataL);
      System.out.printf("%1$tY-%1$tB-%1$td; %2$tY-%2$tb-%2$td%n", date, dataL);
     
      System.out.printf("%1$tD%n", date);
      System.out.printf("%1$tF%n", date);
     
      /*** 输出时间类型***/
      // 输出时分秒
      // %t之后用H表示输出时间的时（24进制），%t之后用I表示输出时间的时（12进制），
      // %t之后用M表示输出时间的分，%t之后用S表示输出时间的秒
      System.out.printf("%1$tH:%1$tM:%1$tS; %2$tI:%2$tM:%2$tS%n", date, dataL);
      // %t之后用L表示输出时间的秒中的毫秒
      System.out.printf("%1$tH:%1$tM:%1$tS %1$tL%n", date);
      // %t之后p表示输出时间的上午或下午信息
      System.out.printf("%1$tH:%1$tM:%1$tS %1$tL %1$tp%n", date);
     
      // 以下是常见的时间组合
      // %t之后用R表示以"%tH:%tM"格式化时间
      System.out.printf("%1$tR%n", date);
      // %t之后用T表示以"%tH:%tM:%tS"格式化时间
      System.out.printf("%1$tT%n", date);
      // %t之后用r表示以"%tI:%tM:%tS %Tp"格式化时间
      System.out.printf("%1$tr%n", date);
     
      /*** 输出星期***/
      // %t之后用A表示得到星期几的全称
      System.out.printf("%1$tF %1$tA%n", date);
      // %t之后用a表示得到星期几的简称
      System.out.printf("%1$tF %1$ta%n", date);
     
      // 输出时间日期的完整信息
      System.out.printf("%1$tc%n", date);
	}
}
