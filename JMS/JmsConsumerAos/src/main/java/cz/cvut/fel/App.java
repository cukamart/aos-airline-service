package cz.cvut.fel;

public class App {
	public static void main(String[] args) throws InterruptedException {
		Consumer consumer = new Consumer();
		while (true) {
			Thread.sleep(5000);
			if (consumer.getMessage() == null) {
				// break;
			}
		}
	}
}
