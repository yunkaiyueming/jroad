package serialize;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class SimpleSerial {
	
	
	public static void serialize() throws FileNotFoundException, IOException{
		Person p = new Person();
		p.age = 123;
		p.name=  "zs";
		p.sex="man";
	    File file = new File("./Person.txt");
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(file));
        out.writeObject(p);
        System.out.println("Person对象序列化成功！");
        out.close();
	}
	
	public static Person unserialize() throws FileNotFoundException, IOException, ClassNotFoundException{
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream(new File("./Person.txt")));
		Person p = (Person) ois.readObject();
        System.out.println("Person对象反序列化成功！");
        return p;
	}
	
	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException{
		SimpleSerial.serialize();
		Person p = SimpleSerial.unserialize();
		System.out.println(p);
		System.out.println(p.toString());
	}
}

//只有实现了Serializable和Externalizable接口的类的对象才能被序列化。
//Externalizable接口继承自 Serializable接口，
//实现Externalizable接口的类完全由自身来控制序列化的行为，而仅实现Serializable接口的类可以 采用默认的序列化方式 。
class Person implements Serializable {

    private static final long serialVersionUID = -5809782578272943999L;
    public int age;
    public String name;
    public String sex;
    
    public Person(){
    	
    }
    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public String getSex() {
        return sex;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
    
    public String toString(){
    	return "[" + this.name + ", " + this.age + ", " + this.sex + "]";
    }
}