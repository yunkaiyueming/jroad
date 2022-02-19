package reflect2;

public class Client {

    //测试运行对象池
    public static void main(String[] args) {
        ObjectPool pool = ObjectPool.init("/Users/ray/Documents/Java/jroad/src/reflect2/config.json");
        User user = (User) pool.getObject("id1");
        System.out.println(user);


        Bean bean = (Bean) pool.getObject("id2");
        System.out.println(bean);
    }

}