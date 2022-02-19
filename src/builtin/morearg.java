package builtin;

public class morearg {
    public static void main(String[] args) {
        //System.out.println(args);
        print("Holis", "公众号:Hollis", "博客：www.hollischuang.com", "QQ：907607222");
    }

    public static void print(String... strs) {
        for (int i = 0; i < strs.length; i++) {
            System.out.println(strs[i]);
        }
    }
}

