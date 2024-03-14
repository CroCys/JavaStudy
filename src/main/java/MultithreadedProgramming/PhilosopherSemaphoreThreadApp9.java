package MultithreadedProgramming;

import java.util.concurrent.Semaphore;

class Philosopher implements Runnable {
	Semaphore sem;
	int num = 0;
	int id;

	Philosopher(Semaphore sem, int id) {
		this.sem = sem;
		this.id = id;
	}

	@Override
	public void run() {
		try {
			while (num < 3) {
				sem.acquire();
				System.out.println("Философ " + id + " садится за стол");
				Thread.sleep(500);
				num++;
				System.out.println("Философ " + id + " выходит из за стола");
				sem.release();
				Thread.sleep(500);
			}
		} catch (InterruptedException e) {
			System.out.println("У философа " + id + " проблемы со здоровьем");
		}
	}
}

public class PhilosopherSemaphoreThreadApp9 {
	public static void main(String[] args) {
		Semaphore sem = new Semaphore(2);
		for (int i = 1; i < 6; i++) {
			new Thread(new Philosopher(sem, i)).start();
		}
	}
}
