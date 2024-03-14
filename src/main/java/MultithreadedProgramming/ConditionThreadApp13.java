package MultithreadedProgramming;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

class Store2 {
	private int product = 0;
	ReentrantLock locker;
	Condition condition;

	Store2() {
		locker = new ReentrantLock();
		condition = locker.newCondition();
	}

	public void get() {
		locker.lock();
		try {
			while (product < 1) {
				condition.await();
			}
			product--;
			System.out.println("Покупатель купил 1 товар");
			System.out.println("Товаров на складе: " + product);

			condition.signalAll();
		} catch (InterruptedException e) {
			System.out.println("Thread has been interrupted...");
		} finally {
			locker.unlock();
		}
	}

	public void put() {
		locker.lock();
		try {
			while (product >= 3) {
				condition.await();
			}
			product++;
			System.out.println("Производитель добавил 1 товар");
			System.out.println("Товаров на складе " + product);

			condition.signalAll();
		} catch (InterruptedException e) {
			System.out.println("Thread has been interrupted...");
		} finally {
			locker.unlock();
		}
	}
}

class Producer2 implements Runnable {
	Store2 store;

	Producer2(Store2 store) {
		this.store = store;
	}

	@Override
	public void run() {
		for (int i = 1; i < 6; i++) {
			store.put();
		}
	}
}

class Consumer2 implements Runnable {
	Store2 store;

	Consumer2(Store2 store) {
		this.store = store;
	}

	@Override
	public void run() {
		for (int i = 1; i < 6; i++) {
			store.get();
		}
	}
}

public class ConditionThreadApp13 {
	public static void main(String[] args) {
		Store2 store = new Store2();
		Producer2 producer = new Producer2(store);
		Consumer2 consumer = new Consumer2(store);
		new Thread(producer).start();
		new Thread(consumer).start();
	}
}
