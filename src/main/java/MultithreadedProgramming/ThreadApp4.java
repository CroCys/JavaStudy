package MultithreadedProgramming;

class MyThread2 implements Runnable {
	//Завершение потока
	private boolean isActive;

	void disable() {
		isActive = false;
	}

	void MyThread() {
		isActive = true;
	}

	@Override
	public void run() {
		System.out.printf("%s started... \n", Thread.currentThread().getName());
		int counter = 1;
		while (isActive) {
			System.out.println("Loop" + counter++);
		}
		try {
			Thread.sleep(400);
		} catch (InterruptedException e) {
			System.out.println("Thread has been interrupted");
		}
		System.out.printf("%s finished... \n", Thread.currentThread().getName());
	}
}

public class ThreadApp4 {
	public static void main(String[] args) {
		System.out.println("Main thread started...");
		MyThread2 myThread = new MyThread2();
		new Thread(myThread, "MyThread").start();

		try {
			Thread.sleep(1100);

			myThread.disable();

			Thread.sleep(1000);
		} catch (InterruptedException e) {
			System.out.println("Thread has been interrupted");
		}
		System.out.println("Main thread finished...");
	}
}
