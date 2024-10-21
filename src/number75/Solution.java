package number75;

public class Solution {
    public static void main(String[] args) {
        int[] array = {17, 14, 15, 28, 6, 8, -6, 1, 3, 18};
        sortColors(array);
    }
    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);


            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }


    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = (low - 1);
        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;


                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }


        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;


        return i + 1;
    }

    public static void sortColors(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
    }
}
