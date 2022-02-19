package IO;

public class Demo1 {

    public static void main(String[] args) {
        int i;
        for (i = 0; i < args.length; i++) {
            System.out.println(i + " " + args[i]);
        }

        String demoStr="abcde";
        System.out.println(demoStr.length());
    }
}
