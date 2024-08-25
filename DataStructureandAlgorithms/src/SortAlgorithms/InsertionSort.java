package SortAlgorithms;

//Insertion Sort la giai thuat lay cam hung tu tro choi danh bai, rut bai len va sap xep
public class InsertionSort {

    static void print(int[] a) {
        for (int i : a)
            System.out.print(i + " ");

        System.out.println();
    }

    /**
     * 
     * @param args
     * 
     *             bestCase : O(n) :when array sorted
     *             average :n binh when random
     *             worst case : n binh : when reverse
     *
     */

    public static void main(String[] args) {
        int[] a = new int[] { 5, 4, 6, 8, 2, 1, 10 };
        System.out.print("Mang da cho: ");
        print(a);

        for (int i = 1; i < a.length; i++) {
            int key = a[i];
            int j = i - 1;

            while (j >= 0 && a[j] > key) {
                a[j + 1] = a[j];
                j--;
            }
            a[j + 1] = key;
        }

        print(a);

    }

}
