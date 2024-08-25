package SortAlgorithms;

public class MergeSort {

	static void merge(int a[], int l, int m, int r) {
		int i, j, k;
		int n1 = m - l + 1;
		int n2 = r - m;

		// Tao 2 mang tam L, R
		int[] L = new int[n1];
		int[] R = new int[n2];

		// Copy du lieu sang cac mang tam
		for (i = 0; i < n1; i++)
			L[i] = a[l + i];
		for (j = 0; j < n2; j++)
			R[j] = a[m + 1 + j];

		// Gop 2 mang tam L, R vao mang a
		i = 0; // Khoi tao chi so bat dau cua mang con dau tien
		j = 0; // Khoi tao chi so bat dau cua mang con thu hai
		k = l; // Khoi tao chi so bat dau cua mang luu ket qua

		while (i < n1 && j < n2) {
			// sap xep tang dan
			if (L[i] <= R[j]) // giam dan: L[i] >= R[j]
			{
				a[k] = L[i];
				i++;
			} else {
				a[k] = R[j];
				j++;
			}

			k++;
		}

		// Copy cac phan tu con lai cua mang L vao a (neu co)
		while (i < n1) {
			a[k] = L[i];
			i++;
			k++;
		}

		// Copy cac phan tu con lai cua mang R vao a (neu co)
		while (j < n2) {
			a[k] = R[j];
			j++;
			k++;
		}
	}

	// l la chi so trai, r la chi so phai cua mang can duoc sap xep
	static void mergeSort(int a[], int l, int r) {
		if (l < r) {
			int m = l + (r - l) / 2; // = (l+r)/2, nhung dung cach nay de tranh tran so khi l va r lon

			// Goi de quy de tiep tuc chia mang
			mergeSort(a, l, m);
			mergeSort(a, m + 1, r);

			merge(a, l, m, r);
		}
	}

	static void printArray(int[] a) {
		for (int i : a)
			System.out.print(i + " ");

		System.out.println();
	}

	// BigO nlogn
	public static void main(String[] args) {
		int[] a = new int[] { 12, 11, 13, 5, 6, 7 };

		System.out.print("Mang da cho: ");
		printArray(a);

		mergeSort(a, 0, a.length - 1);

		System.out.print("Mang sau khi sap xep: ");
		printArray(a);
	}

}
