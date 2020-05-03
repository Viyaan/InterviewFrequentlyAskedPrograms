package interview.ds.programs;

public class QueueImpl {
	private int capacity; // maximum capacity of the queue
	int queueArr[]; // array to store queue elements
	int front; // front points to front element in the queue
	int rear; // rear points to last element in the queue
	int currentSize; // current size of the queue

	public QueueImpl(int queueSize) {
		this.capacity = queueSize;
		queueArr = new int[this.capacity];
		front = 0;
		rear = -1;
		currentSize = 0;
	}

	/**
	 * this method adds element at the end of the queue.
	 * 
	 * @param item
	 */
	public void enqueue(int item) {
		if (isQueueFull()) {
			System.out.println("Overflow ! Unable to add element: " + item);
		} else {
			rear++;
			queueArr[rear] = item;
			currentSize++;
			System.out.println("Element " + item + " is pushed to Queue !");
		}
	}

	/**
	 * this method removes an element from the top of the queue
	 */
	public void dequeue() {
		if (isQueueEmpty()) {
			System.out.println("Underflow ! Unable to remove element from Queue");
		} else {
			System.out.println("Pop operation done ! removed: " + queueArr[front++]);
			currentSize--;
		}
	}

	/**
	 * This method checks whether the queue is full or not
	 * 
	 * @return boolean
	 */
	public boolean isQueueFull() {
		boolean status = false;
		if (currentSize == capacity) {
			status = true;
		}
		return status;
	}

	/**
	 * This method checks whether the queue is empty or not
	 * 
	 * @return
	 */
	public boolean isQueueEmpty() {

		boolean status = false;
		if (currentSize == 0) {
			status = true;
		}
		return status;
	}

	// Utility function to return the size of the queue
	public int size() {
		return currentSize;
	}

	// Utility function to return front element in the queue
	public int peek() {
		if (isQueueEmpty()) {
			System.out.println("UnderFlow\nProgram Terminated");
			System.exit(1);
		}
		return queueArr[front];
	}

	// Queue implementation in java
	public static void main(String[] args) {
		// create a queue of capacity 5
		QueueImpl q = new QueueImpl(5);

		q.enqueue(1);
		q.enqueue(2);
		q.enqueue(3);

		System.out.println("Front element is: " + q.peek());
		q.dequeue();
		System.out.println("Front element is: " + q.peek());

		System.out.println("Queue size is " + q.size());

		q.dequeue();
		q.dequeue();

		if (q.isQueueEmpty())
			System.out.println("Queue Is Empty");
		else
			System.out.println("Queue Is Not Empty");
	}
}
