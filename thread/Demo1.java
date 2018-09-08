package thread;

//通过实现 Runnable 接口；

public class Demo1 implements Runnable {
	private Thread t;
	private String threadName;

	public Demo1(String name) {
		threadName = name;
		System.out.println("Creating " + threadName);
	}

	public void run() {
		try {
			for (int i = 4; i > 0; i--) {
				System.out.println("Run Thread: " + threadName + ", " + i);
				// 让线程睡眠一会
				Thread.sleep(50);
			}
		} catch (InterruptedException e) {
			System.out.println("Thread " + threadName + " interrupted.");
		}
		System.out.println("Thread " + threadName + " exiting.");
	}

	public void start() {
		System.out.println("Starting " + threadName);
		if (t == null) {
			t = new Thread(this, threadName);
			System.out.println("Starting1 " + threadName);
			t.start();
		}
		System.out.println("Starting2 " + threadName);
	}

	public static void main(String args[]) {
		Demo1 R1 = new Demo1("Thread1");
		R1.start();

		Demo1 R2 = new Demo1("Thread2");
		R2.start();
	}
}
