package rpc;

//import rpc.RpcFramework;

/**
 * RpcProvider
 */
public class RpcProvider {

    public static void main(String[] args) throws Exception {
        HelloService service = new HelloServiceImpl();
        //RpcFramework.export(service, config.port);

        Config cf = new Config();
        RpcFramework.export(service, cf.port2);
    }

}