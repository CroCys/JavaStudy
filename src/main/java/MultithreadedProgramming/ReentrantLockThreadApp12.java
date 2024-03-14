package MultithreadedProgramming;

import java.util.concurrent.locks.ReentrantLock;

class CommonResource3 {
	int x = 0;
}

class CountThread3 implements Runnable {
	CommonResource3 res;
	ReentrantLock locker;

	CountThread3(CommonResource3 res, ReentrantLock lock) {
		this.res = res;
		locker = lock;
	}

	@Override
	public void run() {
		locker.lock();
		try {
			res.x = 1;
			for (int i = 1; i < 5; i++) {
				System.out.printf("%s %d \n", Thread.currentThread().getName(), res.x);
				res.x++;
				Thread.sleep(100);
			}
		} catch (InterruptedException ex) {
			System.out.println(ex.getMessage());
		} finally {
			//Unlock обязательно в блоке finally в случае ошибки остальные потоки будут заблокированными
			locker.unlock();
		}
	}
}

public class ReentrantLockThreadApp12 {
	public static void main(String[] args) {
		CommonResource3 commonResource3 = new CommonResource3();
		ReentrantLock locker = new ReentrantLock();
		for (int i = 1; i < 6; i++) {
			Thread t = new Thread(new CountThread3(commonResource3, locker));
			t.setName("Thread " + i);
			t.start();
		}
	}
}
