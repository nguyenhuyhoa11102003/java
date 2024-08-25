package ADT.List;

import java.util.NoSuchElementException;

public class ListUsingArray<E> implements ListInterface<E> {

	private static final int MAXSIZE = 1000;
	private int num_nodes = 0;
	private E[] arr = (E[]) new Object[MAXSIZE];

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return num_nodes == 0;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return num_nodes;
	}

	@Override
	public E getFirst() throws NoSuchElementException {
		// TODO Auto-generated method stub
		if (num_nodes == 0)
			throw new NoSuchElementException("mang rong nen ko co phan tu dau tien");
		return arr[0];
	}

	@Override
	public boolean contains(E item) {
		// TODO Auto-generated method stub

		for (int i = 0; i < num_nodes; i++)
			if (arr[i].equals(item))
				return true;

		return false;
	}

	@Override
	public void addFirst(E item) {
		// TODO Auto-generated method stub
		if (num_nodes == MAXSIZE)
			throw new IndexOutOfBoundsException("het cho de them");

		for (int i = num_nodes - 1; i >= 0; i--)
			arr[i + 1] = arr[i];

		arr[0] = item;
		num_nodes++;
	}

	// hieu qua cham vi phai dich sang phai n lan

	public void add(int index, E item) throws IndexOutOfBoundsException {
		if (num_nodes == MAXSIZE) {
			throw new IndexOutOfBoundsException("vuot kich thuoc de them");
		}

		for (int i = num_nodes - 1; i >= index; i--) {
			arr[i + 1] = arr[i];
		}

		arr[index] = item;
		num_nodes++;
	}
	// nhanh hon

	@Override
	public void removeFirst() throws NoSuchElementException {
		// TODO Auto-generated method stub
		if (num_nodes == 0) {
			throw new IndexOutOfBoundsException("vuot kich thuoc de them");
		}

		for (int i = 0; i < num_nodes - 1; i++) {
			arr[i] = arr[i + 1];
		}

		num_nodes--;
	}

	public void remove(int index) throws NoSuchElementException {
		if (num_nodes == 0)
			throw new NoSuchElementException("mang rong nen ko co phan tu dau tien");

		for (int i = index; i < num_nodes - 1; i++)
			arr[i] = arr[i + 1];

		num_nodes--;
	}

	@Override
	public void print() {
		// TODO Auto-generated method stub
		if (num_nodes == 0)
			throw new NoSuchElementException("mang rong");
		for (int i = 0; i < num_nodes; i++)
			System.out.print(arr[i] + "\t");
	}

}
