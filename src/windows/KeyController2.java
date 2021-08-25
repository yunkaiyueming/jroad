package windows;

import org.apache.commons.pool2.KeyedObjectPool;

import java.awt.AWTException;
import java.awt.Dimension;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

public class KeyController2 {
    private Dimension dim;
    private Robot robot;
    private volatile boolean stop = false;

    public void doSomeThing() {
        //dim = Toolkit.getDefaultToolkit().getScreenSize();
        //System.out.println("computer imformation:\n" + "width:"+dim.width+"\theight:"+dim.height);

        try {
            robot = new Robot();
        } catch (AWTException ex) {
            ex.printStackTrace();
        }

        robot.setAutoWaitForIdle(true);

        robot.mouseMove(500,500);
        robot.mousePress(KeyEvent.BUTTON1_DOWN_MASK);
        robot.mouseRelease(KeyEvent.BUTTON1_DOWN_MASK);

        robot.delay(100);

        robot.mousePress(KeyEvent.BUTTON3_DOWN_MASK);
        robot.mouseRelease(KeyEvent.BUTTON3_DOWN_MASK);

        robot.keyPress(KeyEvent.VK_1);
        robot.keyRelease(KeyEvent.VK_1);

        robot.keyPress(KeyEvent.VK_2);
        robot.keyRelease(KeyEvent.VK_2);

        robot.keyPress(KeyEvent.VK_3);
        robot.keyRelease(KeyEvent.VK_3);

//        for(int i=0;i<100;i++){
//            pressKey(robot, (int) (Math.random()* 25) + 'A');
//            pressKey(robot,KeyEvent.VK_SPACE);
//        }

//        robot.mouseWheel();
        int rgbV = robot.getPixelColor(1,2).getRGB();
        System.out.println(rgbV);

        //robot.mouseMove(400,400);

        // 打出一个大写的Q
//        robot.keyPress(KeyEvent.VK_SHIFT);	// 模拟键盘按下shift键
//        robot.keyPress(KeyEvent.VK_Q);		// 模拟键盘按下Q键（小写）
//        robot.keyRelease(KeyEvent.VK_Q);		// 模拟键盘释放Q键
//        robot.keyRelease(KeyEvent.VK_SHIFT);	// 模拟键盘释放shift键
//        robot.keyRelease(KeyEvent.VK_1);

    }


    public static void main(String[] args) {
        KeyController2 kc = new KeyController2();
        kc.doSomeThing();
        System.out.println("over.....");
    }
}