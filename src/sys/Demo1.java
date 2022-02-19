package sys;

import java.util.Map;

public class Demo1 {
    public static void main(String[] args) {
        Runtime rt = Runtime.getRuntime();
        System.out.println(rt.availableProcessors());
        System.out.println(rt.freeMemory());
        System.out.println(rt.maxMemory() / 1024 / 1024 / 1024 + " G");
        System.out.println(rt.totalMemory() / 1024 / 1024 + " M");

        getSysInfo();
    }

    public static void getSysInfo() {
        System.out.println(System.currentTimeMillis());
        System.out.println(System.getProperties());

        System.out.println(System.getProperty("os.name"));
        System.out.println(System.getProperty("java.library.path"));
        System.gc();
        getEnvs();
    }

    public static void getEnvs() {
        System.out.println("===================");
        Map<String, String> ob = System.getenv();
        for (Map.Entry<String, String> entry : ob.entrySet()) {
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }
    }

}
