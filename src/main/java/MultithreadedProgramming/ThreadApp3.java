package MultithreadedProgramming;

class MyThread implements Runnable {
	//Реализация потока через интерфейс Runnable
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

public class ThreadApp3 {
	public static void main(String[] args) {
		System.out.println("Main thread started...");
		Thread myThread = new Thread(new MyThread(), "MyThread");
		myThread.start();
		System.out.println("Main thread finished...");

		//Лямбда
		System.out.println("Main thread started...");
		Runnable r = () -> {
			System.out.printf("%s started... \n", Thread.currentThread().getName());
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				System.out.println("Thread has been interrupted");
			}
			System.out.printf("%s finished... \n", Thread.currentThread().getName());
		};
		Thread myThread2 = new Thread(r, "MyThread");
		myThread2.start();
		System.out.println("Main thread finished...");
	}
}
