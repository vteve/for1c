package number34;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(searchRange(new int[]{5, 7, 7, 8, 8, 10}, 8)));
    }

    public static int[] searchRange(int[] nums, int target) {
        int[] answer = new int[2];
        int right = nums.length - 1;
        int left = 0;
        int middle, lowIndex = -1, highIndex = -1;
        while (left <= right) {
            middle = left + (right - left) / 2;
            if (nums[middle] >= target) {
                lowIndex = middle;
                right = middle - 1;
            } else {
                left = middle + 1;
            }
        }
        left = 0;
        right = nums.length - 1;
        while (left <= right) {
            middle = left + (right - left) / 2;
            if (nums[middle] <= target) {
                highIndex = middle;
                left = middle + 1;
            } else {
                right = middle - 1;
            }
        }
        if (lowIndex != -1 && highIndex != -1 && nums[lowIndex] == target && nums[highIndex] == target) {
            answer[0] = lowIndex;
            answer[1] = highIndex;
        } else {
            answer[0] = -1;
            answer[1] = -1;
        }
        return answer;
    }
}
