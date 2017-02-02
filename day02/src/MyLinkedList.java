public class MyLinkedList<T> {

	private Node head;
	private Node tail;
	private int size;

	private class Node {
		T val;
		Node prev;
		Node next;

		private Node(T d, Node prev, Node next) {
			this.val = d;
			this.prev = prev;
			this.next = next;
		}
	}

	public MyLinkedList() {
		head = null;
		tail = null;
		size = 0;
	}

	public int size() {
		return size;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public void add(T c) {
		addLast(c);
	}

	public T pop() {
		return removeLast();
	}

	public void addLast(T c) {
		if (isEmpty()){
			head = new Node(c, null,null);
			tail = head;
		}
		else {
			tail.next = new Node(c, tail, null);
			tail = tail.next;
		}
		size++;
	}

	public void addFirst(T c) {
		if (isEmpty()){
			head = new Node(c, null,null);
			tail = head;
		}
		else {
			head = new Node(c, null, head);
		}
		size++;
	}

	public T get(int index) {
		if (index > size || index < 0){
			throw new IndexOutOfBoundsException();
		}
		else {
			Node temp = head;
			for (int i = 0; i < index; i++) {
				temp = temp.next;
			}
			return temp.val;
		}
	}

	public T remove(int index) {
		if (index == 0){
			return removeFirst();
		}
		if (index == (size-1)){
			return removeLast();
		}
		else{
			Node temp = head;
			for (int i = 0; i < index; i++) {
				temp = temp.next;
			}
			temp.prev.next = temp.next;
			temp.next.prev = temp.prev;
			size--;
			// should probbly use get to check for index out of bounds
			return temp.val;
		}
	}

	public T removeFirst() {
		if (isEmpty()){
			return null;
		}
		else{
			Node temp = head;
			if (size == 1){
				head = null;
				tail = null;
			}
			else{
				head = head.next;
				head.prev = null;
			}
			size--;
			return temp.val;
		}
	}

	public T removeLast() {
		if (isEmpty()){
			return null;
		}
		else{
			Node temp = tail;
			if (size == 1){
				head = null;
				tail = null;
			}
			else{
				tail = tail.prev;
				tail.next = null;
			}
			size--;
			return temp.val;
		}
	}
}