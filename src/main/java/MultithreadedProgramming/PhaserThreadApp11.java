package MultithreadedProgramming;

import java.util.concurrent.Phaser;

class PhaseThread implements Runnable {
	Phaser phaser;
	String name;

	PhaseThread(Phaser p, String n) {
		this.phaser = p;
		this.name = n;
		phaser.register();
	}

	@Override
	public void run() {
		//Первая фаза достигнута
		System.out.println(name + " выполняет фазу " + phaser.getPhase());
		phaser.arriveAndAwaitAdvance();
		try {
			Thread.sleep(100);
		} catch (InterruptedException ex) {
			System.out.println(ex.getMessage());
		}

		//Вторая фаза достигнута
		System.out.println(name + " выполняет фазу " + phaser.getPhase());
		phaser.arriveAndAwaitAdvance();
		try {
			Thread.sleep(100);
		} catch (InterruptedException ex) {
			System.out.println(ex.getMessage());
		}

		//Завершение фаз и удаление с регистрации
		System.out.println(name + " выполняет фазу " + phaser.getPhase());
		phaser.arriveAndDeregister();
	}
}

public class PhaserThreadApp11 {
	public static void main(String[] args) {
		Phaser phaser = new Phaser(1);
		new Thread(new PhaseThread(phaser, "PhaseThread 1")).start();
		new Thread(new PhaseThread(phaser, "PhaseThread 2")).start();

		//Фаза 0
		int phase = phaser.getPhase();
		phaser.arriveAndAwaitAdvance();
		System.out.println("Фаза " + phase + " завершена");

		//Фаза 1
		phase = phaser.getPhase();
		phaser.arriveAndAwaitAdvance();
		System.out.println("Фаза " + phase + " завершена");

		//Фаза 2
		phase = phaser.getPhase();
		phaser.arriveAndAwaitAdvance();
		System.out.println("Фаза " + phase + " завершена");

		phaser.arriveAndDeregister();
	}
}
