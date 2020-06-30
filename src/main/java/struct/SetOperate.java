package struct;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;

public class SetOperate {

	public static void main(String[] args) {
		Collection books = new HashSet();
		books.add("A书");
		books.add("B书");
		books.add("C书");
		// 获取books集合对应的迭代器
		Iterator it = books.iterator();
		while (it.hasNext()) {
			// it.next()返回的是一个对象类型，需要强制转换
			String book = (String) it.next();
			System.out.println(book);
			if (book.equals("B书")) {
				// 从集合中删除上一次next方法返回的元素
				it.remove();
			}
			// book变量赋值，不会改变集合元素本身
			book = "C书";
		}
		System.out.println(books);
		
		
		for(Object obj:books){
			String book=(String)obj;
			System.out.println(book);
			if(book.equals("B书")){
				books.remove(book);
			}
		}
		System.out.println(books);
	}

}
