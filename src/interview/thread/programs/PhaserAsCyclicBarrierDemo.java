package interview.thread.programs;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Phaser;

public class PhaserAsCyclicBarrierDemo {
	public static void main(String args[]) throws InterruptedException {

		ExecutorService executor = Executors.newFixedThreadPool(4);
		Phaser phaser = new Phaser(3);

		executor.submit(new PhaserWorker(phaser, 1000));
		executor.submit(new PhaserWorker(phaser, 2000));
		executor.submit(new PhaserWorker(phaser, 3000));

		// phaser.awaitAdvance(1);

		System.out.println(Thread.currentThread().getName() + " has finished");
	}
}

//A class to represent threads for which
//the main thread waits.
class PhaserWorker implements Runnable {
	private Phaser phaser;
	private int delay;

	public PhaserWorker(Phaser phaser, int delay) {
		this.delay = delay;
		this.phaser = phaser;
	}

	@Override
	public void run() {
		try {
			Thread.sleep(delay);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName() + " reached");
		phaser.arriveAndAwaitAdvance();
		System.out.println(Thread.currentThread().getName() + " finished");

	}
}
