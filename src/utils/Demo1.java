package utils;

import java.util.Base64;

public class Demo1 {
    public static void main(String[] args) {
        String st = Base64.getEncoder().encodeToString("abcdefg".getBytes());
        System.out.println(st);
        System.out.println(new String(Base64.getDecoder().decode(st)));
    }
}
