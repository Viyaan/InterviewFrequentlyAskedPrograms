package interview.ds.programs;

import java.util.HashSet;

//A complete working Java program to demonstrate all insertion methods
//on linked list
class LinkedList {
	static Node head; // head of list

	/* Linked list Node */
	static class Node {
		int data;
		Node next;

		Node(int d) {
			data = d;
			next = null;
		}
	}

	/* Inserts a new Node at front of the list. */
	public void push(int new_data) {
		/* 1 & 2: Allocate the Node & Put in the data */
		Node new_node = new Node(new_data);

		/* 3. Make next of new Node as head */ new_node.next = head;

		/* 4. Move the head to point to new Node */
		head = new_node;
	}

	/* Inserts a new node after the given prev_node. */
	public void insertAfter(Node prev_node, int new_data) {
		/* 1. Check if the given Node is null */
		if (prev_node == null) {
			System.out.println("The given previous node cannot be null");
			return;
		}

		/* 2 & 3: Allocate the Node & Put in the data */
		Node new_node = new Node(new_data);

		/* 4. Make next of new Node as next of prev_node */ new_node.next = prev_node.next;

		/* 5. make next of prev_node as new_node */ prev_node.next = new_node;
	}

	/*
	 * Appends a new node at the end. This method is defined inside LinkedList class
	 * shown above
	 */
	public void append(int new_data) {
		/*
		 * 1. Allocate the Node & 2. Put in the data 3. Set next as null
		 */
		Node new_node = new Node(new_data);

		/* 4. If the Linked List is empty, then make the new node as head */
		if (head == null) {
			head = new Node(new_data);
			return;
		}

		/* 4. This new node is going to be the last node, so make next of it as null */
		new_node.next = null;

		/* 5. Else traverse till the last node */ Node last = head;
		while (last.next != null)
			last = last.next;

		/* 6. Change the next of last node */ last.next = new_node;
		return;
	}

	/* This function prints contents of linked list starting from the given node */
	public void printList() {
		Node tnode = head;
		while (tnode != null) {
			System.out.print(tnode.data + " ");
			tnode = tnode.next;
		}
	}

	void deleteNode(int position) {
//If linked list is empty
		if (head == null)
			return;

//Store head node
		Node temp = head;

//If head needs to be removed
		if (position == 0) {
			head = temp.next; // Change head
			return;
		}

//Find previous node of the node to be deleted
		for (int i = 0; temp != null && i < position - 1; i++)
			temp = temp.next;

//If position is more than number of ndoes
		if (temp == null || temp.next == null)
			return;

//Node temp->next is the node to be deleted
//Store pointer to the next of node to be deleted 
		Node next = temp.next.next;

		temp.next = next; // Unlink the deleted node from list
	}

	Node reverse(Node node) {
		Node prev = null;
		Node current = node;
		Node next = null;
		while (current != null) {
			next = current.next;
			current.next = prev;
			prev = current;
			current = next;
		}
		node = prev;
		return node;
	}

	static boolean detectLoop(Node h) {
		HashSet<Node> s = new HashSet<Node>();
		while (h != null) {
//If we have already has this node
//in hashmap it means their is a cycle
//(Because you we encountering the
//node second time).
			if (s.contains(h))
				return true;

//If we are seeing the node for
//the first time, insert it in hash s.add(h);

			h = h.next;
		}

		return false;

	}

	void printList(Node node) {
		while (node != null) {
			System.out.print(node.data + " ");
			node = node.next;
		}
	}

	/*
	 * Driver program to test above functions. Ideally this function should be in a
	 * separate user class. It is kept here to keep code compact
	 */
	public static void main(String[] args) {
		/* Start with the empty list */
		LinkedList llist = new LinkedList();

//Insert 6. So linked list becomes 6->NUllist 
		llist.append(6);

//Insert 7 at the beginning. So linked list becomes
//7->6->NUllist 
		llist.push(7);

//Insert 1 at the beginning. So linked list becomes
//1->7->6->NUllist 
		llist.push(1);

//Insert 4 at the end. So linked list becomes
//1->7->6->4->NUllist
		llist.append(4);

//Insert 8, after 7. So linked list becomes
//1->7->8->6->4->NUllist
		llist.insertAfter(llist.head.next, 8);

		llist.deleteNode(1);

		System.out.println("\nCreated Linked list is: ");
		llist.printList();

		llist.head = new Node(85);
		llist.head.next = new Node(15);
		llist.head.next.next = new Node(4);
		llist.head.next.next.next = new Node(20);

		System.out.println("Given Linked list");
		llist.printList(head);
		head = llist.reverse(head);
		System.out.println("");
		System.out.println("Reversed linked list ");
		llist.printList(head);
		/* Create loop for testing */
		llist.head.next.next.next.next = llist.head;
		if (detectLoop(head))
			System.out.println("\nLoop found");
		else
			System.out.println("No Loop");
	}
}
