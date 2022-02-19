package utils;

public class EqualDemo {

    public static void main(String[] args) {
        String s = "I AM an Object!";
        boolean isObject = s instanceof Object;
        System.out.println(isObject);

        if (s.getClass() == String.class) {
            System.out.println(true);
        }
    }
}

