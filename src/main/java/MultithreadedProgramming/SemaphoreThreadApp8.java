package MultithreadedProgramming;

import java.util.concurrent.Semaphore;

class CommonResource2 {
	int x = 0;
}

class CountThread2 implements Runnable {
	CommonResource2 res;
	Semaphore sem;
	String name;

	CountThread2(CommonResource2 res, Semaphore sem, String name) {
		this.res = res;
		this.sem = sem;
		this.name = name;
	}

	@Override
	public void run() {
		try {
			System.out.println(name + " ожидает разрешение");
			sem.acquire(); //Дает разрешение потоку
			res.x = 1;
			for (int i = 1; i < 5; i++) {
				System.out.println(this.name + ": " + res.x);
				res.x++;
				Thread.sleep(500);
			}
		} catch (InterruptedException e) {
			System.out.println(e.getMessage());
		}
		System.out.println(name + " освобождает разрешение");
		sem.release(); //Освобождает разрешение
	}
}

public class SemaphoreThreadApp8 {
	public static void main(String[] args) {
		Semaphore sem = new Semaphore(1);
		CommonResource2 res = new CommonResource2();
		new Thread(new CountThread2(res, sem, "CountThread 1")).start();
		new Thread(new CountThread2(res, sem, "CountThread 2")).start();
		new Thread(new CountThread2(res, sem, "CountThread 3")).start();
	}
}
