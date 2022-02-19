package rpc;

public class UserServiceImpl implements UserService {
    public String hello(String name) {
        return "user hello" + name;
    }

}
