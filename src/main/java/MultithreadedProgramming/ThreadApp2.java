package MultithreadedProgramming;

public class ThreadApp2 {
	public static void main(String[] args) {
		//Поток main закрывается самым последним после работы дочернего
		System.out.println("Main thread started...");
		JThread newThread = new JThread("JThread");
		newThread.start();
		try {
			newThread.join();
		} catch (InterruptedException e) {
			System.out.printf("%s has been interrupted", newThread.getName());
		}
		System.out.println("Main thread finished...");
	}
}
