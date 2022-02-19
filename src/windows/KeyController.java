package windows;

import java.awt.AWTException;
import java.awt.Dimension;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

public class KeyController implements Runnable {
    private Dimension dim;
    private Robot robot;
    private volatile boolean stop = false;

    public KeyController() {
        dim = Toolkit.getDefaultToolkit().getScreenSize();
        System.out.println("computer imformation:\n" + "width:" + dim.width + "\theight:" + dim.height);
        try {
            robot = new Robot();
        } catch (AWTException ex) {
            ex.printStackTrace();
        }
    }

    public void run() {
        while (!stop) {
            robot.mousePress(InputEvent.BUTTON1_MASK);
            robot.keyPress(13);
            robot.mouseMove(1, 2);
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public synchronized void stop() {
        stop = true;
    }

    public static void main(String[] args) {
        KeyController kc = new KeyController();
        Thread kcThread = new Thread(kc);
        System.out.println("Key Controller start");
        kcThread.start();
        try {
            Thread.sleep(6000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        kc.stop();
        System.out.println("Mouse Controller stoped");
    }
}