package other;

public class MyExceptionDemo extends Exception {

    //无参构造方法
    public MyExceptionDemo() {
        super();
    }

    //有参的构造方法
    public MyExceptionDemo(String message) {
        super(message);
    }

    // 用指定的详细信息和原因构造一个新的异常
    public MyExceptionDemo(String message, Throwable cause) {
        super(message, cause);
    }

    //用指定原因构造一个新的异常
    public MyExceptionDemo(Throwable cause) {
        super(cause);
    }

}
