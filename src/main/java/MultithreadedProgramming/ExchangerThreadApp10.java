package MultithreadedProgramming;

import java.util.concurrent.Exchanger;

class PutThread implements Runnable {
	Exchanger<String> exchanger;
	String message;

	PutThread(Exchanger<String> ex) {
		this.exchanger = ex;
		message = "Hello Java!";
	}

	@Override
	public void run() {
		try {
			message = exchanger.exchange(message);
			System.out.println("PutThread has received: " + message);
		} catch (InterruptedException ex) {
			System.out.println(ex.getMessage());
		}
	}
}

class GetThread implements Runnable {
	Exchanger<String> exchanger;
	String message;

	GetThread(Exchanger<String> ex) {
		this.exchanger = ex;
		message = "Hello World!";
	}

	@Override
	public void run() {
		try {
			message = exchanger.exchange(message);
			System.out.println("GetThread has received: " + message);
		} catch (InterruptedException ex) {
			System.out.println(ex.getMessage());
		}
	}
}

public class ExchangerThreadApp10 {
	public static void main(String[] args) {
		Exchanger<String> ex = new Exchanger<>();
		new Thread(new PutThread(ex)).start();
		new Thread(new GetThread(ex)).start();
	}
}
