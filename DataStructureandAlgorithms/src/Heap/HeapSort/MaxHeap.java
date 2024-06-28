package Heap.HeapSort;

public class MaxHeap {

	public int[] a;
	public int size;

	public MaxHeap(int capity) {
		a = new int[capity];
		size = -1;
	}

	private int parent(int i) {
		return (i - 1) / 2;
	}

	private int left(int i) {
		return 2 * i + 1;
	}

	private int right(int i) {
		return 2 * i + 2;
	}

	private void swap(int i, int j) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}

	public void insert(int value) {
		size++;
		a[size] = value;

		shiftUp(size);
	}

	private void shiftUp(int i) {
		while (i > 0 && a[parent(i)] < a[i]) {
			swap(parent(i), i);
			i = parent(i);
		}
	}

	public int extractMax() {
		int max = a[0];

		a[0] = a[size];
		size--;

		shiftDown(0);
		return max;
	}

	private void shiftDown(int i) {
		int maxIndex = i;

		if (left(i) <= size && a[maxIndex] < a[left(i)])
			maxIndex = left(i);

		if (right(i) <= size && a[maxIndex] < a[right(i)])
			maxIndex = right(i);

		if (maxIndex != i) {
			swap(maxIndex, i);
			shiftDown(maxIndex);
		}
	}

	public void print() {
		for (int i = 0; i <= size; i++)
			System.out.print(a[i] + " ");
		System.out.println();
	}

}