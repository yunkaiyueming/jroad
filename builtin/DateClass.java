
//package jroad.builtin;

import java.util.Calendar;
import java.util.Date;

public class DateClass{
	public void getDate(){
		Date d = new Date();
		System.out.println(d.getTime());
	}

	public void getDateAll(){
		/*** 输出日期类型***/
      // %t表示格式化日期时间类型，%T是时间日期的大写形式，在%t之后用特定的字母表示不同的输出格式
      Date date = new Date();
      long dataL = date.getTime();
      // 格式化年月日
      // %t之后用y表示输出日期的年份（2位数的年，如99）
      // %t之后用m表示输出日期的月份，%t之后用d表示输出日期的日号
      System.out.printf("%1$ty-%1$tm-%1$td; %2$ty-%2$tm-%2$td%n", date, dataL);
      // %t之后用Y表示输出日期的年份（4位数的年），
      // %t之后用B表示输出日期的月份的完整名， %t之后用b表示输出日期的月份的简称
      System.out.printf("%1$tY-%1$tB-%1$td; %2$tY-%2$tb-%2$td%n", date, dataL);
     
      // 以下是常见的日期组合
      // %t之后用D表示以 "%tm/%td/%ty"格式化日期
      System.out.printf("%1$tD%n", date);
      //%t之后用F表示以"%tY-%tm-%td"格式化日期
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


	public void getCander(){
		Calendar c1 = Calendar.getInstance();
		// 获得年份
		int year = c1.get(Calendar.YEAR);
		// 获得月份
		int month = c1.get(Calendar.MONTH) + 1;
		// 获得日期
		int date = c1.get(Calendar.DATE);
		// 获得小时
		int hour = c1.get(Calendar.HOUR_OF_DAY);
		// 获得分钟
		int minute = c1.get(Calendar.MINUTE);
		// 获得秒
		int second = c1.get(Calendar.SECOND);
		// 获得星期几（注意（这个与Date类是不同的）：1代表星期日、2代表星期1、3代表星期二，以此类推）
		int day = c1.get(Calendar.DAY_OF_WEEK);
	}

	public static void main(String[] args){
		DateClass dc = new DateClass();
		dc.getDate();
	}

}