package rpc;

public class HelloServiceImpl implements HelloService {

    public String hello(String name) {
        return "hello_hello" + name;
    }

}