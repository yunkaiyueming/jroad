package thread;

public class Demo2 extends Thread {
	private Thread t;
	private String threadName;

	Demo2(String name) {
		threadName = name;
		System.out.println("Creating " + threadName);
	}

	public void run() {
		try {
			for (int i = 4; i > 0; i--) {
				System.out.println("Running Thread: " + threadName + ", " + i);
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
			t.start();
		}
	}

	public static void main(String args[]) {
		Demo2 T1 = new Demo2("Thread1");
		T1.start(); //异步

		Demo2 T2 = new Demo2("Thread2");
		T2.start();
		
		System.out.println("end over");
	
	}
}
