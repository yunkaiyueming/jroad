package serialize;

import java.io.*;

class Man implements Serializable {
    private static final long serialVersionUID = 1L;

    private String username;
    private String password;

    public Man(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

public class SerialDemo2 {

    public static void main(String[] args) {
        SerialDemo2.writeSerializableObject();
        SerialDemo2.readSerializableObject();
        ;
    }

    // Serializable：把对象序列化
    public static void writeSerializableObject() {
        try {
            Man man = new Man("huhx", "123456");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("./output.txt"));
            objectOutputStream.writeObject("string");
            objectOutputStream.writeObject(man);
            objectOutputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //反序列化
    public static void readSerializableObject() {
        try {
            ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("./output.txt"));
            String string = (String) objectInputStream.readObject();
            Man person = (Man) objectInputStream.readObject();
            objectInputStream.close();
            System.out.println(string + ", pwd: " + person.getPassword() + ", man username: " + person.getUsername());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

