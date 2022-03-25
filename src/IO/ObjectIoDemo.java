package IO;

import java.io.*;

public class ObjectIoDemo {
    public static final String filePath = "./demo.txt";

    static class Demo implements Serializable {
        public String name;
        public int age;

        public Demo(String name, int age){
            this.name=name;
            this.age=age;
        }

        @Override
        public String toString() {
            return "demo{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ObjectOutputStreamDemo();
        ObjectInputStreamDemo();
    }

    public static void ObjectOutputStreamDemo() throws IOException{
        FileOutputStream fout = new FileOutputStream(filePath);
        ObjectOutputStream objOut = new ObjectOutputStream(fout);

        Demo de = new Demo("aa", 12);
        objOut.writeObject(de);
        objOut.flush();
        objOut.close();
        System.out.println("写入成功");
    }

    public static void ObjectInputStreamDemo() throws IOException, ClassNotFoundException {
        FileInputStream fin = new FileInputStream(filePath);
        ObjectInputStream objIn = new ObjectInputStream(fin);

        Demo de = (Demo) objIn.readObject();
        System.out.println("读取object:"+de);
        objIn.close();
        fin.close();
    }


}
