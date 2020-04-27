package interview.ds.programs;

import java.util.LinkedList;

public class MyQueue<E> {
	private LinkedList<E> list;

	public MyQueue() {
		list = new LinkedList<E>();
	}

	public void push(E element) {
		list.add(list.size(), element);
	}

	public E pop() {
		return list.remove(0);
	}

	public E peek() {
		return list.get(0);
	}

	public boolean empty() {
		return list.isEmpty();

	}
}
