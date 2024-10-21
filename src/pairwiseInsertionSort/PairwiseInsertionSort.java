package pairwiseInsertionSort;


public class PairwiseInsertionSort {

    public static void pairwiseInsertionSort(int[] a) {
        int left = 1, right = 2;
        for (int k = left; ++left <= right; k = ++left) {

            int a1 = a[k], a2 = a[left];
            if (a1 < a2) {
                a2 = a1;
                a1 = a[left];
            }

            while (a1 < a[--k]) {
                a[k + 2] = a[k];
            }
            a[++k + 1] = a1;

            while (a2 < a[--k]) {
                a[k + 1] = a[k];
            }
            a[k + 1] = a2;
        }

        int last = a[right];
        while (last < a[--right]) {
            a[right + 1] = a[right];
        }
        a[right + 1] = last;
    }

    public static void main(String[] args) {
        int[] arr = {12, 5, 13, 11, 6, 7, 9};
        System.out.println("Array before sorting:");
        printArray(arr);
        pairwiseInsertionSort(arr);
        System.out.println("Array after sorting:");
        printArray(arr);
    }

    public static void printArray(int[] arr) {
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}



