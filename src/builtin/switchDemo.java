package builtin;

public class switchDemo {
    public static void main(String[] args) {
        String str = "world";

        switch (str) {
            case "hello":
                System.out.println("hello");
                break;
            case "world":
                System.out.println("world");
                break;
            default:
                break;
        }

        final int OKFLAG = 12;
        switch (OKFLAG) {
            case 12:
                System.out.println("12 success");
                break;

            case 13:
                System.out.println("13 success");
                break;

            default:
                System.out.println("unknow...");
                break;
        }
    }
}