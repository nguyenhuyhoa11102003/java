package LinkedList.DoublyLinkedList;

public class Node<E> {

	private E value;
	public Node<E> pBack;
	public Node<E> pNext;

	public Node(E value) {
		this(value, null, null);
	}

	public Node(E value, Node<E> back, Node<E> next) {
		this.value = value;
		this.pBack = back;
		this.pNext = next;
	}

	public E getValue() {
		return value;
	}

	public Node<E> getPBack() {
		return pBack;
	}

	public Node<E> getPNext() {
		return pNext;
	}

	public void setValue(E value) {
		this.value = value;
	}

	public void setPBack(Node<E> pBack) {
		this.pBack = pBack;
	}

	public void setPNext(Node<E> pNext) {
		this.pNext = pNext;
	}
}
