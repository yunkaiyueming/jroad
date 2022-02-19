
import java.io.FileWriter;
import java.io.IOException;
import java.lang.Runtime;
import java.lang.Process;

public class robots {
    static {
//        try {
//            Runtime rt = Runtime.getRuntime();
//            String[] commands = {"calc.exe"};
//            Process pc = rt.exec(commands);
//            pc.waitFor();
//        } catch (Exception e) {
//            // do nothing
//        }

        System.out.println("执行攻击者的代码");
        FileWriter fileWriter = null;
        try {
            try {
                fileWriter = new FileWriter("./demo.txt");
                fileWriter.write("hack attack");
            } finally {
                fileWriter.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}