package MultithreadedProgramming;

class JThread2 extends Thread {
	//Завершение потока метод interrupt()
	JThread2(String name) {
		super(name);
	}

	@Override
	public void run() {
		System.out.printf("%s started... \n", Thread.currentThread().getName());
		int counter = 1;
		//Или while (!Thread.currentThread().isInterrupted())
		while (!isInterrupted()) {
			System.out.println("Loop " + counter++);
			//Обрабатываем в цикле исключение InterruptedException в блоке catch, то при перехвате
			// исключения статус потока автоматически сбрасывается, и после этого isInterrupted
			// будет возвращать false.
//			try {
//				Thread.sleep(100);
//			} catch (InterruptedException e) {
//				System.out.println(getName() + " has been interrupted");
			//Либо сразу же в блоке catch выйти из цикла с помощью break:
//			break;
//				System.out.println(isInterrupted());
//				interrupt();
//			}
		}
		System.out.printf("%s finished... \n", Thread.currentThread().getName());
	}

//	public void run() {
//		System.out.printf("%s started... \n", Thread.currentThread().getName());
//		int counter = 1;
	//Бесконечный цикл помещен в конструкцию try...catch
	// достаточно обработать InterruptedException:
//		try {
//			while (!isInterrupted()) {
//				System.out.println("Loop " + counter++);
//				Thread.sleep(100);
//			}
//		} catch (InterruptedException e) {
//			System.out.println(getName() + " has been interrupted");
//		}
//
//		System.out.printf("%s finished... \n", Thread.currentThread().getName());
//	}
}

public class InterruptThreadApp5 {
	public static void main(String[] args) {
		System.out.println("Main thread started...");
		JThread2 t = new JThread2("JThread");
		t.start();
		try {
			Thread.sleep(150);
			t.interrupt();
			Thread.sleep(150);
		} catch (InterruptedException e) {
			System.out.println("Thread has been interrupted...");
		}
		System.out.println("Thread has been finished...");
	}
}
