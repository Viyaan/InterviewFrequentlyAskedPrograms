package interview.thread.programs;

import java.util.LinkedList;

/**
 * @author Viyaan
 * 
 *         The producer-consumer problem (also known as the bounded-buffer
 *         problem) is a classic Java Example of a multi-process synchronization
 *         problem.
 * 
 *         The problem describes two processes, the producer and the consumer,
 *         who share a common, fixed-size buffer used as a queue or linkedlist.
 *         The producer’s job is to generate a piece of data, put it into the
 *         buffer and start again.
 * 
 *         At the same time, the consumer is consuming the data (i.e., removing
 *         it from the buffer) one piece at a time. The problem is to make sure
 *         that the producer won’t try to add data into the buffer if it’s full
 *
 */
public class ProducerConsumerMultiThread {
	public static void main(String[] args) throws InterruptedException {
		ProducerConsumerMultiThread.PCBuffer pc = new ProducerConsumerMultiThread().new PCBuffer();
		Runnable runProducer = () -> {
			try {
				pc.produce();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		};

		Runnable runConsumer = () -> {
			try {
				pc.consume();
				;
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		};

		Thread t1 = new Thread(runProducer);
		Thread t2 = new Thread(runConsumer);
		t1.start();
		t2.start();
		t1.join();
		t2.join();
	}

	class PCBuffer {
		LinkedList<Integer> list = new LinkedList<>();
		int capacity = 2;

		// Function called by producer thread
		public void produce() throws InterruptedException {
			int value = 0;
			while (true) {
				synchronized (this) {
					// producer thread waits while list is full
					while (list.size() == capacity) {
						wait();
					}
					System.out.println("Producer produced-" + value);
					// to insert the jobs in the list
					list.add(value++);
					// notifies the consumer thread that now it can start consuming
					notify();
					// makes the working of program easier to understand
					Thread.sleep(2000);
				}
			}
		}

		// Function called by consumer thread
		public void consume() throws InterruptedException {
			while (true) {
				synchronized (this) {
					// consumer thread waits while list is empty
					while (list.size() == 0) {
						wait();
					}
					// to retrive the ifrst job in the list
					int val = list.removeFirst();
					System.out.println("Consumer consumed-" + val);
					// Wake up producer thread
					notify();
					Thread.sleep(2000);
				}
			}
		}
	}
}