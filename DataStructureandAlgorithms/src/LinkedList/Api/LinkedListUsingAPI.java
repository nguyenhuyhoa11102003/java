package LinkedList.Api;

import java.util.*;

public class LinkedListUsingAPI {
	public static void main(String[] args) {
		LinkedList<Integer> list = new LinkedList<>();
		list.addFirst(1);
		list.addFirst(2);
		list.addFirst(3);
		list.addLast(4);

		System.out.println("LinkedList: " + list);
		System.out.println("size = " + list.size());
		System.out.println("First = " + list.getFirst());
		System.out.println("isContains 5 = " + list.contains(5));
		System.out.println("isEmpty = " + list.isEmpty());
		list.removeFirst();
		System.out.println("LinkedList after removeFirst: " + list);

	}
}
