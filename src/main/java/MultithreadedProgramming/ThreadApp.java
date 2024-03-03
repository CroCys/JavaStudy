package MultithreadedProgramming;

class JThread extends Thread {
	JThread(String name) {
		super(name);
	}

	public void run() {
		System.out.printf("%s started... \n", Thread.currentThread().getName());
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			System.out.println("Thread has been interrupted");
		}
		System.out.printf("%s finished... \n", Thread.currentThread().getName());
	}
}

public class ThreadApp {
	public static void main(String[] args) {
		//Поток main завершается до дочерних
		System.out.println("Main thread started...");
		new JThread("JThread").start();
		System.out.println("Main thread finished");
		for (int i = 1; i < 6; i++) {
			new JThread("JThread" + i).start();
		}
	}
}