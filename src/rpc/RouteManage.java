package rpc;

import java.util.HashMap;
import java.util.Map;

public class RouteManage {

    static Map routeMap = new HashMap();

//    void initRoute(){
//        routeMap.put("hello",);
//        routeMap.put("user");
//    }

    void addRoute(String name, Service server){
        routeMap.put(name, server);
    }
}
