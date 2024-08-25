package SortAlgorithms;

public class BubbleSort {
	public static void main(String[] args) {
		int[] a = new int[] { 1, 3, 4, 6, 7, 2, 5, 8, 10, 9 };
		int temp;
		for (int i = 0; i < a.length - 1; i++) {
			for (int k = 0; k < a.length - i - 1; k++) {
				if (a[k] > a[k + 1]) {
					temp = a[k];
					a[k] = a[k + 1];
					a[k + 1] = temp;
				}
			}
		}
		for (int i : a)
			System.out.println(i);
	}
}
