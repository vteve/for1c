package number1122;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(relativeSortArray(new int[]{28, 6, 22, 8, 44, 17}, new int[]{22, 28, 8, 6})));
    }

    public static int[] relativeSortArray(int[] arr1, int[] arr2) {
        int indexFilled = 0;
        for (int k : arr2) {
            for (int j = indexFilled; j < arr1.length; j++) {
                if (arr1[j] == k) {
                    int temporaryNumber = arr1[indexFilled];
                    arr1[indexFilled] = arr1[j];
                    arr1[j] = temporaryNumber;
                    indexFilled++;
                }
            }
        }
        Arrays.sort(arr1, indexFilled, arr1.length);
        return arr1;
    }
}
