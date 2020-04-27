package interview.thread.programs;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierDemo {
	public static void main(String args[]) throws InterruptedException {

		CyclicBarrier barrier = new CyclicBarrier(4);

		CyclicWorker first = new CyclicWorker(1000, barrier, "WORKER-1");
		CyclicWorker second = new CyclicWorker(2000, barrier, "WORKER-2");
		CyclicWorker third = new CyclicWorker(3000, barrier, "WORKER-3");
		CyclicWorker fourth = new CyclicWorker(4000, barrier, "WORKER-4");
		first.start();
		second.start();
		third.start();
		fourth.start();
	}
}

// A class to represent threads for which
// the main thread waits.
class CyclicWorker extends Thread {
	private int delay;
	private CyclicBarrier barrier;

	public CyclicWorker(int delay, CyclicBarrier barrier, String name) {
		super(name);
		this.delay = delay;
		this.barrier = barrier;
	}

	@Override
	public void run() {
		try {

			Thread.sleep(delay);
			System.out.println(Thread.currentThread().getName() + " reached");
			barrier.await();
			System.out.println(Thread.currentThread().getName() + " finished");
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (BrokenBarrierException e) {
			e.printStackTrace();
		}
	}
}
