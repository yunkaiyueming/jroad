package rpc;

//import rpc.RpcFramework;

/**
 * RpcConsumer
 *
 * @author william.liangf
 */
public class RpcConsumer {

    public static void main(String[] args) throws Exception {
        HelloService service = RpcFramework.refer(HelloService.class, "127.0.0.1", 15001);
        for (int i = 0; i < 5; i ++) {
            String hello = service.hello("World" + i);
            System.out.println(hello);
        }

    }

}